package com.bg.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bg.rental.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
