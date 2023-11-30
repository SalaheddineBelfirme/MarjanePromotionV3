package com.youcode.mypromotionapi.entities;

import com.youcode.mypromotionapi.enums.Promotioneta;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "PromotionStatus")
@Data
public class PromotionStatus {
    @Id
    @GeneratedValue
    private UUID uuid;
    private Promotioneta status;
    @ManyToOne
    private  ProductPromotion promotion;
    @ManyToOne
    private DepartmentAdministrator admin ;

}
