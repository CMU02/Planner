package com.PlannerService.Planner.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 다른 클래스에서 생성자 호출 막는 애노테이션
@Getter
public class Plan
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id", nullable = false)
    private Long id; // 일정 아이디

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private User user; // 유저 아이디 외래키

    @Column(name = "plan_title", nullable = false)
    private String title; // 일정 제목

    @Column(name = "plan_start_time", nullable = false)
    private LocalDateTime startTime; // 일정 시작 날짜시간

    @Column(name = "plan_end_time", nullable = false)
    private LocalDateTime endTime; // 일정 종료 날짜시간

    @Column(name = "plan_memo")
    private String memo; // 일정 메모
}