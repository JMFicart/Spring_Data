package com.example.hotel.utils;

import com.example.hotel.data.repository.GerantRepository;
import com.example.hotel.data.repository.UserRepository;
import com.example.hotel.models.entities.Gerant;
import com.example.hotel.models.entities.Hotel;
import com.example.hotel.data.repository.HotelRepository;
import com.example.hotel.models.entities.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatabaseFiller implements InitializingBean {
    private final HotelRepository repository;
    private final GerantRepository gRepo;
    private final UserRepository gUser;
    private final PasswordEncoder encoder;

    public DatabaseFiller(HotelRepository repository, GerantRepository gRepo, UserRepository gUser, PasswordEncoder encoder, PasswordEncoder encoder1) {
        this.repository = repository;
        this.gRepo = gRepo;
        this.gUser = gUser;
        this.encoder = encoder1;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setupHotelGerant();

        User user = new User();
        user.setUsername("user");
        user.setPassword(encoder.encode("pass"));
        gUser.save(user);

    }

    private void setupHotelGerant(){
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
