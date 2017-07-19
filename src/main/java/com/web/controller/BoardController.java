package com.web.controller;

import com.web.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by KimYJ on 2017-07-12.
 */
@Controller
@RequestMapping("/board") //기본 맵핑 경로를 /board로 정의해 준다
public class BoardController {

    @Autowired
    BoardService boardService; //boardService 의존성 주입을 위해 @Autowired 의존성을 사용하여 의존성을 찾아옵니다

    @GetMapping({"", "/"}) //맵핑 경로를 중괄호를 사용하여 여러개를 받을 수 있습니다
    public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) { //@RequestParam 어노테이션을 사용하여 idx 파라미터를 필수로 받습니다. 만약 값이 없더라도 디폴트 값을 0으로 설정하여 model에 null값을 반환하도록 정의하였습니다
        model.addAttribute("board", boardService.findBoardByIdx(idx));
        return "/board/form";
    }

    @GetMapping("/list")
    public String list(@PageableDefault Pageable pageable, Model model) { //@PageableDefault 어노테이션의 파라미터인 size, sort, direction 등을 사용하여 페이징 처리에 대한 규약을 정의할 수 있습니다
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "/board/list";
    }

}
