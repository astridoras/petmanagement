package com.pet.petmanagement.domain.color;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ColorMapper {
    ColorJson colorToColorJson(Color color);
}
