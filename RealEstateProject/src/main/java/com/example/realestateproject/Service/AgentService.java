package com.example.realestateproject.Service;

import com.example.realestateproject.ApiResponse.ApiException;
import com.example.realestateproject.Model.Agent;
import com.example.realestateproject.Model.Deal;
import com.example.realestateproject.Repository.AgentRepository;
import com.example.realestateproject.Repository.DealRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final AgentRepository agentRepository ;

    private final DealRepository dealRepository;

    public List<Agent> getAllAgents(){

        return agentRepository.findAll();
    }

    public void addAgent(Agent agent){

        agentRepository.save(agent);
    }

    public void updateAgent(Integer id,Agent agent) {
        Agent OldAgent= agentRepository.findAgentById(id);
        if (OldAgent==null){
            throw new ApiException("id not found");
        }

        OldAgent.setUsername(agent.getUsername());
        OldAgent.setPassword(agent.getPassword());
        OldAgent.setEmail(agent.getEmail());
        OldAgent.setPhoneNumber(agent.getPhoneNumber());

    }

    public void deleteAgent(Integer id) {
        Agent OldAgent= agentRepository.findAgentById(id);
        if (OldAgent==null){
            throw new ApiException("id not found");
        }
        agentRepository.delete(OldAgent);
    }

    // get all agent deals
    public List<Deal> dealList (Integer id){
        List<Deal> d=dealRepository.findDealByAgentId(id);
        if (d==null){
            throw new ApiException("no deals");
        }
        return d;
    }


}
