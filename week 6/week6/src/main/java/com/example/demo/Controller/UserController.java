package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping
    public List<User> getAllUser() {
        return userService.findAllUser();
    }

    @PostMapping("/new")
    public User newUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/delete/id={id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id)
                .map(record -> {
                    userRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email={email}")
    public Optional<User> getUserByEmail(@PathVariable("email") String email) {
        return userService.findUserByEmail(email);
    }

    @PutMapping("/update/id={id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @GetMapping("/id={id}")
    public Optional<User> getUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }
}
