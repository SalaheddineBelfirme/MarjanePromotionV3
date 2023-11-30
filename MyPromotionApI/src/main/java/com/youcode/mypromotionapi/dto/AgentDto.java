package com.youcode.mypromotionapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor

public class AgentDto {
    private String email;
    private String password;
}
