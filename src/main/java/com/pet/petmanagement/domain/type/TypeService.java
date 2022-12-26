package com.pet.petmanagement.domain.type;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeService {

    @Resource
    private TypeRepository typeRepository;

    public Type findTypeByName(String typeName) {
       return typeRepository.findByName(typeName);
    }
    public List<Type> findAllTypes() {
       return typeRepository.findAll();
    }


}
