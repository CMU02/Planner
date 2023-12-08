package com.PlannerService.Planner.DTO;

import com.PlannerService.Planner.Entity.Plan;
import com.PlannerService.Planner.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdatePlanRequest
{
    private String title;
    private String startDateTime;
    private String endDateTime;
    private String memo;
}
