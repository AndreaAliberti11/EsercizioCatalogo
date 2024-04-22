package com.example.EsercizioCatalogo.controller;

import com.example.EsercizioCatalogo.model.Articolo;
import com.example.EsercizioCatalogo.service.ArticoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// localhost:8080
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ArticoloService articoloService;

    @GetMapping
    public String getIniziale(Model model) {

        List<Articolo> articoli = articoloService.getArticoli();
        model.addAttribute("articoli", articoli);
        return "index";
    }

}