package com.booleanuk.core;

public class Task {

    String name;
    boolean status;

    public Task (String name) {
        this.name = name;
        this.status = false; // every new tasks default status is false/incomplete
    }

    void changeStatus(boolean status) {

    }
}
