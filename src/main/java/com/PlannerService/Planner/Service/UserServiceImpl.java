package com.PlannerService.Planner.Service;

import com.PlannerService.Planner.DTO.UserDTO;
import com.PlannerService.Planner.Entity.User;
import com.PlannerService.Planner.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    @Override
    public String join(UserDTO userDTO)
    {
        return userRepository.save(User.builder()
                .id(userDTO.getId())
                .pw(userDTO.getPw())
                .email(userDTO.getEmail())
                .build()).getId();
    }
}
