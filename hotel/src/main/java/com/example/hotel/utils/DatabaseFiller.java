package com.example.hotel.utils;

import com.example.hotel.data.repository.GerantRepository;
import com.example.hotel.models.entities.Gerant;
import com.example.hotel.models.entities.Hotel;
import com.example.hotel.data.repository.HotelRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatabaseFiller implements InitializingBean {
    private final HotelRepository repository;
    private final GerantRepository gRepo;

    public DatabaseFiller(HotelRepository repository, GerantRepository gRepo) {
        this.repository = repository;
        this.gRepo = gRepo;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Gerant g = Gerant.builder()
                .debutcarriere(LocalDate.now())
                .prenom("Luc")
                .nom("Dubois")
                .build();
        gRepo.save(g);

        g = Gerant.builder()
                .debutcarriere(LocalDate.now().minusDays(2))
                .prenom("Marie")
                .nom("Desmet")
                .build();
        gRepo.save(g);

        Hotel h = Hotel.builder()
                .nom("Grand Budapest")
                .adresse("Inconnue")
                .nbrEtoile(5)
                .gerant(g)
                .build();
        repository.save(h);
    }
}
