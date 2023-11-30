package com.youcode.mypromotionapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category_promotion")
public class CategoryPromotion extends Promotion{
    @OneToOne
    private Category category;
}
