package com.PlannerService.Planner.Service;

import com.PlannerService.Planner.DTO.JwtAuthenticationResponse;
import com.PlannerService.Planner.DTO.RefreshTokenRequest;
import com.PlannerService.Planner.DTO.SignInRequest;
import com.PlannerService.Planner.DTO.SignUpRequest;
import com.PlannerService.Planner.Entity.User;

public interface AuthenticationService
{
    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signIn(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
