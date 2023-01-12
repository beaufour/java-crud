package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Bar;
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

    @GetMapping("/bars/{id}")
    public String getOne(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Bar bar = barRepository.findById(id).get();
            model.addAttribute("bar", bar);
            return "bar";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/bars";
        }
    }
}
