package com.example.hotel.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class HotelDto {
    private final Long id;
    private final String nom;
    private final int nbrEtoile;
    private final String adresse;
    private final GerantDto gerant;
    private final List<ChambreDto> chambres;

    @Data
    @AllArgsConstructor
    public static class GerantDto{
        private final Long id;
        private final String nom;
        private final String prenom;
        private final LocalDate debutCarriere;
    }

    @Data
    @AllArgsConstructor
    public static class ChambreDto{
        private final int numChambre;
        private final boolean aTele;
        private final boolean aCuisine;
        private final boolean aMiniBar;
        private final float prix;
    }
}
