package com.br.praticalti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.praticalti.entities.Task;
import com.br.praticalti.services.TaskService;

@RestController
@RequestMapping(value="/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public Task insert(@RequestBody Task newTask) {
		return taskService.insert(newTask);
	}
	
	@GetMapping(value="/{id}")
	public Task findById(@PathVariable Long id) {
		return taskService.findById(id);
	}
	
	@GetMapping
	public List<Task> findAll() {
		return taskService.findAll();
	}
	
	@PutMapping(value="/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskService.update(id, updatedTask);
    }
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable Long id) {
		taskService.delete(id);
	}
}
