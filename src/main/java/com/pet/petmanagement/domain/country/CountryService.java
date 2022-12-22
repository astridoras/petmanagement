package com.pet.petmanagement.domain.country;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CountryService {

    @Resource
    private CountryRepository countryRepository;


    public Country findCountryBy(Integer countryId) {
       return countryRepository.findById(countryId).get();
    }
}
