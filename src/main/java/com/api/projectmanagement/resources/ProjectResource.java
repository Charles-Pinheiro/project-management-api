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

import com.api.projectmanagement.entities.Project;
import com.api.projectmanagement.services.ProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectResource {

	@Autowired
	private ProjectService projectService;

	@GetMapping
	public ResponseEntity<List<Project>> getAllProjects() {
		List<Project> projects = projectService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(projects);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
		Project project = projectService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(project);
	}

	@PostMapping
	public ResponseEntity<Project> saveProject(@RequestBody Project project) {
		project = projectService.save(project);
		return ResponseEntity.status(HttpStatus.CREATED).body(project);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
		projectService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
		project = projectService.update(id, project);
		return ResponseEntity.status(HttpStatus.OK).body(project);
	}



}
