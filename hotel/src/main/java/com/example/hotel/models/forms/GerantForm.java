package com.example.hotel.models.forms;

import lombok.Data;
import java.time.LocalDate;

@Data
public class GerantForm {
    private String nom;
    private String prenom;
    private LocalDate debutCarriere;
}
