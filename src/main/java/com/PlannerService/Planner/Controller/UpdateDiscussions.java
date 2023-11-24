package com.PlannerService.Planner.Controller;

import com.PlannerService.Planner.DTO.DiscussionsDTO;
import com.PlannerService.Planner.Service.DiscussionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/discussions")
public class UpdateDiscussions {
    private final DiscussionsService discussionsService;


    @GetMapping("/new")
    public String GetQuestion(){
        return discussionsService.getQuestions();
    }
}
