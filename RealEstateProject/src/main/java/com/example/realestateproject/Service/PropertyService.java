package com.example.realestateproject.Service;


import com.example.realestateproject.ApiResponse.ApiException;
import com.example.realestateproject.Model.Property;
import com.example.realestateproject.Repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public List<Property> getAllProperty(){

        return propertyRepository.findAll();
    }

    public void addProperty(Property property){

        propertyRepository.save(property);
    }

    public void updateProperty(Integer id,Property property) {
        Property OldProperty= propertyRepository.findPropertiesById(id);
        if (OldProperty==null){
            throw new ApiException("id not found");
        }
        OldProperty.setTitle(property.getTitle());
        OldProperty.setDescription(property.getDescription());
        OldProperty.setSize(property.getSize());
        OldProperty.setPrice(property.getPrice());
        OldProperty.setLocation(property.getLocation());
        OldProperty.setBedrooms(property.getBedrooms());
        OldProperty.setBathrooms(property.getBathrooms());
        OldProperty.setAgentid(property.getAgentid());

    }

    public void deleteProperty(Integer id) {
        Property OldProperty= propertyRepository.findPropertiesById(id);
        if (OldProperty==null){
            throw new ApiException("id not found");
        }
        propertyRepository.delete(OldProperty);
    }



















}
