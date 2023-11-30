package com.youcode.mypromotionapi.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class Promotion {
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private float percentage;


}
