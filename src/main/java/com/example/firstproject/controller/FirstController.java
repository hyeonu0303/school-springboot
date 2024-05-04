package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model mo){
        mo.addAttribute("username", "혀누");
        return "greetings";
    }

    @GetMapping("/")
    public String welcomePage() { return "home"; }

    @GetMapping("/bye")
    public String goodbyePage(Model mo) {
        mo.addAttribute("username", "혀누");
        return "goodbye"; }
}
