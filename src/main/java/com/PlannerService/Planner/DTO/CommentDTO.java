package com.PlannerService.Planner.DTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO {
    private String comment_title;
    private String comment_content;
    private String comment_cate;
    private String username;
}