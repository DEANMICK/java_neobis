package com.example.demo.Repository;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<UserDTO> findUserByEmail(String email);
    Optional<UserDTO> findUserById(Integer id);
    boolean existsByEmail(String email);
    List<User> findUserByName(String name);
}
