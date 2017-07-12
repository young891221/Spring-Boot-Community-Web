package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by KimYJ on 2017-07-12.
 */
@Controller
@RequestMapping("board")
public class BoardController {

    @GetMapping("")
    public String board() {
        return "/board/form";
    }
}
