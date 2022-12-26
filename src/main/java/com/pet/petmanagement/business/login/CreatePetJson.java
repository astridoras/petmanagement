package com.pet.petmanagement.business.login;

import com.pet.petmanagement.domain.pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Pet} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePetJson implements Serializable {
    @Size(max = 255)
    @NotNull
    private String petName;
    @Size(max = 255)
    @NotNull
    private String petCode;
    @Size(max = 255)
    @NotNull
    private String type;
    @Size(max = 255)
    @NotNull
    private String color;
    @Size(max = 255)
    @NotNull
    private String country;
}