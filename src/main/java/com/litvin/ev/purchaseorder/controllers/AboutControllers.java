package com.litvin.ev.purchaseorder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/about")
@Controller
public class AboutControllers {

    @GetMapping
    public String showAboutPage() {
        return "about";
    }
}
