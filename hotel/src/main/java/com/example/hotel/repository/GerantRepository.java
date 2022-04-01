package com.example.hotel.repository;

import com.example.hotel.modelentity.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerantRepository  extends JpaRepository<Gerant, Long> {
}
