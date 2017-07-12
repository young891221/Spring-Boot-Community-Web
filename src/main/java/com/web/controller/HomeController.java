package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by KimYJ on 2017-07-12.
 */
@Controller
public class HomeController {

    @GetMapping("")
    public String home() {
        return "home";
    }

}
