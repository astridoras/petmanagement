package com.pet.petmanagement.domain.pet;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PetService {

    @Resource
    private PetRepository petRepository;

    public void save(Pet pet) {
        petRepository.save(pet);
    }

    public Pet findById(Integer petId) {
       return petRepository.findById(petId).get();
    }
}
