package com.example.brasserie.models;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;
import java.time.LocalTime;

@Data
@Builder
public class Brasserie {
    private int id;
    private String nom;
    private String adresse;
    private String nomProprietaire;
    private LocalTime heureOuverture;
    private LocalTime heureFermeture;
    private boolean peutManger;
}
