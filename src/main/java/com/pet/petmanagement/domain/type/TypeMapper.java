package com.pet.petmanagement.domain.type;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TypeMapper {
    TypeJson typeToTypeJson(Type type);
}
