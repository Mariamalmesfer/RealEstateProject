package com.example.realestateproject.Repository;


import com.example.realestateproject.Model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRepository extends JpaRepository<Deal,Integer> {

    Deal findDealById (Integer id);

    List<Deal> findDealByAgentId (Integer agentId );

    List<Deal> findDealByUserId (Integer userid );
}
