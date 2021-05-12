package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    public ResponseEntity<User> updateUser(Integer id, User users) {
        userRepository.findById(id)
                .map(user -> {
                    user.setName(users.getName());
                    user.setEmail(users.getEmail());
                    user.setPassword(users.getPassword());
                    User usr = userRepository.save(user);
                    return ResponseEntity.ok().body(usr);
                });
        return ResponseEntity.ok().build();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findUserById(id);
    }
}
