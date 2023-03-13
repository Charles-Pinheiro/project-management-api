package com.api.projectmanagement.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.projectmanagement.entities.Task;
import com.api.projectmanagement.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

	@Autowired
	private TaskService taskService;

	@GetMapping
	public ResponseEntity<List<Task>> getAllProjects() {
		List<Task> tasks = taskService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(tasks);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Task> getProjectById(@PathVariable Long id) {
		Task task = taskService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(task);
	}
}
