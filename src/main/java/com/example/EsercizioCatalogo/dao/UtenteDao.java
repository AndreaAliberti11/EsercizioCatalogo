package com.example.EsercizioCatalogo.dao;

import com.example.EsercizioCatalogo.model.Utente;
import org.springframework.data.repository.CrudRepository;

public interface UtenteDao extends CrudRepository<Utente, Integer> {

    // SELECT * FROM utenti JOIN profili ON utenti.id_profilo=profili.id WHERE profili.username=? AND profili.password=?

    Utente findByProfiloUsernameAndProfiloPassword(String username, String password);
}
