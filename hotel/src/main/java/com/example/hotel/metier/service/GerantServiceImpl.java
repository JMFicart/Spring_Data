package com.example.hotel.metier.service;

import com.example.hotel.data.repository.GerantRepository;
import com.example.hotel.metier.mapper.GerantMapper;
import com.example.hotel.models.dtos.GerantDto;
import com.example.hotel.models.entities.Gerant;
import com.example.hotel.models.forms.GerantForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerantServiceImpl implements GerantService {
    private final GerantRepository repository;
    private final GerantMapper mapper;

    public GerantServiceImpl(GerantRepository repository, GerantMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public GerantDto insert(GerantForm form) {
        Gerant entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDto(entity);
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
