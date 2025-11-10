package com.example.ShubhamSaree.entities;

import com.example.ShubhamSaree.enums.AddressType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name = "address")
public class Address extends BaseEntity {

    @NotBlank(message = "Address line 1 is required")
    @Size(max = 200, message = "Address line 1 must be at most 200 characters")
    @Column(name = "address_line_1", nullable = false, length = 200)
    private String addressLine1;

    @Size(max = 200, message = "Address line 2 must be at most 200 characters")
    @Column(name = "address_line_2", length = 200)
    private String addressLine2;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City must be at most 100 characters")
    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 100, message = "State must be at most 100 characters")
    @Column(name = "state", nullable = false, length = 100)
    private String state;

    @NotBlank(message = "Postal code is required")
    @Size(min = 3, max = 12, message = "Postal code must be between 3 and 12 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-\\s]{3,12}$", message = "Invalid postal code format")
    @Column(name = "postal_code", nullable = false, length = 12)
    private String postalCode;

    @NotBlank(message = "Country is required")
    @Size(max = 100, message = "Country must be at most 100 characters")
    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @NotNull(message = "Address type is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "address_type", nullable = false, length = 30)
    private AddressType addressType;

    @NotNull
    @Column(name = "is_default", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDefault = Boolean.FALSE;

    // Relationsships todo
}
