package com.youcode.mypromotionapi.services.implementation;

import com.youcode.mypromotionapi.entities.Agent;
import com.youcode.mypromotionapi.repositories.AgentRepositories;
import com.youcode.mypromotionapi.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class AgentServiceImp implements AdministratorService<Agent> {

    private AgentRepositories repositorie ;

    public AgentServiceImp(AgentRepositories agentRepositorie){
        this.repositorie=agentRepositorie;
    }

    @Override
    public Optional<Agent> login(Agent o) {
        return  null ;
    }

    @Override
    public Optional<Agent> create(Agent o) {
        o.setPassword(String.valueOf(o.getPassword().hashCode()));
        return Optional.of(repositorie.save(o));
    }

    @Override
    public boolean delete(UUID uuid) {
        try {
            repositorie.deleteById(uuid);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  false;
        }
    }
}
