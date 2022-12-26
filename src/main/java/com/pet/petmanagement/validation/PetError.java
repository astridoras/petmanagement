package com.pet.petmanagement.validation;

import lombok.Getter;

@Getter
public enum PetError {
    INCORRECT_CREDENTIALS("Username or password is incorrect", "222"),
    NAME_MISSING("Name is missing", "222"),
    CODE_MISSING("Code is missing", "333"),
    TYPE_MISSING("Type is missing ", "444"),
    COLOR_MISSING("Color is missing", "222"),
    COUNTRY_MISSING("Country is missing", "222"),
    USER_NOT_FOUND("User not found", "222"),
    TYPE_NOT_FOUND("Type not found", "222"),
    COLOR_NOT_FOUND("Color not found", "222"),
    COUNTRY_NOT_FOUND("Country not found", "222");

    private final String message;
    private final String errorCode;

    PetError(String message, String errorCode) {
        this.message = message;

        this.errorCode = errorCode;
    }

}
