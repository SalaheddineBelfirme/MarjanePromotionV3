package com.youcode.mypromotionapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Data
@NoArgsConstructor
public class ClientDto {
    private UUID uuid ;
    private  String cart_fideliti;
    private  String name;
    private String email;
}
