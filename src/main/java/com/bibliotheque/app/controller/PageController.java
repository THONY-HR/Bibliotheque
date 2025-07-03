package com.bibliotheque.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("message", "ADMINISTRATEUR");
        return "index"; // Correspond à /WEB-INF/jsp/index.jsp
    }
}
