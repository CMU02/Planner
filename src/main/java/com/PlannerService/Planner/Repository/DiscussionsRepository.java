package com.PlannerService.Planner.Repository;

import com.PlannerService.Planner.Entity.DiscussionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionsRepository extends JpaRepository<DiscussionsEntity, Long> {
}
