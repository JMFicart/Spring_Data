package com.example.hotel.metier.mapper;

import com.example.hotel.models.dtos.HotelDto;
import com.example.hotel.models.entities.Gerant;
import com.example.hotel.models.entities.Hotel;
import com.example.hotel.models.forms.HotelForm;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HotelMapper {
    public HotelDto entityToDto(Hotel entity){
        if (entity == null)
            return null;

        Gerant gerantEntity = entity.getGerant();
        HotelDto.GerantDto gerant = gerantEntity == null ? null : new HotelDto.GerantDto(gerantEntity.getId(),
                gerantEntity.getNom(), gerantEntity.getPrenom(), gerantEntity.getDebutcarriere());

        return HotelDto.builder()
                .id( entity.getId() )
                .nom( entity.getNom() )
                .nbrEtoile( entity.getNbrEtoile() )
                .adresse( entity.getAdresse() )
                .gerant( gerant )
                .build();
    }

    public Hotel formToEntity(HotelForm form) {
        if(form == null)
            return null;

        return Hotel.builder()
                .nom(form.getNom())
                .nbrEtoile(form.getNbrEtoile())
                .adresse(form.getAdresse()
                ).build();
    }
}
