package com.example.realestateproject.Controller;

import com.example.realestateproject.ApiResponse.ApiResponse;
import com.example.realestateproject.Model.Property;
import com.example.realestateproject.Model.Ratings;
import com.example.realestateproject.Model.User;
import com.example.realestateproject.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;



    @GetMapping("/get")
    public ResponseEntity getAllUser() {

        return ResponseEntity.status(200).body(userService.getAllUser());
    }


    @PostMapping("/add")
    public ResponseEntity addUsers(@RequestBody @Valid User user) {
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUsers(@PathVariable Integer id, @RequestBody @Valid  User user ){
        userService.updateUser(id,user );
        return ResponseEntity.status(200).body(new ApiResponse("User updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted"));
    }

    @GetMapping("/getbyloc/{location}")
    public ResponseEntity getbylication(@PathVariable String location){
        List<Property> properties = userService.getbylocation(location);
        return ResponseEntity.status(200).body(properties);
    }

    @GetMapping("/getbysize/{size}")
    public ResponseEntity getbysize(@PathVariable String size){
        List<Property> properties = userService.getbySize(size);
        return ResponseEntity.status(200).body(properties);
    }

    @GetMapping("/getbysortpriec")
    public ResponseEntity getbysortpriec(){
        List<Property> properties = userService.sortbyprice();
        return ResponseEntity.status(200).body(properties);
    }

    @PostMapping("/add/r")
    public ResponseEntity addr(@RequestBody @Valid Ratings ratings) {
        userService.addRarting(ratings);
        return ResponseEntity.status(200).body(new ApiResponse("Ratings added"));

    }

    @GetMapping("/rating")
    public ResponseEntity rating(){

        return ResponseEntity.status(200).body(userService.getrateing());
    }

    @GetMapping("/rating/{id}")
    public ResponseEntity ratingbyid(@PathVariable Integer id){
        return ResponseEntity.status(200).body(userService.getraitingp(id));
    }

    @GetMapping("/deals/{id}")
    public ResponseEntity deals(@PathVariable Integer id){
        return ResponseEntity.status(200).body(userService.dealList(id));
    }













}
