package com.PlannerService.Planner.Controller;

import com.PlannerService.Planner.DTO.UserDTO;
import com.PlannerService.Planner.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    @GetMapping("/User/new")
    public String createdAccountForm() {
        return "createdAccount";
    }

    @PostMapping("/User/new")
    public String createdAccountUser(UserDTO userDTO) {
        String userId = userService.join(userDTO);
        return "createdAccount";
    }
}
