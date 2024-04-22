package com.example.EsercizioCatalogo.controller;

import com.example.EsercizioCatalogo.model.Articolo;
import com.example.EsercizioCatalogo.service.ArticoloService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// localhost:8080/dettaglio
@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {

    @Autowired
    private ArticoloService articoloService;

    @GetMapping
    public String getDettaglio(@RequestParam("id") int id, Model model, @RequestParam(value = "add", required = false) String add) {

        Articolo articolo = articoloService.getArticoliById(id);
        model.addAttribute("articolo", articolo);
        model.addAttribute("add", add);
        return "dettaglio";
    }

    @GetMapping("/aggiungi")
    public String aggiungi(@RequestParam("id") int id, HttpSession session) {

        if(!articoloService.aggiungiCarrello(id, session))
            return "redirect:/dettaglio?id=" + id + "&add=no";
        return "redirect:/dettaglio?id=" + id + "&add=yes";
    }

}