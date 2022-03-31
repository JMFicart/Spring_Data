package com.example.demoJPARef.modelentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "utilisateur")

public class Utilisateur {
    @Id
    @Column(name="num_nat", nullable = false)
    private long numNational;

    @Column(name="username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name="password", nullable = false, length = 50)
    private String password;

    @Column(name="nom", nullable = false, length = 30)
    private String nom;

    @Column(name="prenom", nullable = false, length = 30)
    private String prenom;

    @ManyToMany
    private List<Voiture> voitures;

    @OneToMany(mappedBy = "detenteur")
    private List<Permis> permis;

    @OneToOne
    private Adresse adresse;
}
