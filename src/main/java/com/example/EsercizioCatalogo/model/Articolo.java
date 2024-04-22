package com.example.EsercizioCatalogo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "articoli")
public class Articolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String modello;

    @Column(name = "sistema_operativo")
    private String sistemaOperativo;

    @Column
    private int memoria;

    @Column
    private double prezzo;

    @Column
    private String descrizione;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_marche", referencedColumnName = "id")
    private Marchio marchio;

    private String immagini;

    public String getImmagini() {
        return immagini;
    }

    public void setImmagini(String immagini) {
        this.immagini = immagini;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Marchio getMarchio() {
        return marchio;
    }

    public void setMarchio(Marchio marchio) {
        this.marchio = marchio;
    }

}