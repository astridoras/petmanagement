package com.pet.petmanagement.domain.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    @Query("select p from Pet p where p.user.id = ?1")
    List<Pet> findAllUserPetsByUserId(Integer id);

}