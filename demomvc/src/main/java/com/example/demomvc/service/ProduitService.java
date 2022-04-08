package com.example.demomvc.service;

import com.example.demomvc.models.Produit;
import com.example.demomvc.models.ProduitForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitService {
    private final List<Produit> produits;
    private int nextId = 5;

    public ProduitService() {
        produits = new ArrayList<>();
        produits.add(Produit.builder()
                .id(1)
                .marque("Marque 1")
                .modele("2p1")
                .prix(10)
                .enVente(true)
                .build());

        produits.add(Produit.builder()
                .id(2)
                .marque("Marque 2")
                .modele("2p2")
                .prix(15)
                .enVente(true)
                .build());

        produits.add(Produit.builder()
                .id(3)
                .marque("Marque 3")
                .modele("2p3")
                .prix(17)
                .enVente(true)
                .build());

        produits.add(Produit.builder()
                .id(4)
                .marque("Marque 4")
                .modele("2p4")
                .prix(20)
                .enVente(true)
                .build());

        produits.add(Produit.builder()
                .id(5)
                .marque("Marque 5")
                .modele("2p5")
                .prix(25)
                .enVente(true)
                .build());
    }

    public Produit getOne(int id){
        return produits.stream().filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public List<Produit> getMarque(String m){
        return produits.stream().filter(e -> e.getMarque().equals(m) )
                .toList();
    }

    public List<Produit> getAll(){
        return new ArrayList<Produit>(produits);
    }

    public  Produit insert(ProduitForm form){
        Produit produit = Produit.builder()
                .id(++nextId)
                .marque(form.getMarque())
                .modele(form.getModele())
                .prix(form.getPrix())
                .enVente(true)
                .build();

        produits.add(produit);
        return produit;
    }
}
