package com.api.projectmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.projectmanagement.entities.Task;
import com.api.projectmanagement.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	public Task findById(Long id) {
		Optional<Task> task = taskRepository.findById(id);
		return task.get();
	}
}
