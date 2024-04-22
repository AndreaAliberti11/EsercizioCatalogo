package com.example.EsercizioCatalogo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "marche")
public class Marchio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @OneToMany
            (
                    mappedBy = "marchio",
                    cascade = CascadeType.REMOVE,
                    fetch = FetchType.EAGER,
                    orphanRemoval = true
            )
    private List<Articolo> articoli = new ArrayList<>();
    // questo sopra ora non serve però se ci serviva in una pagina del sito un elenco di tutto quello che c'è in un artico ad esempio, questo ci serviva perchè prende tutto lo specifico di un articolo, libro, strumento ecc. specifico

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Articolo> getArticoli() {
        return articoli;
    }

    public void setArticoli(List<Articolo> articoli) {
        this.articoli = articoli;
    }

}