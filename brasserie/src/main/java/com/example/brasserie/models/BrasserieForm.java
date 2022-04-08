package com.example.brasserie.models;

import lombok.Data;
import org.springframework.lang.Nullable;
import javax.validation.constraints.*;
import java.time.LocalTime;

@Data
public class BrasserieForm {
    @NotBlank
    @Size(min=2, max= 50)
    private String nom;
    @NotBlank
    @Size(max= 200)
    private String adresse;
    @Nullable
    @Size(min=2, max= 50)
    private String nomProprietaire;
    private LocalTime heureOuverture;
    private LocalTime heureFermeture;
    private boolean peutManger;
}
