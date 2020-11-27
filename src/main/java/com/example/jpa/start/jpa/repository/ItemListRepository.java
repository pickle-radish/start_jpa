package com.example.jpa.start.jpa.repository;

import com.example.jpa.start.jpa.entity.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemListRepository extends JpaRepository<ItemList, Long> {
}
