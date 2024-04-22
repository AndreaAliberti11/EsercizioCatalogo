package com.example.EsercizioCatalogo.dao;

import com.example.EsercizioCatalogo.model.Articolo;
import org.springframework.data.repository.CrudRepository;

public interface ArticoloDao extends CrudRepository<Articolo, Integer> {
}
