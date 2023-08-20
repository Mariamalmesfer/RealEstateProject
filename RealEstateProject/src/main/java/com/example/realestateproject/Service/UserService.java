package com.example.realestateproject.Service;

import com.example.realestateproject.ApiResponse.ApiException;

import com.example.realestateproject.Model.Deal;
import com.example.realestateproject.Model.Property;
import com.example.realestateproject.Model.Ratings;
import com.example.realestateproject.Model.User;
import com.example.realestateproject.Repository.DealRepository;
import com.example.realestateproject.Repository.PropertyRepository;
import com.example.realestateproject.Repository.RatingsRepository;
import com.example.realestateproject.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository ;

    private final PropertyRepository propertyRepository ;

    private final RatingsRepository ratingsRepostory ;



    private final  PropertyService propertyService;

    private final DealRepository dealRepository;


    public List<User> getAllUser(){

        return userRepository.findAll();
    }

    public void addUser(User user){

        userRepository.save(user);
    }

    public void updateUser(Integer id,User user) {
        User OldUser= userRepository.findUserById(id);
        if (OldUser==null){
            throw new ApiException("id not found");
        }

        OldUser.setUsername(user.getUsername());
        OldUser.setPassword(user.getPassword());
        OldUser.setEmail(user.getEmail());


    }

    public void deleteUser(Integer id) {
        User OldUser= userRepository.findUserById(id);
        if (OldUser==null){
            throw new ApiException("id not found");
        }
        userRepository.delete(OldUser);
    }


    // get all Property by location
    public List<Property> getbylocation(String location){
        List<Property> property= propertyRepository.findPropertiesByLocation(location);
        if (property.isEmpty()){
            throw new ApiException("property not found in this location");
        }
        return property;
    }


    // get all Property  by size
    public List<Property> getbySize(String size){
        List<Property> property= propertyRepository.findPropertiesBySize(size);
        if (property.isEmpty()){
            throw new ApiException("Property in this size not found");
        }
        return property;
    }



    // sort the price from low to hifh
    public List<Property> sortbyprice(){
        List<Property> property= propertyService.getAllProperty();
        if (property.isEmpty()){
            throw new ApiException("Property in this size not found");
        }
         property.sort(Comparator.comparingDouble(Property::getPrice));
        return property;
    }






    // add the propert for rent a review
public void addRarting (Ratings ratings) {
    Property properties = propertyRepository.findPropertiesById(ratings.getProperty_id());
    if (properties == null) {
        throw new ApiException("id not found");
    }
    User user = userRepository.findUserById(ratings.getUser_id());
    if (user == null) {
        throw new ApiException("id not found");
    }
    List <Ratings> ratings1 = getrateing();
    if (properties.getDescription().equals("Rent") ) {
        if (ratings1 == null){  ratingsRepostory.save(ratings);}          //ratingServiec.addraiting(ratings); }
            for (Ratings r : ratings1) {
                if (r.getUser_id().equals(ratings.getUser_id())&& r.getProperty_id().equals(ratings.getProperty_id())) {
                    throw new ApiException("already rate the property ");
                }
                ratingsRepostory.save(ratings);
            }



    }
}

    public List<Ratings> getrateing(){

        return ratingsRepostory.findAll();
    }

    public String getraitingp (Integer pid){
        List <Ratings> ratings1 = getrateing();

        for (Ratings r : ratings1){
            if(r.getProperty_id() == pid){
                return (r.getReview() + r.getRating());
            }
        }
        return null;

    }

    public List<Deal> dealList (Integer id){
        List<Deal> d=dealRepository.findDealByUserId(id);
        if (d==null){
            throw new ApiException("no deals");
        }
        return d;
    }








}
