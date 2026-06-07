package com.microservice.User_Service.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.microservice.User_Service.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is Required")
    private String name;
    @Column(unique = true, nullable = false)
    @Email(message = "Invalid Email Format")
    @NotBlank(message = "Email is Required")
    private String email;
    @NotBlank
    @Size(min = 5, message = "Password must be at least 5 Characters")
    private String password;
    @NotBlank
    private String phone;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "user")
    @JsonManagedReference
    private List<Address> address = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
