package com.example.realestateproject.Controller;

import com.example.realestateproject.ApiResponse.ApiResponse;
import com.example.realestateproject.Model.Property;
import com.example.realestateproject.Service.PropertyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/property")
public class PropertyController {

    private final PropertyService propertyService;


    @GetMapping("/get")
    public ResponseEntity getAllProperty() {

        return ResponseEntity.status(200).body(propertyService.getAllProperty());
    }


    @PostMapping("/add")
    public ResponseEntity addPropertys(@RequestBody @Valid Property property) {
        propertyService.addProperty(property);
        return ResponseEntity.status(200).body(new ApiResponse("Property added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateProperty(@PathVariable Integer id, @RequestBody @Valid  Property property ){
        propertyService.updateProperty(id,property );
        return ResponseEntity.status(200).body(new ApiResponse("Property updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletProperty(@PathVariable Integer id){
        propertyService.deleteProperty(id);
        return ResponseEntity.status(200).body(new ApiResponse("Property deleted"));
    }


}
