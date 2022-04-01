package com.example.hotel.modelentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chambre_id", nullable = false)
    private Long id;

    @Column(name = "aTele", nullable = false)
    private boolean aTele;

    @Column(name = "aCuisine", nullable = false)
    private boolean aCuisine;

    @Column(name = "aMiniBar", nullable = false)
    private boolean aMiniBar;

    @Column(name = "prix", nullable = false, precision = 2)
    private float prix;

    @ManyToOne
    private Hotel hotel;

    @ManyToMany
    @JoinTable(name = "visite",
        joinColumns = @JoinColumn(name = "chambre_id"),
        inverseJoinColumns = @JoinColumn(name = "visiteur_id"),
        uniqueConstraints = @UniqueConstraint(name = "UNIK_visiteur_chambre",
        columnNames = {"chambre_id", "visiteur_id"}))
    private List<Client> clients = new ArrayList<>();
}
