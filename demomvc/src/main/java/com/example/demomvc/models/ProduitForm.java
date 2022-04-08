package com.example.demomvc.models;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProduitForm {

    @NotBlank
    @Size(min=2, max= 50)
    private String marque;
    @NotBlank
    @Size(min=2, max= 50)
    private String modele;
    @Min(0)
    @NotNull(message="Le prix doit être différent de 0 !")
    private Double prix;

}
