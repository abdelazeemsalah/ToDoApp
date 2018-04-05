package com.todo.service;

import java.util.List;

import com.todo.model.Task;

public interface TaskService {

	public Task saveTask(Task task);

	public void deleteTask(Integer taskId);

	public List<Task> getAllTasks();
}
