package com.PlannerService.Planner.Repository;

import com.PlannerService.Planner.Entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,Long> {

}
