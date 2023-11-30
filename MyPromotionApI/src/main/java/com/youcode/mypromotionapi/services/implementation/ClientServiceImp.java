package com.youcode.mypromotionapi.services.implementation;

import com.youcode.mypromotionapi.entities.Client;
import com.youcode.mypromotionapi.repositories.ClientRepositorie;
import com.youcode.mypromotionapi.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImp implements AdministratorService<Client> {

    private final ClientRepositorie repositorie;
    @Autowired
    public ClientServiceImp(ClientRepositorie clientRepositorie){
        this.repositorie=clientRepositorie;
    }
    @Override
    public Optional<Client> login(Client o) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> create(Client o) {
        return Optional.of(repositorie.save(o));
    }

    @Override
    public boolean delete(UUID uuid) {
        try{
            repositorie.deleteById(uuid);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
}
