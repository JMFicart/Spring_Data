package com.example.hotel.models.forms;

import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Validated
public class GerantForm {
    @NonNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String nom;
    @NotBlank
    @Size(min = 2, max = 50)
    private String prenom;
    @PastOrPresent
    private LocalDate debutCarriere;
}
