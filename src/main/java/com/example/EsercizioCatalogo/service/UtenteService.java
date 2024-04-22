package com.example.EsercizioCatalogo.service;

import jakarta.servlet.http.HttpSession;

public interface UtenteService {

    boolean login(String username, String password, HttpSession session);
}
