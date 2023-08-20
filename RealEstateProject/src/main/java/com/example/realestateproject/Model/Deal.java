package com.example.realestateproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Description is required")
    private String description;

    @NotNull(message = "Deal price is required")
    @Min(value = 0, message = "Deal price must be a positive value")
    private Double price;

    @NotNull(message = "Agent ID is required")
    private Long agentId;

    @NotNull(message = "Property ID is required")
    private Long propertyId;

    @NotNull(message = "User ID is required")
    private Long userId;


}
