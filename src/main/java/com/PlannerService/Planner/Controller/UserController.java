package com.PlannerService.Planner.Controller;

import com.PlannerService.Planner.DTO.MakePlanRequest;
import com.PlannerService.Planner.Entity.Plan;
import com.PlannerService.Planner.Service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController
{
    private final PlanService planService;
    // 일정 추가 메서드
    @PostMapping("/plan")
    public ResponseEntity<Plan> addPlan(@RequestBody MakePlanRequest request)
    {
        Plan makePlan = planService.save(request);

        // 요청한 자원을 성공적으로 생성 되었으며 저장된 일정의 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(makePlan);
    }
}
