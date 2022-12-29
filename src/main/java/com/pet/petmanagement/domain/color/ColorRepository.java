package com.pet.petmanagement.domain.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ColorRepository extends JpaRepository<Color, Integer> {
    @Query("select c from Color c where c.name = ?1")
    Color findByName(String name);
}