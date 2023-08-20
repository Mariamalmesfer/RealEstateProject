package com.example.realestateproject.Repository;

import com.example.realestateproject.Model.Agent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Integer> {

    Agent findAgentById (Integer id);


}
