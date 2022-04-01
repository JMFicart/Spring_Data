package com.example.hotel.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chambre")
public class Chambre {
    @Id
    @Column(name = "num_Chambre", nullable = false)
    private int numChambre;

    @NonNull
    @Column(name = "aTele", nullable = false)
    private boolean aTele;

    @NonNull
    @Column(name = "aCuisine", nullable = false)
    private boolean aCuisine;

    @NonNull
    @Column(name = "aMiniBar", nullable = false)
    private boolean aMiniBar;

    @NonNull
    @Column(name = "prix", nullable = false, precision = 2)
    private float prix;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Hotel hotel;

    @ManyToMany
    @JoinTable(name = "visite",
        joinColumns = @JoinColumn(name = "chambre_id"),
        inverseJoinColumns = @JoinColumn(name = "visiteur_id"),
        uniqueConstraints = @UniqueConstraint(name = "UNIK_visiteur_chambre",
        columnNames = {"chambre_id", "visiteur_id"}))
    private List<Client> clients = new ArrayList<>();
}
