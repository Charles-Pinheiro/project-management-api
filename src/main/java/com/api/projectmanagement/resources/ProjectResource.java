package com.api.projectmanagement.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
