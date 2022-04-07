package com.example.demomvc.models;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Data
@Builder
public class Produit {
    private int id;
    private String marque;
    private String modele;
    private double prix;
    private boolean enVente;
}
