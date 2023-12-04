package com.PlannerService.Planner.DTO;

import com.PlannerService.Planner.Entity.Plan;
import com.PlannerService.Planner.Entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class PlanResponse {
    private final String title;
    private final String start;
    private final String end;
    private final String memo;

    public PlanResponse(Plan plan) {
        this.title = plan.getTitle();
        this.start = plan.getStart();
        this.end = plan.getEnd();
        this.memo = plan.getMemo();
    }
}
