package com.practice.classroom.repository;

import com.practice.classroom.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {
    @Query(value = "SELECT * FROM task WHERE course_id = ?1", nativeQuery = true)
    List<Task> findTasksByCourseId(Long courseId);

}
