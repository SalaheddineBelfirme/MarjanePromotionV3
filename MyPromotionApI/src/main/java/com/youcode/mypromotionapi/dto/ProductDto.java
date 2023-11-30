package com.youcode.mypromotionapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.youcode.mypromotionapi.entities.ProductPromotion;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Data
@NoArgsConstructor
@Component
public class ProductDto {
    private UUID uuid;
    private String name;
    private String brand;
    private float price;
    @JsonBackReference
    private ProductPromotion productPromotion;

}
