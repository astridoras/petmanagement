package com.pet.petmanagement.domain.user;

import com.pet.petmanagement.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User getExistingUser(String username, String password) {
        Optional<User> userOptional = userRepository.findBy(username, password);
        Validation.validateUserCredentials(userOptional);

        return userOptional.get();

    }

    public Optional<User> findUserBy(Integer userId) {
      return userRepository.findById(userId);

    }
}
