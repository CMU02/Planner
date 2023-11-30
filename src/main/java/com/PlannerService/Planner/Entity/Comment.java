package com.PlannerService.Planner.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private Long id; //댓글 고유 id - 게시판과 연결하기 위함

    @Column(name="comment_content")
    private String content = ""; // 댓글 내용




}
