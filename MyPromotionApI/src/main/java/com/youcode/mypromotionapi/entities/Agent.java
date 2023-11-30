package com.youcode.mypromotionapi.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "agent")
public class Agent extends Administrator{
    @OneToMany(fetch = FetchType.LAZY)
    private List <Achats> achats;

}
