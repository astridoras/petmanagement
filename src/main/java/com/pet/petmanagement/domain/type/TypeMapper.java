package com.pet.petmanagement.domain.type;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TypeMapper {
    TypeJson typeToTypeJson(Type type);

    List<TypeJson> typesToTypeJson(List<Type> types);
}
