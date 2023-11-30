package com.youcode.mypromotionapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.youcode.mypromotionapi.entities.Product;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;
@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor

public class ProductPromotionDto  {
    private UUID uuid;
    private float percentage;
    @ToString.Exclude
    @JsonBackReference
    private Product product;



}
