package com.hetta.firstspringproject.todolist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoListDemoSetUpController {
    private ToDoListManager toDoListManager;

    public ToDoListDemoSetUpController(ToDoListManager toDoListManager) {
        this.toDoListManager = toDoListManager;
    }

    @GetMapping("/setUpDemo")
    public Boolean setUpDemo(){
        toDoListManager.add("Go to the Gym");
        toDoListManager.add("Do the dishes");
        toDoListManager.add("Eat ice-cream");
        toDoListManager.add("Take a nap");
        return true;
    }

}
