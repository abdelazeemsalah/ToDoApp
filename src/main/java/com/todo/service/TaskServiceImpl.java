package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.model.Task;
import com.todo.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);

	}

	@Override
	public void deleteTask(Integer taskId) {
		// TODO Auto-generated method stub
		taskRepository.delete(taskId);

	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return (List<Task>) taskRepository.findAll();
	}
}
