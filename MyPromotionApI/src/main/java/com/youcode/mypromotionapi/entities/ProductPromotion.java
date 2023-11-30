package com.youcode.mypromotionapi.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "product_promotion")
public class ProductPromotion extends Promotion{
    @JsonManagedReference
    @OneToOne
    private Product product;
    @OneToMany
    private List<PromotionStatus> status;


}
