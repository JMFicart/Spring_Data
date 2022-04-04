package com.example.hotel.metier.service;

import com.example.hotel.models.dtos.HotelDto;
import com.example.hotel.models.forms.HotelForm;

import java.util.List;

public class HotelServiceMock implements HotelService {
    @Override
    public HotelDto insert(HotelForm form) {
        return null;
    }

    @Override
    public HotelDto getOne(Long id) {
        return null;
    }

    @Override
    public List<HotelDto> getAll() {
        return null;
    }

    @Override
    public HotelDto update(Long id, HotelForm form) {
        return null;
    }

    @Override
    public HotelDto delete(Long id) {
        return null;
    }
}
