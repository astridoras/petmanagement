package com.pet.petmanagement.domain.pet;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PetService {

    @Resource
    private PetRepository petRepository;

    public void save(Pet pet) {
        petRepository.save(pet);
    }

    public List<Pet> findUserPetsByUserId(Integer userId) {
        return petRepository.findAllUserPetsByUserId(userId);
    }
}
