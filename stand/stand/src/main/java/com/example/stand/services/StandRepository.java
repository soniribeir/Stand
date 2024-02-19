package com.example.stand.services;

import com.example.stand.models.Stand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StandRepository extends JpaRepository<Stand, Long> {
}
