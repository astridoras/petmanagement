package com.pet.petmanagement.domain.color;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ColorService {
    @Resource
    private ColorRepository colorRepository;

    public List<Color> findAllColors() {
       return colorRepository.findAll();
    }
    public Color findColorByName(String colorName) {
        return colorRepository.findByName(colorName);
    }
}
