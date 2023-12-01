package com.youcode.mypromotionapi.dto.requests;

import com.youcode.mypromotionapi.entities.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Data
@NoArgsConstructor
public class PromtionReqest {
    private float percentage;
    private Product product;
}
