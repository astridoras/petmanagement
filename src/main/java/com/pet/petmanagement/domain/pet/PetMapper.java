package com.pet.petmanagement.domain.pet;

import com.pet.petmanagement.business.pet.CreatePetJson;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PetMapper {
    @Mapping(source = "petName", target = "name")
    @Mapping(source = "petCode", target = "code")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "type",target = "type")
    Pet jsonToPet(CreatePetJson createPetJson);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "type",target = "type")
    PetResponseJson petToPetResponseJson(Pet pet);
    List<PetResponseJson> petsToPetResponseJson (List<Pet>pets);
}