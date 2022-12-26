package com.pet.petmanagement.domain.pet;

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
public class PetResponseJson implements Serializable {
    private Long id;
    @Size(max = 255)
    @NotNull
    private String name;
    @Size(max = 255)
    @NotNull
    private String code;
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