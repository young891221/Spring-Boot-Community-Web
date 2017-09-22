package com.web.controller;

import com.web.annotation.SocialUser;
import com.web.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by KimYJ on 2017-09-13.
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "/login/login";
    }

    @GetMapping(value = "/{facebook|google|kakao}/complete")
    public String facebookComplete(@SocialUser User user, HttpSession session) {
        session.setAttribute("user", user);
        return "/login/complete";
    }
}
