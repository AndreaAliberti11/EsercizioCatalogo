package com.example.EsercizioCatalogo.service;

import com.example.EsercizioCatalogo.dao.ArticoloDao;
import com.example.EsercizioCatalogo.model.Articolo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticoloServiceImpl implements ArticoloService {

    @Autowired
    private ArticoloDao articoloDao;

    @Override
    public List<Articolo> getArticoli() {
        return (List<Articolo>) articoloDao.findAll();
    }

    @Override
    public Articolo getArticoliById(int id) {

        Optional<Articolo> optionalArticolo = articoloDao.findById(id);

        if(optionalArticolo.isPresent())
            return optionalArticolo.get();
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean aggiungiCarrello(int idArticolo, HttpSession session) {

        Articolo articolo = getArticoliById(idArticolo);
        List<Articolo> carrello;

        if(session.getAttribute("carrello") != null) {

            carrello = (List<Articolo>) session.getAttribute("carrello");

            for(Articolo ar : carrello)
                if(ar.getId() == articolo.getId())
                    return false;

            carrello.add(articolo);
            session.setAttribute("carrello", carrello);
            return true;
        } else {
            carrello = new ArrayList<>();
            carrello.add(articolo);
            session.setAttribute("carrello", carrello);
            return true;
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Articolo> getCarrello(HttpSession session) {

        if(session.getAttribute("carrello") != null)
            return (List<Articolo>) session.getAttribute("carrello");
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void rimuoviCarrello(int idArticolo, HttpSession session) {

        List<Articolo> carrello = (List<Articolo>) session.getAttribute("carrello");

        carrello = carrello
                .stream()
                .filter(ar -> ar.getId() != idArticolo)
                .collect(Collectors.toList());

        if(carrello.size() > 0) {
            session.setAttribute("carrello", carrello);
        } else {
            session.removeAttribute("carrello");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public double totaleCarrello(HttpSession session) {

        List<Articolo> carrello = (List<Articolo>) session.getAttribute("carrello");

        if(carrello != null) {
            double total = 0;

            total = carrello
                    .stream()
                    .mapToDouble(Articolo::getPrezzo)
                    .reduce(0, Double::sum);
            return total;
        }
        return 0;
    }
}
