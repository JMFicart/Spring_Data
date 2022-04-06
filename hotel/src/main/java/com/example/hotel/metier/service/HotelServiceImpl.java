package com.example.hotel.metier.service;

import com.example.hotel.data.repository.HotelRepository;
import com.example.hotel.exceptions.ElementNotFoundException;
import com.example.hotel.metier.mapper.HotelMapper;
import com.example.hotel.models.dtos.HotelDto;
import com.example.hotel.models.entities.Hotel;
import com.example.hotel.models.forms.HotelForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
//        if(form.getGerantId())
//            entity.setGerant(
//                    gRepo.findById(form.gerantId()
//            );
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
        Hotel entity = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, HotelDto.class));
        entity.setNom(form.getNom());
        entity.setNbrEtoile(form.getNbrEtoile());
        entity.setAdresse(form.getAdresse());
        entity.setGerant(form.getGerant());
        entity.setChambres(form.getChambres());

        repository.save(entity);
        return mapper.entityToDto(entity);
    }

    @Override
    public HotelDto delete(Long id) {
        HotelDto dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
