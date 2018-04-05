package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.Status;
import com.todo.model.Task;
import com.todo.service.StatusService;
import com.todo.service.TaskService;

@RestController
@RequestMapping(value = "/Task")
public class TaskController {
	@Autowired
	private TaskService taskService;

	@Autowired
	private StatusService statusService;

	@RequestMapping("/")
	String home(ModelMap modal) {
		modal.addAttribute("title", "CRUD Example");
		return "index";
	}

	@RequestMapping(value = "/tasks", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Task> getTasks() {
		List<Task> list = taskService.getAllTasks();
		return list;
	}

	@RequestMapping(value = "/addTask", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Task addTask(@RequestBody Task task) {

		return taskService.saveTask(task);
	}

	@RequestMapping(value = "/task/{taskId}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void deleteTask(@PathVariable("taskId") Integer taskId) {

		System.out.println("(Service Side) Deleting task with Id: " + taskId);

		taskService.deleteTask(taskId);
	}

	@RequestMapping(value = "/statusList", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Status> getStatusList() {
		List<Status> list = statusService.allStatusList();
		return list;
	}

}
