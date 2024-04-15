package com.practice.classroom.dto;

import com.practice.classroom.entity.Task;
import com.practice.classroom.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserTaskDto {

    private String user;
    private String status;

    private String description;



}
