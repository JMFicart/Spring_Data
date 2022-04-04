package com.example.hotel.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class HotelDto {
    private Long id;
    private String nom;
    private int nbrEtoile;
    private String adresse;
    private HotelDto.GerantDto gerant;

    @Data
    @AllArgsConstructor
    public static class GerantDto{
        private Long id;
        private String nom;
        private String prenom;
        private LocalDate debutCarriere;
    }
}
