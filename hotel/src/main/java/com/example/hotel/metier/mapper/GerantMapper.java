package com.example.hotel.metier.mapper;

import com.example.hotel.models.dtos.GerantDto;
import com.example.hotel.models.entities.Gerant;
import com.example.hotel.models.entities.Hotel;
import com.example.hotel.models.forms.GerantForm;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GerantMapper {
    public GerantDto entityToDto(Gerant entity){
        if (entity == null)
            return null;

        Hotel hotelEntity = entity.getGere();
        GerantDto.HotelDto hotel = hotelEntity == null ? null : new GerantDto.HotelDto(hotelEntity.getId(), hotelEntity.getNom());

        return GerantDto.builder()
                .id( entity.getId() )
                .nom( entity.getNom() )
                .prenom( entity.getPrenom() )
                .debutCarriere( entity.getDebutcarriere())
                .hotel(hotel)
                .build();
    }

    public Gerant formToEntity(GerantForm form) {
        if(form == null)
            return null;

        return Gerant.builder()
                .nom(form.getNom())
                .prenom(form.getPrenom())
                .debutcarriere(form.getDebutCarriere()
                ).build();
    }
}
