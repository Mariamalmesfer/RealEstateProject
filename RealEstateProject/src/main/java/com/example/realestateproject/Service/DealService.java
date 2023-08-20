package com.example.realestateproject.Service;

import com.example.realestateproject.ApiResponse.ApiException;
import com.example.realestateproject.Model.Agent;
import com.example.realestateproject.Model.Deal;
import com.example.realestateproject.Repository.AgentRepository;
import com.example.realestateproject.Repository.DealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealService {

    private final DealRepository dealRepository ;



    public List<Deal> getAllDeals(){

        return dealRepository.findAll();
    }

    public void addDeal(Deal deal){

        dealRepository.save(deal);
    }

    public void updateDeal(Integer id,Deal deal) {
        Deal OldDeal= dealRepository.findDealById(id);
        if (OldDeal==null){
            throw new ApiException("id not found");
        }

        OldDeal.setDescription(deal.getDescription());
        OldDeal.setPrice(deal.getPrice());
        OldDeal.setAgentId(deal.getAgentId());
        OldDeal.setUserId(deal.getUserId());
        OldDeal.setPropertyId(deal.getPropertyId());


    }

    public void deleteDeal(Integer id) {
        Deal OldDeal= dealRepository.findDealById(id);
        if (OldDeal==null){
            throw new ApiException("id not found");
        }
        dealRepository.delete(OldDeal);
    }


}
