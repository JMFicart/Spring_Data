package com.example.hotel.metier.service;

import com.example.hotel.data.repository.HotelRepository;
import com.example.hotel.exceptions.ElementNotFoundException;
import com.example.hotel.metier.mapper.HotelMapper;
import com.example.hotel.models.dtos.HotelDto;
import com.example.hotel.models.entities.Hotel;
import com.example.hotel.models.forms.HotelForm;

import java.util.List;
//TODO Completer le code
public class HotelServiceImpl implements HotelService{
    private final HotelRepository repository;
    private final HotelMapper mapper;

    public HotelServiceImpl(HotelRepository repository, HotelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public HotelDto insert(HotelForm form) {
        Hotel entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDto(entity);
    }

    @Override
    public HotelDto getOne(Long id) {
        return repository.findById(id)
                .map(mapper::entityToDto)
                .orElseThrow(() -> new ElementNotFoundException(id, HotelDto.class));
    }

    @Override
    public List<HotelDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDto)
                .toList();
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
