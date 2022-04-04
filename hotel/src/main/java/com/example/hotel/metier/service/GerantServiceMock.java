package com.example.hotel.metier.service;

import com.example.hotel.models.dtos.GerantDto;
import com.example.hotel.models.forms.GerantForm;

import java.util.List;

public class GerantServiceMock implements GerantService{

    @Override
    public GerantDto insert(GerantForm form) {
        return null;
    }

    @Override
    public GerantDto getOne(Long id) {
        return null;
    }

    @Override
    public List<GerantDto> getAll() {
        return null;
    }

    @Override
    public GerantDto update(Long id, GerantForm form) {
        return null;
    }

    @Override
    public GerantDto delete(Long id) {
        return null;
    }
}
