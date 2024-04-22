package com.example.EsercizioCatalogo.service;

import com.example.EsercizioCatalogo.dao.UtenteDao;
import com.example.EsercizioCatalogo.model.Utente;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    private UtenteDao utenteDao;

    @Override
    public boolean login(String username, String password, HttpSession session) {

        Utente utente = utenteDao.findByProfiloUsernameAndProfiloPassword(username, password);
        if(utente != null) {
            session.setAttribute("utente", utente);
            return true;
        }
        return false;
    }
}
