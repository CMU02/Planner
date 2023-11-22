package com.PlannerService.Planner.Repository;

import com.PlannerService.Planner.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>
{
}
