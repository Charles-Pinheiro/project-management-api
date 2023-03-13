package com.api.projectmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.projectmanagement.entities.Project;
import com.api.projectmanagement.repositories.ProjectRepository;
import com.api.projectmanagement.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
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
		return project.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public Project save(Project project) {
		return projectRepository.save(project);
	}

	@Transactional
    public void delete(Long id) {
		findById(id);
        projectRepository.deleteById(id);
    }

	public Project update(Long id, Project project) {

		try {
			Project entity = projectRepository.getReferenceById(id);
			updateData(entity, project);
			return projectRepository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Project entity, Project project) {
		entity.setName(project.getName());
		entity.setDescription(project.getDescription());
	}

}
