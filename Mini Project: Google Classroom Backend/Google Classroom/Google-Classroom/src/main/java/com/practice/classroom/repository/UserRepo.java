package com.practice.classroom.repository;

import com.practice.classroom.entity.Task;
import com.practice.classroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
