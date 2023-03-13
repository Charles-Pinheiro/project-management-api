package com.api.projectmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.projectmanagement.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
