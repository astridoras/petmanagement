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
public class NewPetRequest implements Serializable {
    private Integer petId;
    @Size(max = 255)
    @NotNull
    private String petName;
    private Integer userId;
    private Integer typeId;
    @Size(max = 255)
    @NotNull
    private String typeName;
    private Integer colorId;
    @Size(max = 255)
    @NotNull
    private String colorName;
    private Integer countryId;
    @Size(max = 255)
    @NotNull
    private String countryName;
}