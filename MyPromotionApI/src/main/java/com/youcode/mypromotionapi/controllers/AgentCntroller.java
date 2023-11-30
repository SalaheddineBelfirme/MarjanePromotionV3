package com.youcode.mypromotionapi.controllers;

import com.youcode.mypromotionapi.dto.AgentDto;
import com.youcode.mypromotionapi.dto.requests.AgentDtoRequest;
import com.youcode.mypromotionapi.entities.Agent;
import com.youcode.mypromotionapi.services.implementation.AgentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/agent")
public class AgentCntroller {
    private AgentServiceImp service;

    @Autowired
    public  AgentCntroller(AgentServiceImp agentServiceImp){
        this.service=agentServiceImp;
    }
    @PostMapping
    public ResponseEntity<String>createAgent(@RequestBody Agent agent){

        if (service.create(agent).isPresent()){
            return  new ResponseEntity<>("Agent is added", HttpStatus.CREATED);
        }
        return  new ResponseEntity<>("try again", HttpStatus.BAD_REQUEST);

    }
    @DeleteMapping("/{uuid}")
    public  ResponseEntity<String>deleteAgent(@PathVariable UUID uuid){
        System.out.println("uuid is :"+uuid);
        if (service.delete(uuid)){
            System.out.println("bingo in ");
            return  new ResponseEntity<>("Agent is deleted", HttpStatus.FOUND);
        }
        return  new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);

    }



}
