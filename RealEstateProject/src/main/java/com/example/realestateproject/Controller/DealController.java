package com.example.realestateproject.Controller;

import com.example.realestateproject.ApiResponse.ApiResponse;
import com.example.realestateproject.Model.Deal;
import com.example.realestateproject.Service.DealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/deal")
public class DealController {

    private final DealService dealService ;

    @GetMapping("/get")
    public ResponseEntity getAllDeals() {

        return ResponseEntity.status(200).body(dealService.getAllDeals());
    }


    @PostMapping("/add")
    public ResponseEntity addDeals(@RequestBody @Valid Deal deal) {
        dealService.addDeal(deal);
        return ResponseEntity.status(200).body(new ApiResponse("Deal added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateDeals(@PathVariable Integer id, @RequestBody @Valid  Deal deal ){
        dealService.updateDeal(id,deal );
        return ResponseEntity.status(200).body(new ApiResponse("Deal updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletDeal(@PathVariable Integer id){
        dealService.deleteDeal(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deal deleted"));
    }
}
