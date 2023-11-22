package com.PlannerService.Planner.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 다른 클래스에서 생성자 호출 막는 애노테이션
public class User
{
    @Id
    @Column(name = "user_id", nullable = false)
    private String id; // 유저 아이디

    @Column(name = "user_pw", nullable = false)
    private String pw; // 유저 비밀번호

    @Column(name = "user_email", nullable = false)
    private String email; // 유저 이메일

    @OneToMany(mappedBy = "user")
    private List<Plan> plans = new ArrayList<>(); // 일정 관리 엔티티 연결 (읽기 전용)

    @OneToMany(mappedBy = "user")
    private List<DiscussionsEntity> discussionsEntities = new ArrayList<>(); // 질문 게시판 엔티티 연결 (읽기 전용)

}
