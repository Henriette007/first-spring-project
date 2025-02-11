package com.hetta.firstspringproject.todolist;

import com.hetta.firstspringproject.entities.ToDoListTaskEntity;
import com.hetta.firstspringproject.repos.ToDoListRepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToDoListManager {
    ArrayList<String> list;
    private final ToDoListRepo toDoListRepo;

    public ToDoListManager(ToDoListRepo toDoListRepo){
        this.toDoListRepo = toDoListRepo;
        this.list = new ArrayList<>();
    }

    public void add(String task){
        list.add(task.replaceAll("\"", ""));
        ToDoListTaskEntity myTask = new ToDoListTaskEntity(task.replaceAll("\"", ""),false);
        toDoListRepo.save(myTask);
    }

    public void reset(){
        toDoListRepo.deleteAll();
    }

    public void delete(long index){
        toDoListRepo.deleteById(index);
    }

    public List<ToDoListTaskEntity> getList() {
        return toDoListRepo.findAll();
    }
}
