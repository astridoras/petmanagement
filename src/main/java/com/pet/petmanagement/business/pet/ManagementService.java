package com.pet.petmanagement.business.pet;

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
import com.pet.petmanagement.infrastructure.exception.BusinessException;
import com.pet.petmanagement.validation.PetError;
import com.pet.petmanagement.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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

    public void addNewPet(Integer userId, CreatePetJson json) {
        Validation.validateCreatePetJson(json);
        User user = findAndValidateUser(userId);
        validateType(json);
        validateColor(json);
        validateCountry(json);

        Pet pet = petMapper.jsonToPet(json);
        pet.setUser(user);
        pet.setType(json.getType());
        pet.setColor(json.getColor());
        pet.setCountry(json.getCountry());
        petService.save(pet);
    }

    private User findAndValidateUser(Integer userId) {
        Optional<User> user = userService.findUserBy(userId);
        if (user.isEmpty()) {
            throw new BusinessException(
                    PetError.USER_NOT_FOUND.getMessage(),
                    PetError.USER_NOT_FOUND.getErrorCode());
        }
        return user.get();
    }

    private void validateCountry(CreatePetJson json) {
        Country country = countryService.findCountryByName(json.getCountry());
        if (country == null) {
            throw new BusinessException(
                    PetError.COUNTRY_NOT_FOUND.getMessage(),
                    PetError.COUNTRY_NOT_FOUND.getErrorCode());
        }
    }

    private void validateColor(CreatePetJson json) {
        Color color = colorService.findColorByName(json.getColor());
        if (color == null) {
            throw new BusinessException(
                    PetError.COLOR_NOT_FOUND.getMessage(),
                    PetError.COLOR_NOT_FOUND.getErrorCode());
        }
    }

    private void validateType(CreatePetJson json) {
        Type type = typeService.findTypeByName(json.getType());
        if (type == null) {
            throw new BusinessException(
                    PetError.TYPE_NOT_FOUND.getMessage(),
                    PetError.TYPE_NOT_FOUND.getErrorCode());

        }
    }

    public List<Pet> getAllPetsByUserId(Integer userId) {
        return petService.findUserPetsByUserId(userId);
    }

//    public void editPetData(Long petId, UpdatePetJson updatePet) {
//        Pet pet = petService.findById(petId);
////        Type type = typeService.findTypeByName(updatePet.getTypeId());
//        Color color = colorService.findColorBy(updatePet.getColorId());
//        Country country = countryService.findCountryBy(updatePet.getCountryId());
//
//        pet.setName(updatePet.getName());
//        pet.setCode(updatePet.getCode());
//        //TODO: set type, color, country
////        pet.setType(type);
////        pet.setColor(color);
////        pet.setCountry(country);
//        petService.save(pet);
//    }
}
