package com.pet.petmanagement.domain.color;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ColorService {

    @Resource
    private ColorRepository colorRepository;

    public Color findColorBy(Integer colorId) {
       return colorRepository.findById(colorId).get();
    }
}
