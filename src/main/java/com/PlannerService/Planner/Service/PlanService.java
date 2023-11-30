package com.PlannerService.Planner.Service;

import com.PlannerService.Planner.DTO.MakePlanRequest;
import com.PlannerService.Planner.Entity.Plan;

import java.util.List;

public interface PlanService {
    Plan save(MakePlanRequest makePlanRequest);
    List<Plan> findAll();

}
