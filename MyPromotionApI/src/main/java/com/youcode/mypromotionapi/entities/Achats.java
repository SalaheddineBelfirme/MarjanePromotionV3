package com.youcode.mypromotionapi.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Achats")
public class Achats {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @JsonManagedReference
    @OneToOne()
    private Product product;
    @JsonManagedReference
    @ManyToOne()
    private Agent agent;
    @JsonManagedReference
    @ManyToOne()
    private Client client;



}
