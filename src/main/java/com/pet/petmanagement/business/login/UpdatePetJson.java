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
public class UpdatePetJson implements Serializable {
    @Size(max = 255)
    @NotNull
    private String name;
    @Size(max = 255)
    @NotNull
    private String code;
    private Integer colorId;
    private Integer countryId;
    private Integer typeId;
}