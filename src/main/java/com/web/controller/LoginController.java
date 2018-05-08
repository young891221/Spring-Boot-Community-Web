package com.web.controller;

import com.web.annotation.SocialUser;
import com.web.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by KimYJ on 2017-09-13.
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String loginComplete() {
        return "redirect:/board/list";
    }
}

