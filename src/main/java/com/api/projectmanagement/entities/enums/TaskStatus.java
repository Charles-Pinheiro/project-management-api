package com.api.projectmanagement.entities.enums;

public enum TaskStatus {

	PLANNING(1),
	WAITING(2),
	DOING(3),
	DONE(4),
	APPROVED(5),
	DENIED(6),
	REVIEW(7),
	FINISHED(8);

	private int code;

	private TaskStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TaskStatus codeOf(int code) {
		for (TaskStatus status : TaskStatus.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid TaskStatus code!");
	}
}
