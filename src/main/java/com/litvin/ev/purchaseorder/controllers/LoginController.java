package com.litvin.ev.purchaseorder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@Controller
public class LoginController {

    @GetMapping
    public String showLoginPage() {
        return "login";
    }
}
