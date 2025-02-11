package com.hetta.firstspringproject.repos;

import com.hetta.firstspringproject.entities.ToDoListTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepo extends JpaRepository<ToDoListTaskEntity, Long> {
}
