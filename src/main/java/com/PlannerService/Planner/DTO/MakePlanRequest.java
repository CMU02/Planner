package com.PlannerService.Planner.DTO;


import com.PlannerService.Planner.Entity.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MakePlanRequest {
    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String memo;

    public Plan toEntity() {
        return Plan.builder()
                .title(title)
                .startTime(startDateTime)
                .endTime(endDateTime)
                .memo(memo)
                .build();
    }
}
