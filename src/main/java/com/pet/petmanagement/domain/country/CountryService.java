package com.pet.petmanagement.domain.country;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CountryService {

    @Resource
    private CountryRepository countryRepository;

    public List<Country> findAllCountries() {
       return countryRepository.findAll();
    }

    public Country findCountryByName(String countryName) {
        return countryRepository.findByName(countryName);
    }
}
