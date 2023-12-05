package com.PlannerService.Planner.DTO;

import com.PlannerService.Planner.Entity.Plan;
import com.PlannerService.Planner.Entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class PlanResponse {
    private final String title;
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final String memo;

    public PlanResponse(Plan plan) {
        this.title = plan.getTitle();
        this.start = plan.getStart();
        this.end = plan.getEnd();
        this.memo = plan.getMemo();
    }
}
