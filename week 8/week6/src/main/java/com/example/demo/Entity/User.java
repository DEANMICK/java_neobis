package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email
    @NotBlank
    @Size(min = 1, max = 128)
    @Column(name = "email", length = 128)
    private String email;

    @NotBlank
    @Size(min = 8, max = 128)
    @Column(name = "password", length = 128)
    private String password;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(name = "name", length = 128)
    private String name;

    @Column
    @Builder.Default
    private boolean enabled = true;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    @Builder.Default
    private String role = "USER";
}
