package com.example.demoJPARef.repository;

import com.example.demoJPARef.modelentity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
}
