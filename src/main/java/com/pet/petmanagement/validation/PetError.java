package com.pet.petmanagement.validation;

import lombok.Getter;

@Getter
public enum PetError {
    INCORRECT_CREDENTIALS("Username or password is incorrect","222");

    private final String message;
    private final String errorCode;

    PetError(String message, String errorCode) {
        this.message = message;

        this.errorCode = errorCode;
    }

}
