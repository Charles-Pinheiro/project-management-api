package com.api.projectmanagement.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.projectmanagement.dtos.TaskPostDTO;
import com.api.projectmanagement.dtos.TaskPutDTO;
import com.api.projectmanagement.entities.Project;
import com.api.projectmanagement.entities.Task;
import com.api.projectmanagement.entities.enums.TaskStatus;
import com.api.projectmanagement.repositories.TaskRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ProjectService projectService;

	public List<Task> findAll() {
		return taskRepository.findAll();
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
		taskRepository.deleteById(id);
    }

	public Task update(Long id, TaskPutDTO task) {
		Task entity = taskRepository.getReferenceById(id);
		updateData(entity, task);
		return taskRepository.save(entity);
	}

	private void updateData(Task entity, TaskPutDTO task) {
		entity.setDescription(task.getDescription());
		entity.setDeadLine(Instant.parse(task.getDeadLine()));
		entity.setStatus(TaskStatus.valueOf(task.getStatus()));
	}
}
