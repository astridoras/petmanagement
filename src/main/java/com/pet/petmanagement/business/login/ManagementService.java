package com.pet.petmanagement.business.login;


import com.pet.petmanagement.domain.color.Color;
import com.pet.petmanagement.domain.color.ColorService;
import com.pet.petmanagement.domain.country.Country;
import com.pet.petmanagement.domain.country.CountryService;
import com.pet.petmanagement.domain.pet.Pet;
import com.pet.petmanagement.domain.pet.PetMapper;
import com.pet.petmanagement.domain.pet.PetService;
import com.pet.petmanagement.domain.type.Type;
import com.pet.petmanagement.domain.type.TypeService;
import com.pet.petmanagement.domain.user.User;
import com.pet.petmanagement.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManagementService {

    @Resource
    private UserService userService;

    @Resource
    private ColorService colorService;

    @Resource
    private TypeService typeService;

    @Resource
    private CountryService countryService;

    @Resource
    private PetService petService;

    @Resource
    private PetMapper petMapper;

    public void addNewPet(NewPetRequest request) {
        User user = userService.findUserBy(request.getUserId());
        Type type = typeService.findTypeBy(request.getTypeId());
        Color color = colorService.findColorBy(request.getColorId());
        Country country = countryService.findCountryBy(request.getCountryId());

        Pet pet = petMapper.newPetRequestToPet(request);
        pet.setUser(user);
        pet.setType(type);
        pet.setColor(color);
        pet.setCountry(country);

        petService.save(pet);
    }

    public void editPetData(Integer petId, UpdatePetRequest updatePet) {
        Pet pet = petService.findById(petId);
        Type type = typeService.findTypeBy(updatePet.getTypeId());
        Color color = colorService.findColorBy(updatePet.getColorId());
        Country country = countryService.findCountryBy(updatePet.getCountryId());

        pet.setName(updatePet.getName());
        pet.setCode(updatePet.getCode());
        pet.setType(type);
        pet.setColor(color);
        pet.setCountry(country);

        petService.save(pet);
    }

}
