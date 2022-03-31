package com.example.demoJPARef.repository;

import com.example.demoJPARef.modelentity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
