package com.practice.classroom.repository;

import com.practice.classroom.entity.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTaskRepo extends JpaRepository<UserTask,Long> {
    @Query(value = "SELECT * FROM user_task WHERE user_id = ?1 AND status = ?2", nativeQuery = true)
    List<UserTask> getTasksForUserIdAndStatus(Long userId, String status);
}
