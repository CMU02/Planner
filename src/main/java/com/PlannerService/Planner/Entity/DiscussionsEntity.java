package com.PlannerService.Planner.Entity;


import com.PlannerService.Planner.DTO.DiscussionsDTO;
import com.PlannerService.Planner.Repository.CategoriesRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DiscussionsEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dcs_id")
    private Long id; // 질문게시판 아이디

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user; // 유저 아이디 외래키

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "categories_id")
    private Categories categories; // 카테고리 아이디 외래키

    @Column(name="dcs_title", nullable = false)
    private String title; // 질문 제목

    @Column(name="dcs_content", nullable = false)
    private String content = ""; // 질문 내용

    public static DiscussionsEntity toEntity(DiscussionsDTO discussionsDTO){
        DiscussionsEntity discussionsEntity = new DiscussionsEntity();
        //discussionsEntity.user = discussionsDTO.getUser_id();
        //User userEntity = new User();
        //discussionsEntity.setUser(userEntity);
        discussionsEntity.title = discussionsDTO.getDcs_title();
        discussionsEntity.content = discussionsDTO.getDcs_content();
        return discussionsEntity;
    }
}