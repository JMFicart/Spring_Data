package com.example.hotel.metier.service;

import com.example.hotel.models.dtos.HotelDto;
import com.example.hotel.models.forms.HotelForm;

import java.util.List;

public interface HotelService {
    //Create
    public HotelDto insert(HotelForm form);

    //Read
    public HotelDto getOne(Long id);
    public List<HotelDto> getAll();

    //Update
    public HotelDto update(Long id, HotelForm form );

    //Delete
    public HotelDto delete(Long id);

}
