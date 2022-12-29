package com.pet.petmanagement.business.pet;

import com.pet.petmanagement.domain.color.Color;
import com.pet.petmanagement.domain.color.ColorJson;
import com.pet.petmanagement.domain.color.ColorMapper;
import com.pet.petmanagement.domain.color.ColorService;
import com.pet.petmanagement.domain.country.Country;
import com.pet.petmanagement.domain.country.CountryJson;
import com.pet.petmanagement.domain.country.CountryMapper;
import com.pet.petmanagement.domain.country.CountryService;
import com.pet.petmanagement.domain.type.Type;
import com.pet.petmanagement.domain.type.TypeJson;
import com.pet.petmanagement.domain.type.TypeMapper;
import com.pet.petmanagement.domain.type.TypeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/")
public class ClassifierController {
    @Resource
    private CountryService countryService;
    @Resource
    private ColorService colorService;
    @Resource
    private TypeService typeService;

    @Resource
    private ColorMapper colorMapper;

    @Resource
    private CountryMapper countryMapper;

    @Resource
    private TypeMapper typeMapper;

    @GetMapping("countries")
    @Operation(summary = "Displays all country options")
    public List<CountryJson> getAllCountries() {
        List<Country> countries = countryService.findAllCountries();
        return countryMapper.countriesToCountryJson(countries);
    }

    @GetMapping("types")
    @Operation(summary = "Displays all pet type options")
    public List<TypeJson> getAllTypes() {
        List<Type> types = typeService.findAllTypes();
        return typeMapper.typesToTypeJson(types);
    }

    @GetMapping("colors")
    @Operation(summary = "Displays all pet fur color options")
    public List<ColorJson> getAllColors() {
        List<Color> colors = colorService.findAllColors();
        return colorMapper.colorsToColorJson(colors);
    }
}
