package com.api.projectmanagement.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.projectmanagement.dtos.TaskPostDTO;
import com.api.projectmanagement.dtos.TaskPutDTO;
import com.api.projectmanagement.entities.Project;
import com.api.projectmanagement.entities.Task;
import com.api.projectmanagement.entities.enums.TaskStatus;
import com.api.projectmanagement.repositories.TaskRepository;
import com.api.projectmanagement.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ProjectService projectService;

	public Task findById(Long id) {
		Optional<Task> task = taskRepository.findById(id);
		return task.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Task> findByProjectId(Long projectId) {
		Project project = projectService.findById(projectId);
		return project.getTasks();
	}

	@Transactional
	public Task save(TaskPostDTO taskDTO) {
		Project project = projectService.findById(taskDTO.getProjectId());

		Task task = new Task(taskDTO.getDescription(),
				Instant.parse(taskDTO.getDeadLine()),
				TaskStatus.valueOf(taskDTO.getStatus()), project);

		return taskRepository.save(task);
	}

	@Transactional
    public void delete(Long id) {
		findById(id);
		taskRepository.deleteById(id);
    }

	public Task update(Long id, TaskPutDTO task) {

		try {
			Task entity = taskRepository.getReferenceById(id);
			updateData(entity, task);
			return taskRepository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Task entity, TaskPutDTO task) {
		entity.setDescription(task.getDescription());
		entity.setDeadLine(Instant.parse(task.getDeadLine()));
		entity.setStatus(TaskStatus.valueOf(task.getStatus()));
	}

}
