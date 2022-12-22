package com.pet.petmanagement.domain.type;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TypeService {

    @Resource
    private TypeRepository typeRepository;

    public Type findTypeBy(Integer typeId) {
       return typeRepository.findById(typeId).get();
    }
}
