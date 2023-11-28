package com.PlannerService.Planner.DTO;

import lombok.Data;

@Data
public class JwtAuthenticationResponse
{
    private String token;
    private String refreshToken;
}
