package com.hetta.firstspringproject.todolist;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoListController {
    private ToDoListManager toDoListManager;

    public ToDoListController(ToDoListManager toDoListManager) {
        this.toDoListManager = toDoListManager;
    }

    @GetMapping("/get")
    public List<String> get(){
        return toDoListManager.getList();
    }

    @GetMapping("/add")
    public ResponseEntity<Boolean> add(@RequestParam String s){
        toDoListManager.add(s);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping("/reset")
    public ResponseEntity<Boolean> reset(){
        toDoListManager.reset();
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestParam int index){
        toDoListManager.delete(index);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }


}
