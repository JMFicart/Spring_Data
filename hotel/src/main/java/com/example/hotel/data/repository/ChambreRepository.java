package com.example.hotel.data.repository;

import com.example.hotel.models.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository  extends JpaRepository<Chambre, Long> {
}
