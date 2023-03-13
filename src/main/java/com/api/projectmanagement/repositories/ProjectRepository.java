package com.api.projectmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.projectmanagement.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
