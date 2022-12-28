package com.pet.petmanagement.domain.country;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CountryMapper {
     CountryJson countryToCountryJson(Country country);
}
