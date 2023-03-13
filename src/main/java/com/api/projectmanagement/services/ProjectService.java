package com.api.projectmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.projectmanagement.entities.Project;
import com.api.projectmanagement.repositories.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	public Project findById(Long id) {
		Optional<Project> project = projectRepository.findById(id);
		return project.get();
	}

	@Transactional
	public Project save(Project project) {
		return projectRepository.save(project);
	}

}
