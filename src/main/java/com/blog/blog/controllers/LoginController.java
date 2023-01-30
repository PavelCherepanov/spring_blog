package com.blog.blog.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Pavel
 * @version 1.0
 * @date 30.01.2023 00:26
 */
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(Model model){
        return "login";
    }


}
