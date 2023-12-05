package com.PlannerService.Planner.DTO;

import com.PlannerService.Planner.Entity.Plan;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PlanViewResponse {
    private final Long id;
    private final String title;
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final String memo;

    public PlanViewResponse(Plan plan)
    {
        this.id = plan.getId();
        this.title = plan.getTitle();
        this.start = plan.getStart();
        this.end = plan.getEnd();
        this.memo = plan.getMemo();
    }
}
