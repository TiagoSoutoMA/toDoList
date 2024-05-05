package com.br.praticalti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.praticalti.entities.Item;
import com.br.praticalti.services.ItemService;

@RestController
@RequestMapping(value="/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping(value="/{taskId}")
	public Item insert(@PathVariable Long taskId, @RequestBody Item newItem) {
        return itemService.insert(taskId, newItem);
    }
	
	@GetMapping(value="/{taskId}")
    public List<Item> findAll(@PathVariable Long taskId) {
        return itemService.findAll(taskId);
    } 
}
