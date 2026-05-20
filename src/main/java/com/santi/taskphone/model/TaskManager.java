package com.santi.taskphone.model;

import java.util.ArrayList;
// import java array list so we can have an unlimited list

public class TaskManager {

    // Variable - the list that stores all tasks
    private ArrayList<Task> tasks;

    // Constructor - creates an empty list when TaskManager is created
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    // Method - adds a new task to the list
    public void addTask(String goal) {
        Task newTask = new Task(tasks.size() + 1, goal);
        tasks.add(newTask);
    }

    // Method - removes a task by its id
    public void removeTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                break;
            }
        }
    }

    // Method - switch the boolean to true once the task is complete
    public void completeTask(int id) {
        for (int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).getId() == id) {
                tasks.get(i).setIsComplete(true);
                break;
            }
        }
    }

    // Getter - returns the list so the screen can show it
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }
}