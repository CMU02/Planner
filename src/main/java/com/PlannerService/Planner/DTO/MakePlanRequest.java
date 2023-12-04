package com.PlannerService.Planner.DTO;


import com.PlannerService.Planner.Entity.Plan;
import com.PlannerService.Planner.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MakePlanRequest {
    private String title;
    private User user;
    private String start;
    private String end;
    private String memo;

    public Plan toEntity() {
        return Plan.builder()
                .title(title)
                .user(user)
                .start(start)
                .end(end)
                .memo(memo)
                .build();
    }
}
