package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.model.Status;
import com.todo.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<Status> allStatusList() {
		// TODO Auto-generated method stub
		return (List<Status>) statusRepository.findAll();
	}

}
