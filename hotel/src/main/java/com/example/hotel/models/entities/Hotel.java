package com.example.hotel.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom", nullable = false, length = 30)
    private String nom;

    @Column(name = "nbretoile", columnDefinition = "INT NOT NULL CHECK (nbretoile BETWEEN 1 AND 5)")
    private int nbrEtoile;

    @Column(name = "adresse", nullable = false, columnDefinition = "VARCHAR(200) DEFAULT 'Inconnue'")
    private String adresse;

    @OneToOne
    @JoinColumn(name="manager_id", foreignKey = @ForeignKey(name = "FK_HOTEL_GERANT_IS"))
    private Gerant gerant;

    @OneToMany(mappedBy = "hotel")
    private List<Chambre> chambres = new ArrayList<>();

}
