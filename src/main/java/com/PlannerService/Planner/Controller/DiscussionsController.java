package com.PlannerService.Planner.Controller;

import com.PlannerService.Planner.DTO.DiscussionsDTO;
import com.PlannerService.Planner.Service.DiscussionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DiscussionsController {

    private final DiscussionsService discussionsService;
    @GetMapping("/askQuestion")
    public String askQuestion(){
        return "askQuestion";
    } //질문 올리는 페이지로 이동

    @PostMapping("/askQuestion")
    public String postQuestion(@ModelAttribute DiscussionsDTO dto){

        return "discussions";
    }
}
