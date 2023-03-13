package com.api.projectmanagement.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.projectmanagement.dtos.TaskPostDTO;
import com.api.projectmanagement.dtos.TaskPutDTO;
import com.api.projectmanagement.entities.Project;
import com.api.projectmanagement.entities.Task;
import com.api.projectmanagement.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

	@Autowired
	private TaskService taskService;

	@GetMapping(value = "/{projectId}")
	public ResponseEntity<List<Task>> getTasksByProjectId(@PathVariable Long projectId) {
		List<Task> tasks = taskService.findByProjectId(projectId);
		return ResponseEntity.status(HttpStatus.OK).body(tasks);
	}

	@PostMapping
	public ResponseEntity<Task> saveTask(@RequestBody TaskPostDTO taskDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(taskDTO));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		taskService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskPutDTO task) {
		return ResponseEntity.status(HttpStatus.OK).body(taskService.update(id, task));
	}
}
