package com.youcode.mypromotionapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;
    private String brand;
    private float price;
    @JsonBackReference
    @ToString.Exclude
    @OneToOne( mappedBy = "product",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductPromotion productPromotion;
    @ManyToOne(fetch = FetchType.LAZY)
    private  Category category;
    @OneToOne(fetch = FetchType.LAZY)
    private  Achats achats;
}
