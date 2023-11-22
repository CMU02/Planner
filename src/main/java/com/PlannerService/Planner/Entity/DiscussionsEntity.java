package com.PlannerService.Planner.Entity;


import com.PlannerService.Planner.DTO.DiscussionsDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import static jakarta.persistence.FetchType.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 다른 클래스에서 생성자 호출 막는 애노테이션
@Getter
@Setter
public class DiscussionsEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dcs_id")
    private Long id; // 질문게시판 아이디

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private User user; // 유저 아이디 외래키

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "categories_id")
    private Categories categories; // 카테고리 아이디 외래키

    @Column(name="dcs_title", nullable = false)
    private String title; // 질문 제목

    @Column(name="dcs_content", nullable = false)
    private String content = ""; // 질문 내용

    public static DiscussionsEntity toEntity(DiscussionsDTO discussionsDTO){
        System.out.println("DTO ->  Service -> Entity");
        DiscussionsEntity discussionsEntity = new DiscussionsEntity();
        discussionsEntity.id = discussionsDTO.getDcs_id();
        discussionsEntity.user = discussionsDTO.getUser_id();
        discussionsEntity.categories = discussionsDTO.getCate_id();
        discussionsEntity.title = discussionsDTO.getDcs_title();
        discussionsEntity.content = discussionsDTO.getDcs_content();
        return discussionsEntity;
    }
}
