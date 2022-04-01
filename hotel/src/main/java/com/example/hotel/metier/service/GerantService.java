package com.example.hotel.metier.service;

import com.example.hotel.models.dtos.GerantDto;
import com.example.hotel.models.forms.GerantForm;

import java.util.List;

public interface GerantService {
    //Create
    public GerantDto insert(GerantForm form);

    //Read
    public GerantDto getOne(Long id);
    public List<GerantDto> getAll();

    //Update
    public GerantDto update(Long id, GerantForm form );
    
    //Delete
    public GerantDto delete(Long id);
}
