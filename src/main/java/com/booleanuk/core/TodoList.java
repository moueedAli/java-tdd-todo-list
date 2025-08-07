package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoList {
    List<Task> taskList = new ArrayList<>();

    public boolean addTask(Task tsk) {
       if (taskList.contains(tsk)) { return false;}
       else {taskList.add(tsk); return true;}
    }


    public List<Task> viewAllTasks() {
        return taskList;
    }

    public boolean changeStatusOfTasks(Task tsk, boolean newStatus) {
        for (Task t: taskList) {
            if (t == tsk && t.status != newStatus) {
                t.status = newStatus;
                return true;
            }
        }
        return newStatus;
    }

    public ArrayList<Task> getIncompleteTasks() {
        ArrayList<Task> incompleteTasks = new ArrayList<>();
        for (Task t : taskList) {
            if (t.status == false) {
                incompleteTasks.add(t);
            }
        }

        return incompleteTasks;
    }

    public ArrayList<Task> getCompleteTask() {
        ArrayList<Task> incompleteTasks = new ArrayList<>();
        for (Task t : taskList) {
            if (t.status == true) {
                incompleteTasks.add(t);
            }
        }

        return incompleteTasks;
    }

    public String checkIfTaskExists(Task tsk) {
        if (!taskList.contains(tsk)) {return "Task does not exist";}
        return "Task exists";
    }

    public boolean removeTask(Task tsk) {
        if (taskList.contains(tsk)) {
            taskList.remove(tsk);
            return true;
        }
        return false;
    }

    public List<Task> ascOrder() {
        List<Task> orderedList = new ArrayList<>(List.copyOf(this.taskList));

        orderedList.sort((a, b) -> {return a.name.compareTo(b.name);});
        return  orderedList;
    }

    public List<Task> descOrder() {
        List<Task> orderedList = new ArrayList<>(List.copyOf(this.taskList));

        orderedList.sort((a, b) -> {return b.name.compareTo(a.name);});
        return  orderedList;
    }

}
