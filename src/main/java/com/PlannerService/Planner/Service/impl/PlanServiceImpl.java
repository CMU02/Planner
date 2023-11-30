package com.PlannerService.Planner.Service.impl;

import com.PlannerService.Planner.DTO.MakePlanRequest;
import com.PlannerService.Planner.Entity.Plan;
import com.PlannerService.Planner.Repository.PlanRepository;
import com.PlannerService.Planner.Service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;

//    일정 추가 메서드
    public Plan save(MakePlanRequest makePlanRequest) {

        return planRepository.save(makePlanRequest.toEntity());
    }
}