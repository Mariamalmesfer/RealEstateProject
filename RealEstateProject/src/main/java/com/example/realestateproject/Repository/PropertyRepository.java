package com.example.realestateproject.Repository;

import com.example.realestateproject.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PropertyRepository extends JpaRepository<Property,Integer> {

    Property findPropertiesById (Integer id);

    List<Property> findPropertiesByLocation (String location);

    List<Property> findPropertiesBySize (String size);

   // List<Property> findPropertiesByPrice(Integer price);



}
