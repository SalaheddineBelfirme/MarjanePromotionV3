package com.youcode.mypromotionapi.dto.requests;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor

public class AgentDtoRequest {
    private String email;
    private String password;
}