package com.pet.petmanagement.domain.pet;

import com.pet.petmanagement.business.login.NewPetRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PetMapper {
    @Mapping(source = "petId", target = "id")
    @Mapping(source = "petName", target = "name")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "colorId", target = "color.id")
    @Mapping(source = "colorName", target = "color.name")
    @Mapping(source = "countryId", target = "country.id")
    @Mapping(source = "countryName", target = "country.name")
    Pet newPetRequestToPet(NewPetRequest newPetRequest);

}