package com.PlannerService.Planner.DTO;

import com.PlannerService.Planner.Entity.Plan;
import com.PlannerService.Planner.Entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class PlanResponse {
    private final String title;
    private final String startDateTime;
    private final String endDateTime;
    private final String memo;

    public PlanResponse(Plan plan) {
        this.title = plan.getTitle();
        this.startDateTime = plan.getStartTime();
        this.endDateTime = plan.getEndTime();
        this.memo = plan.getMemo();
    }
}
