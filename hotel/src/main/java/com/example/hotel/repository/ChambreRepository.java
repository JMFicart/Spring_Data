package com.example.hotel.repository;

import com.example.hotel.modelentity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository  extends JpaRepository<Chambre, Long> {
}
