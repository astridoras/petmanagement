package com.pet.petmanagement.business.pet;

import com.pet.petmanagement.business.pet.json.CreatePetJson;
import com.pet.petmanagement.business.pet.json.PetResponseJson;
import com.pet.petmanagement.domain.pet.Pet;
import com.pet.petmanagement.domain.pet.PetMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/")
public class PetController {
    @Resource
    private ManagementService managementService;
    @Resource
    private PetMapper petMapper;

    @PostMapping("users/{userId}/pets")
    @Operation(summary = "Add new pet to user")
    public void addNewPet(@PathVariable Integer userId, @RequestBody @Valid CreatePetJson json) {
        managementService.addNewPet(userId, json);
    }

    @GetMapping("users/{userId}/pets")
    @Operation(summary = "Show all user pets by userId")
    public List<PetResponseJson> getAllPetsByUserId(@PathVariable Integer userId) {
        List<Pet> pets = managementService.getAllPetsByUserId(userId);
        return petMapper.petsToPetResponseJson(pets);
    }

  /*  @PutMapping("users/{userId}/pets/{petId}")
    @Operation(summary = "Update pet data parameters")
    public void editPetData(@PathVariable Integer userId, @PathVariable Long petId, @RequestBody UpdatePetJson json) {
        managementService.editPetData(petId, json);
    }*/
}
