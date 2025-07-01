package com.bibliotheque.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("message", "Bienvenue dans la Bibliothèque !");
        return "index"; // Correspond à /WEB-INF/jsp/index.jsp
    }
}
