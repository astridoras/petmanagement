package com.pet.petmanagement.business.login;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Resource
    private ManagementService managementService;

    @PostMapping("/new")
    @Operation(summary = "Add new pet")
    public void addNewPet(@RequestBody NewPetRequest request) {

        managementService.addNewPet(request);
    }

    @PutMapping("/edit")
    @Operation(summary = "Update pet data parameters")
    public void editPetData(@RequestParam Integer petId, @RequestBody UpdatePetRequest updatePet) {
    managementService.editPetData(petId, updatePet);

    }


}
