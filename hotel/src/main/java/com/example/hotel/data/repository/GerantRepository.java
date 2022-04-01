package com.example.hotel.data.repository;

import com.example.hotel.models.entities.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerantRepository  extends JpaRepository<Gerant, Long> {
}
