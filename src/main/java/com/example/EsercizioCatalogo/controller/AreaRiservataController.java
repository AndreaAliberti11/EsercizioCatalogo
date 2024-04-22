package com.example.EsercizioCatalogo.controller;

import com.example.EsercizioCatalogo.dao.UtenteDao;
import com.example.EsercizioCatalogo.model.Utente;
import com.example.EsercizioCatalogo.service.ArticoloService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// localhost:8080/areariservata
@Controller
@RequestMapping("/areariservata")
public class AreaRiservataController {

    @Autowired
    private ArticoloService articoloService;

    @GetMapping
    public String getPage(HttpSession session, Model model) {

        if(session.getAttribute("utente") == null)
            return "redirect:/loginutente";
        Utente utente = (Utente) session.getAttribute("utente");
        model.addAttribute("utente", utente);
        model.addAttribute("carrello", articoloService.getCarrello(session));
        model.addAttribute("total", articoloService.totaleCarrello(session));
        return "areariservata";
    }

    @GetMapping("/logout")
    public String getOut(HttpSession session) {

        session.removeAttribute("utente");
        return "redirect:/";
    }

    @GetMapping("/rimuovi")
    public String rimuoviArticolo(@RequestParam("id") int idArticolo, HttpSession session) {

        articoloService.rimuoviCarrello(idArticolo, session);
        return "redirect:/areariservata";
    }

}