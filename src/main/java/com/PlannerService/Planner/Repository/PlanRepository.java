package com.PlannerService.Planner.Repository;

import com.PlannerService.Planner.Entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long>
{
}
