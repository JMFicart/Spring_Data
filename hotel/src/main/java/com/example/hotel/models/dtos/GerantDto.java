package com.example.hotel.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class GerantDto {
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate debutCarriere;
    private HotelDto hotel;

    @Data
    @AllArgsConstructor
    public static class HotelDto{
        private Long id;
        private String nom;
    }
}
