package com.example.demo.Service;

import com.example.demo.DTO.UserDTO;
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

    public Optional<UserDTO> findUserByEmail(String email) {
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

    public ResponseEntity<UserDTO> updateUser(Integer id, UserDTO userDTO) {
        userRepository.findById(id)
                .map(user -> {
                    user.setName(userDTO.getName());
                    user.setEmail(userDTO.getEmail());
                    user.setPassword(userDTO.getPassword());
                    User usr = userRepository.save(user);
                    return ResponseEntity.ok().body(usr);
                });
        return ResponseEntity.ok().build();
    }

    public UserDTO register(UserDTO userDTO) {
        var user = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
        userRepository.save(user);
        return UserDTO.from(user);
    }

    public Optional<UserDTO> getUserById(Integer id) {
        return userRepository.findUserById(id);
    }
}
