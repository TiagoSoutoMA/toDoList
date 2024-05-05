package com.br.praticalti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.br.praticalti.entities.Task;
import com.br.praticalti.exception.TaskNotFoundException;
import com.br.praticalti.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public Task insert(Task newTask) {
		Task result = taskRepository.save(newTask);
		return result;
	}
	
	public Task findById(Long id) {
		Task existingTask = taskRepository.findById(id).orElse(null);
		if (existingTask != null) { 
            return existingTask;
        } else {
            throw new TaskNotFoundException("Tarefa não encontrada com o ID: " + id);
        }
	}
	
	public List<Task> findAll() {
		List<Task> result = taskRepository.findAll();
		return result;
	}
	
    public Task update(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id).orElse(null);

        if (existingTask != null) {
            updatedTask.setId(id); 
            return taskRepository.save(updatedTask);
        } else {
            throw new TaskNotFoundException("Tarefa não encontrada com o ID: " + id);
        }
    }
	
	public void delete(@PathVariable Long id) {
		Task existingTask = taskRepository.findById(id).orElse(null);
		
		if (existingTask != null) {
			taskRepository.deleteById(id);
        } else {
            throw new TaskNotFoundException("Tarefa não encontrada com o ID: " + id);
        }
	}
}
