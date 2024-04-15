package com.practice.classroom.dto;

import com.practice.classroom.entity.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto{
    private Long id;

    private String name;
    
    private Course course;
}
