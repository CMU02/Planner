package com.PlannerService.Planner.DTO;

import com.PlannerService.Planner.Entity.Categories;
import com.PlannerService.Planner.Entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO {
    private Long dcs_id; //게시판마다 고유한 댓글 목록을 관리
    private Long comment_id; //댓글 고유 id
    private User user_id;
    private String comment_content;
}
