package com.pet.petmanagement.business.login;

import com.pet.petmanagement.domain.pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
    @NotBlank
    private String petName;
    @Size(min=6, max = 255)
    @NotBlank
    private String petCode;
    @Size(max = 255)
    @NotBlank
    private String type;
    @Size(max = 255)
    @NotBlank
    private String color;
    @Size(max = 255)
    @NotBlank
    private String country;
}