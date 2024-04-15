package com.practice.classroom.dto;

import com.practice.classroom.entity.Course;
import jakarta.persistence.*;
import lombok.*;


@Data

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDto {


    private Long id;

    private String description;

    private String submissionDate;


    private String course;
}
