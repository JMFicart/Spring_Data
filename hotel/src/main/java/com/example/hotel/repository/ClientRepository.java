package com.example.hotel.repository;

import com.example.hotel.modelentity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client, Long> {
}
