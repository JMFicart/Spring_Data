package com.example.hotel.metier.mapper;

import com.example.hotel.models.dtos.HotelDto;
import com.example.hotel.models.entities.Chambre;
import com.example.hotel.models.entities.Gerant;
import com.example.hotel.models.entities.Hotel;
import com.example.hotel.models.forms.HotelForm;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelMapper {
    public HotelDto entityToDto(Hotel entity){
        if (entity == null)
            return null;

        Gerant gerantEntity = entity.getGerant();
        HotelDto.GerantDto gerant = gerantEntity == null ? null : new HotelDto.GerantDto(gerantEntity.getId(),
                gerantEntity.getNom(), gerantEntity.getPrenom(), gerantEntity.getDebutcarriere());

        List<Chambre> chambreEntity = entity.getChambres();


        List<HotelDto.ChambreDto> chambre = chambreEntity == null ? null :
                chambreEntity.stream().map(room ->
                    new HotelDto.ChambreDto(room.getNumChambre(), room.isATele(), room.isACuisine(), room.isAMiniBar(), room.getPrix())
                ).toList();

        return HotelDto.builder()
                .id( entity.getId() )
                .nom( entity.getNom() )
                .nbrEtoile( entity.getNbrEtoile() )
                .adresse( entity.getAdresse() )
                .gerant( gerant )
                .chambres(chambre)
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
