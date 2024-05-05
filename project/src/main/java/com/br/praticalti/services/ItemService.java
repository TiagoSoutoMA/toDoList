package com.br.praticalti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.praticalti.entities.Item;
import com.br.praticalti.entities.Task;
import com.br.praticalti.exception.TaskNotFoundException;
import com.br.praticalti.repositories.ItemRepository;
import com.br.praticalti.repositories.TaskRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private TaskRepository taskRepository;
	
	public Item insert(Long taskId, Item newItem) {
        Task task = taskRepository.findById(taskId).orElse(null);

        if (task != null) {
        	System.out.println("Tarefa encontrada: " + task);
            newItem.setTask(task);
            return itemRepository.save(newItem);
        } else {
            throw new TaskNotFoundException("Tarefa não encontrada com o ID: " + taskId);
        }
    }

    public List<Item> findAll(Long taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task != null) {
            return task.getItems();
        } else {
            throw new TaskNotFoundException("Tarefa não encontrada com o ID: " + taskId);
        }
    } 
}
