package com.example.hotel.models.forms;

import com.example.hotel.models.entities.Gerant;
import lombok.Data;

@Data
public class HotelForm {

    private String nom;
    private int nbrEtoile;
    private String adresse;
    private Gerant gerant;

}
