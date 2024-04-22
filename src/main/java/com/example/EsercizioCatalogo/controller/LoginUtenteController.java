package com.example.EsercizioCatalogo.controller;

import com.example.EsercizioCatalogo.service.UtenteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// localhost:8080/loginutente
@Controller
@RequestMapping("/loginutente")
public class LoginUtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public String getPage(@RequestParam(value = "error", required = false) String error, HttpSession session, Model model) {

        if(session.getAttribute("utente") != null)
            return "redirect:/areariservata";
        model.addAttribute("error", error);
        return "loginutente";
    }

    @PostMapping
    public String postPage(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {

        if(!utenteService.login(username, password, session))
            return "redirect:/loginutente?error";
        return "redirect:/areariservata";
    }
}
