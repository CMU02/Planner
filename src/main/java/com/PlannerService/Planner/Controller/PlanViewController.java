package com.PlannerService.Planner.Controller;

import com.PlannerService.Planner.DTO.PlanResponse;
import com.PlannerService.Planner.DTO.PlanViewResponse;
import com.PlannerService.Planner.Service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlanViewController {
    private final PlanService planService;

    @GetMapping("/calendar")
    public String getPlan(Model model)
    {
        List<PlanViewResponse> planner = planService.findAll()
                .stream()
                .map(PlanViewResponse::new)
                .toList();
        model.addAttribute("planner", planner);

        return "Calendar";
    }
}
