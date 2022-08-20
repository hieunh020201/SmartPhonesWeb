package com.hieunh.SmartPhonesWeb.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("")
    public String ViewHome(){
        return "index";
    }

    @GetMapping("/403")
    public String ViewAccessDenied() {
        return "error/403Page";
    }
}
