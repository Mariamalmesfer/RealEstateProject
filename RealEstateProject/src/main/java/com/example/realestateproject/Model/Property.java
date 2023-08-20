package com.example.realestateproject.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class Property {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "Title  is required")
    @Column(columnDefinition = "varchar(5) not null")
    private String title;


    @NotEmpty(message = "Description is required")
    @Pattern(regexp = "^(Buy|Rent)$" , message = "must be for  buy or rent")
    private String description;


    @NotEmpty(message = "Property size is required")
    @Pattern(regexp ="^[0-9]+\\.[0-9]+m$" , message = "Invalid property size format. Must be in meters.")
    private String size;



    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be a positive number")
    private Double price;


    @NotEmpty(message = "Location is required")
    private String location;

    @NotNull(message = "Number of bedrooms is required")
    @Min(value = 0, message = "Number of bedrooms must be a positive number")
    //@Column(columnDefinition = "not null")
    private Integer bedrooms;

    @NotNull(message = "Number of bathrooms is required")
    @Min(value = 0, message = "Number of bathrooms must be a positive number")
   // @Column(columnDefinition = "not null")
    private Integer bathrooms;


    @NotNull(message = "The Agent ID must not be empty")
    private Integer agentid;

}
