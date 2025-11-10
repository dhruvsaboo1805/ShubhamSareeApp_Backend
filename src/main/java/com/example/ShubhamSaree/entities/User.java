package com.example.ShubhamSaree.entities;

import com.example.ShubhamSaree.enums.UserRoleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity(name = "user")
public class User extends BaseEntity{

    @NotBlank(message = "Full name cannot be blank")
    @Size(min = 2, max = 50, message = "Full name must be between 2 and 50 characters")
    @Column(nullable = false)
    private String fullName;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Please provide a valid email address")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Mobile number cannot be blank")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid Indian mobile number")
    @Column(nullable = false, unique = true, length = 10)
    private String mobileNumber;

    @NotNull(message = "Role type is required")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleType roleType;

    // RelationsShips TODO
}
