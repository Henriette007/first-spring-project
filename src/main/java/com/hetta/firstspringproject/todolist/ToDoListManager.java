package com.hetta.firstspringproject.todolist;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ToDoListManager {
    ArrayList<String> list;

    public ToDoListManager(){
        this.list = new ArrayList<>();
    }

    public void add(String s){
        list.add(s);
    }

    public void reset(){
        list = new ArrayList<>();
    }

    public void delete(int i){
        list.remove(i);
    }

    public ArrayList<String> getList() {
        return list;
    }
}
