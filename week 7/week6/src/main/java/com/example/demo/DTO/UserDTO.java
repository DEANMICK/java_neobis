package com.example.demo.DTO;

import com.example.demo.Entity.User;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
public class UserDTO {
    private String name;
    private String email;
    private String password;

    public static UserDTO from(User user) {
        return builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}