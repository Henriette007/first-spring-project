package com.hetta.firstspringproject.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public List<String> getTasks(){
        return toDoListManager.getList();
    }

    @PostMapping("/add")
    public List<String> addTask(@RequestBody String task) {
        toDoListManager.add(task);
        return toDoListManager.getList();
    }

    @PostMapping("/reset")
    public List<String> resetList() {
        toDoListManager.reset();
        return toDoListManager.getList();
    }

    @DeleteMapping("/delete/{index}")
    public List<String> deleteTask(@PathVariable int index) {
        toDoListManager.delete(index);
        return toDoListManager.getList();
    }


}
