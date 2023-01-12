package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.repository.BarRepository;

@Controller
public class BarController {
    @Autowired
    private BarRepository barRepository;

    @GetMapping("/bars")
    public String getAll(Model model) {
        model.addAttribute("bars", barRepository.findAll());
        return "bars";
    }
}
