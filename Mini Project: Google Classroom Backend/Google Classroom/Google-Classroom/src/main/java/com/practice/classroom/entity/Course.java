package com.practice.classroom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String name;
    @OneToMany(mappedBy = "course")
    private List<User>users = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Task>tasks = new ArrayList<>();


}
