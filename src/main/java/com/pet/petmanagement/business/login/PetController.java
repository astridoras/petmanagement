package com.pet.petmanagement.business.login;


import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pet")
public class PetController {

@Resource
    private ManagementService managementService;

@PostMapping("/new")
public void addNewPet (@RequestBody NewPetRequest request) {

    managementService.addNewPet(request);
}


}
