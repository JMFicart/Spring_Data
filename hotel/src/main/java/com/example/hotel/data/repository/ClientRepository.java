package com.example.hotel.data.repository;

import com.example.hotel.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client, Long> {
}
