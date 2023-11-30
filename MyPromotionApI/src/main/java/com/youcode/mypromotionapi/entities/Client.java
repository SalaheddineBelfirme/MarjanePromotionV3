package com.youcode.mypromotionapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client")
@Data
public class Client {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID uuid ;
    private  String cart_fideliti;
    private  String name;
    private String email;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Achats> achats;

}
