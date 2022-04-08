package com.example.brasserie.service;

import com.example.brasserie.models.Brasserie;
import com.example.brasserie.models.BrasserieForm;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrasserieService {
    private final List<Brasserie> brasseries;
    private int nextId = 2;

    public BrasserieService() {
        brasseries = new ArrayList<>();
        brasseries.add(Brasserie.builder()
                .id(1)
                .nom("Le temps des cerises")
                .adresse("Namur")
                .nomProprietaire("Groucho Marx")
                .heureOuverture(LocalTime.of(17,30))
                .heureFermeture(LocalTime.of(23,0))
                .peutManger(true)
                .build());

        brasseries.add(Brasserie.builder()
                .id(2)
                .nom("Au Saint-Loup")
                .adresse("Namur")
                .nomProprietaire("Malherbe")
                .heureOuverture(LocalTime.of(18,00))
                .heureFermeture(LocalTime.of(23,30))
                .peutManger(false)
                .build());
    }

    public Brasserie getOne(int id){
        return brasseries.stream().filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow();
    }

//    public List<Brasserie> getMarque(String m){
//        return brasseries.stream().filter(e -> e.getMarque().equals(m) )
//                .toList();
//    }

    public List<Brasserie> getAll(){
        return new ArrayList<Brasserie>(brasseries);
    }

    public Brasserie insert(BrasserieForm form){
        Brasserie brasserie = Brasserie.builder()
                .id(++nextId)
                .nom(form.getNom())
                .adresse(form.getAdresse())
                .nomProprietaire(form.getNomProprietaire())
                .heureOuverture(form.getHeureOuverture())
                .heureFermeture(form.getHeureFermeture())
                .peutManger(form.isPeutManger())
                .build();

        brasseries.add(brasserie);
        return brasserie;
    }
}
