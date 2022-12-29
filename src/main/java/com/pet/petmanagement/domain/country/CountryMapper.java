package com.pet.petmanagement.domain.country;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CountryMapper {
     CountryJson countryToCountryJson(Country country);
     List<CountryJson> countriesToCountryJson(List<Country>countries);

}
