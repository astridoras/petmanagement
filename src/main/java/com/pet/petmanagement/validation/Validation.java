package com.pet.petmanagement.validation;

import com.pet.petmanagement.business.login.CreatePetJson;
import com.pet.petmanagement.domain.user.User;
import com.pet.petmanagement.infrastructure.exception.BusinessException;

import java.util.Optional;

public class Validation {
    public static void validateUserCredentials(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(
                    PetError.INCORRECT_CREDENTIALS.getMessage(),
                    PetError.INCORRECT_CREDENTIALS.getErrorCode());
        }
    }

    public static void validateCreatePetJson(CreatePetJson json) {
        if (json.getPetName() == null || json.getPetName().isEmpty()) {
            throw new BusinessException(
                    PetError.NAME_MISSING.getMessage(),
                    PetError.NAME_MISSING.getErrorCode());
        }
        if (json.getPetCode() == null || json.getPetCode().isEmpty()) {
            throw new BusinessException(
                    PetError.CODE_MISSING.getMessage(),
                    PetError.CODE_MISSING.getErrorCode());
        }
        if (json.getType() == null || json.getType().isEmpty()) {
            throw new BusinessException(
                    PetError.TYPE_MISSING.getMessage(),
                    PetError.TYPE_MISSING.getErrorCode());
        }
        if (json.getColor() == null || json.getColor().isEmpty()) {
            throw new BusinessException(
                    PetError.COLOR_MISSING.getMessage(),
                    PetError.COLOR_MISSING.getErrorCode());
        }
        if (json.getCountry() == null || json.getCountry().isEmpty()) {
            throw new BusinessException(
                    PetError.COUNTRY_MISSING.getMessage(),
                    PetError.COUNTRY_MISSING.getErrorCode());
        }
    }
}
