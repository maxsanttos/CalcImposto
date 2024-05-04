package com.max.calcimposto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.calcimposto.model.User;
import com.max.calcimposto.repository.UserRepository;

@Service
public class UserService {

     @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User newUser) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setNome(newUser.getNome());
            existingUser.setSalario(newUser.getSalario());
            return userRepository.save(existingUser);
        } else {
            return null; // Retorna null se o usuário não for encontrado
        }
    }

    public boolean deleteUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            userRepository.deleteById(userId);
            return true;
        } else {
            return false; // Retorna false se o usuário não for encontrado
        }
    }

}
