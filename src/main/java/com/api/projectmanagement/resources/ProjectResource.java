package com.api.projectmanagement.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.projectmanagement.entities.Project;

@RestController
@RequestMapping(value = "/projects")
public class ProjectResource {

	@GetMapping
	public ResponseEntity<Project> findAll() {
		Project p = new Project(1L, "name", "description");
//		return ResponseEntity.ok().body(p);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
}
