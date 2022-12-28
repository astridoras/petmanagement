package com.pet.petmanagement.domain.pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pet.petmanagement.domain.color.Color;
import com.pet.petmanagement.domain.country.Country;
import com.pet.petmanagement.domain.type.Type;
import com.pet.petmanagement.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "pet")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255)
    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @Size(max = 255)
    @NotNull
    @Column(name = "type", nullable = false)
    private String type;

     @Size(max = 255)
    @NotNull
    @Column(name = "color", nullable = false)
    private String color;

   @Size(max = 255)
    @NotNull
    @Column(name = "country", nullable = false)
    private String country;


    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}