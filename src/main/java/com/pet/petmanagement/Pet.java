package com.pet.petmanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pet {

    @GetMapping ("/pets")
    public String pet() {
        return "Pets";
    }
}
