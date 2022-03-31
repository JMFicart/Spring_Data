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
@Table(name = "chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "aTele", nullable = false)
    private boolean aTele;

    @Column(name = "aCuisine", nullable = false)
    private boolean aCuisine;

    @Column(name = "aMiniBar", nullable = false)
    private boolean aMiniBar;

    @Column(name = "prix", nullable = false)
    private float prix;
}
