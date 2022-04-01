package com.example.hotel.utils;

import com.example.hotel.modelentity.Hotel;
import com.example.hotel.repository.HotelRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFiller implements InitializingBean {
    private final HotelRepository repository;

    public DatabaseFiller(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Hotel h = new Hotel();
        h.setNom("MonHotel");
        h.setNbrEtoile((byte)3);
    }
}
