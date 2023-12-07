package com.PlannerService.Planner.Controller;

import com.PlannerService.Planner.DTO.JwtAuthenticationResponse;
import com.PlannerService.Planner.DTO.RefreshTokenRequest;
import com.PlannerService.Planner.DTO.SignInRequest;
import com.PlannerService.Planner.DTO.SignUpRequest;
import com.PlannerService.Planner.Entity.TokenEntity;
import com.PlannerService.Planner.Entity.User;
import com.PlannerService.Planner.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController
{
    private final AuthenticationService authenticationService;

    @PostMapping("/signup") // 회원가입 API
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin") // 로그인 API
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest) {
        var result = authenticationService.signIn(signInRequest);
        TokenEntity.token = result.getToken();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
}
