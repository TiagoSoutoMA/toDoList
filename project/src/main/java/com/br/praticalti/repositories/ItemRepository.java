package com.br.praticalti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.praticalti.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
