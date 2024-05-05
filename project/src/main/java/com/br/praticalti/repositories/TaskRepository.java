package com.br.praticalti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.praticalti.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
