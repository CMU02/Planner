package com.PlannerService.Planner.DTO;

import com.PlannerService.Planner.Entity.Plan;
import lombok.Getter;

@Getter
public class PlanViewResponse {
    private final Long id;
    private final String title;
    private final String startDateTime;
    private final String endDateTime;
    private final String memo;

    public PlanViewResponse(Plan plan)
    {
        this.id = plan.getId();
        this.title = plan.getTitle();
        this.startDateTime = plan.getStartTime();
        this.endDateTime = plan.getEndTime();
        this.memo = plan.getMemo();
    }
}
