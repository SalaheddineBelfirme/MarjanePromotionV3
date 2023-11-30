package com.youcode.mypromotionapi.controllers;

import com.youcode.mypromotionapi.dto.ClientDto;
import com.youcode.mypromotionapi.entities.Agent;
import com.youcode.mypromotionapi.entities.Client;
import com.youcode.mypromotionapi.services.implementation.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    private  ClientServiceImp serviceImp;
    @Autowired
    public ClientController(ClientServiceImp clientServiceImp){
        this.serviceImp=clientServiceImp;
    }

    @PostMapping
    public ResponseEntity<String>createClient(@RequestBody Client client){
        if (serviceImp.create(client).isPresent()){
            return new ResponseEntity<>("client is added", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("try again", HttpStatus.OK);
    }
    @DeleteMapping("{uuid}")
    public  ResponseEntity<String>deleteClient(@PathVariable UUID uuid){
        System.out.println("deleate mapped");
        if (serviceImp.delete(uuid)){
            return new ResponseEntity<>("client is deleted", HttpStatus.OK);

        }
        return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);

    }
    @GetMapping
    public String getClient(){
        return  "get client mapped";
    }

}
