package com.pet.petmanagement.domain.color;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ColorService {
    @Resource
    private ColorRepository colorRepository;

    public Color findColorBy(Integer colorId) {
       return colorRepository.findById(colorId).get();
    }
    public List<Color> findAllColors() {
       return colorRepository.findAll();
    }

    public Color findColorByName(String colorName) {
        return colorRepository.findByName(colorName);
    }
}
