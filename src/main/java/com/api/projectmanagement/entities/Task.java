package com.api.projectmanagement.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.api.projectmanagement.entities.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TASK")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant deadLine;

	private Integer status;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	public Task() {}

	public Task(Long id, String description, Instant deadLine, TaskStatus status, Project project) {
		super();
		this.id = id;
		this.description = description;
		this.deadLine = deadLine;
		setStatus(status);
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Instant deadLine) {
		this.deadLine = deadLine;
	}

	public TaskStatus getStatus() {
		return TaskStatus.valueOf(status);
	}

	public void setStatus(TaskStatus status) {
		if (status != null) {
			this.status = status.getCode();			
		}
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}

	
}
