package com.hetta.firstspringproject.todolist;

import com.hetta.firstspringproject.entities.ToDoListTaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoListController {
    @Autowired
    private ToDoListManager toDoListManager;


    public ToDoListController(ToDoListManager toDoListManager) {
        this.toDoListManager = toDoListManager;
    }

    @GetMapping("/list")
    public List<ToDoListTaskEntity> getTasks(){
        return toDoListManager.getList();
    }

    @PostMapping("/add")
    public List<ToDoListTaskEntity> addTask(@RequestBody String task) {
        toDoListManager.add(task);
        return toDoListManager.getList();
    }

    @PostMapping("/reset")
    public List<ToDoListTaskEntity> resetList() {
        toDoListManager.reset();
        return toDoListManager.getList();
    }

    @DeleteMapping("/delete/{index}")
    public List<ToDoListTaskEntity> deleteTask(@PathVariable int index) {
        toDoListManager.delete(index);
        return toDoListManager.getList();
    }


}
