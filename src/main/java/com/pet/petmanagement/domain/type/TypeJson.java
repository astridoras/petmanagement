package com.pet.petmanagement.domain.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Type} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeJson implements Serializable {
    private Integer id;
    @Size(max = 255)
    @NotNull
    private String name;
}