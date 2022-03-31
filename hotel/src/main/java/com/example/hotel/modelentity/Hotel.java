package com.example.hotel.modelentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom", nullable = false, length = 30)
    private String nom;

    @Column(name = "nbretoile", nullable = false)
    private int nbrEtoile;

    @Column(name = "adresse", nullable = false, length = 60)
    private String adresse;

    @OneToOne(mappedBy = "hotel")
    private Gerant gerant;

}
