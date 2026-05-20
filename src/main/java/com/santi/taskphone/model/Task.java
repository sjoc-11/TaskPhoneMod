package com.santi.taskphone.model;

public class Task {
// Variables
    private int id;
    private String goal;
    private boolean isComplete;

// constructors
    public Task(int id, String goal) {
        this.id = id;
        this.goal = goal;
        this.isComplete = false;
    }
//getters - so basically since the variables are privates we need permission to get them and that's why we add those getters
    public String getGoal() {

        return this.goal;
    }

    public int getId() {

        return this.id;
    }

    public boolean getIsComplete() {
        return this.isComplete;
    }

    // setters - We need the booleans to change to true once the user complete his task and that's why we need to add this setter

    public void setIsComplete(boolean value){

        this.isComplete = value;
    }

}



