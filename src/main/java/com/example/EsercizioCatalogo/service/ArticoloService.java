package com.example.EsercizioCatalogo.service;
import com.example.EsercizioCatalogo.model.Articolo;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface ArticoloService {

    List<Articolo> getArticoli();

    Articolo getArticoliById(int id);

    boolean aggiungiCarrello(int idArticolo, HttpSession session);

    List<Articolo> getCarrello(HttpSession session);

    void rimuoviCarrello(int idArticolo, HttpSession session);

    double totaleCarrello(HttpSession session);
}