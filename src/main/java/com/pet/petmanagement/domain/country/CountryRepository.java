package com.pet.petmanagement.domain.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("select c from Country c where c.name = ?1")
    Country findByName(String name);

}