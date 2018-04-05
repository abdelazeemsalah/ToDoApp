package com.todo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the status database table.
 */
@Entity
@Table(name = "status")
@NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STATUS_ID")
	private int statusId;

	@Column(name = "STATUS_NAME")
	private String statusName;

	// bi-directional many-to-one association to Task
	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Task> tasks;

	public Status() {
	}

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setStatus(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setStatus(null);

		return task;
	}

}