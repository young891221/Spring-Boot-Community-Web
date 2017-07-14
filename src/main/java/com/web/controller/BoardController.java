package com.web.controller;

import com.web.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by KimYJ on 2017-07-12.
 */
@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/{idx}")
    public String board(@PathVariable Long idx, Model model) {
        model.addAttribute("board", boardService.findBoardByIdx(idx));
        return "/board/form";
    }

    @GetMapping("/list")
    public String list(@PageableDefault Pageable pageable, Model model) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "/board/list";
    }


}
