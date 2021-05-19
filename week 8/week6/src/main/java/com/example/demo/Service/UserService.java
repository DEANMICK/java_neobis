package com.example.demo.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import com.example.demo.Exception.UserAlreadyRegisteredException;
import com.example.demo.Form.UserRegisterForm;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public Optional<UserDTO> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public List<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
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
                    user.setPassword(encoder.encode(userDTO.getPassword()));
                    User usr = userRepository.save(user);
                    return ResponseEntity.ok().body(usr);
                });
        return ResponseEntity.ok().build();
    }

    public UserDTO register(UserRegisterForm userRegisterForm) {
        if (userRepository.existsByEmail(userRegisterForm.getEmail())) {
            throw new UserAlreadyRegisteredException();
        }

        var user = User.builder()
                .name(userRegisterForm.getName())
                .email(userRegisterForm.getEmail())
                .password(encoder.encode(userRegisterForm.getPassword()))
                .build();
        userRepository.save(user);
        return UserDTO.from(user);
    }

    public Optional<UserDTO> getUserById(Integer id) {
        return userRepository.findUserById(id);
    }
}
