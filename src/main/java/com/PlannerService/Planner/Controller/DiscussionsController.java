package com.PlannerService.Planner.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiscussionsController {
    @GetMapping("/askQuestion")
    public String askQuestion(){
        return "askQuestion";
    }
}
