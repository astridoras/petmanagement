package com.pet.petmanagement.domain.color;

import com.pet.petmanagement.business.pet.json.PetResponseJson;
import com.pet.petmanagement.domain.pet.Pet;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ColorMapper {
    ColorJson colorToColorJson(Color color);
    List<ColorJson> colorsToColorJson(List<Color>colors);
}
