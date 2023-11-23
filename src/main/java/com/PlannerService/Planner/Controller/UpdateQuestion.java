package com.PlannerService.Planner.Controller;

import com.PlannerService.Planner.DTO.DiscussionsDTO;
import com.PlannerService.Planner.Entity.DiscussionsEntity;
import com.PlannerService.Planner.Service.DiscussionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class UpdateQuestion {
    private final DiscussionsService discussionsService;

    @GetMapping("/discussions")
    public List<DiscussionsDTO> GetQuestion(){
        return discussionsService.getQuestions();
    }
}
