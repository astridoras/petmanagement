package com.pet.petmanagement.business.login;

import com.pet.petmanagement.domain.color.Color;
import com.pet.petmanagement.domain.color.ColorService;
import com.pet.petmanagement.domain.country.Country;
import com.pet.petmanagement.domain.country.CountryService;
import com.pet.petmanagement.domain.type.Type;
import com.pet.petmanagement.domain.type.TypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//TODO fix
@CrossOrigin(maxAge = 3600)

@RestController
@RequestMapping("/")
public class ClassifierController {
    @Resource
    private CountryService countryService;
    @Resource
    private ColorService colorService;
    @Resource
    private TypeService typeService;

    @GetMapping("countries")
    public List<Country> getAllCountries() {
        //Todo mapper
        return countryService.findAllCountries();
    }

    @GetMapping("types")
    public List<Type> getAllTypes() {
        //Todo mapper
        return typeService.findAllTypes();
    }

    @GetMapping("colors")
    public List<Color> getAllColors() {
        //Todo mapper
        return colorService.findAllColors();
    }
}
