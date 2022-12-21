package com.pet.petmanagement.validation;

import com.pet.petmanagement.infrastructure.exception.BusinessException;
import com.pet.petmanagement.domain.user.User;

import java.util.Optional;

public class Validation {
    public static void validateUserCredentials(Optional<User>userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(
                    PetError.INCORRECT_CREDENTIALS.getMessage(),
                    PetError.INCORRECT_CREDENTIALS.getErrorCode());
        }
    }
}
