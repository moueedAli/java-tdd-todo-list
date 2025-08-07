package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

class TodoListTest {
    @Test
    public void testChangeOfStatus() {
        Task task1 = new Task("Clean");

        task1.changeStatus(false);
        Assertions.assertEquals(false, task1.status);
        task1.changeStatus(true);
        Assertions.assertEquals(true, task1.status);
    }

    @Test
    public void testIfTaskIsAddedSuccessfully() {
        Task task1 = new Task("Wash");
        TodoList lst = new TodoList();

        Task task2 = new Task("Clean");
        lst.addTask(task2);

        Assertions.assertEquals(true, lst.addTask(task1));
        Assertions.assertEquals(false, lst.addTask(task1));
        Assertions.assertEquals(false, lst.addTask(task2));
    }

    @Test
    public void testToSeeAllTasksInList() {
        Task task1 = new Task("Clean");
        Task task2 = new Task("Wash");

        TodoList lst = new TodoList();
        lst.addTask(task1);
        lst.addTask(task2);

        ArrayList<Task> equalList = new ArrayList<>();
        equalList.add(task1);
        equalList.add(task2);

        Assertions.assertIterableEquals(equalList,lst.viewAllTasks());
    }

    @Test
    public void testChangeStatusOfTask() {
        Task task1 = new Task("Clean");
        Task task2 = new Task("Wash");

        TodoList lst = new TodoList();
        lst.addTask(task1);
        lst.addTask(task2);

        lst.changeStatusOfTasks(task1, true);
        lst.changeStatusOfTasks(task2, false);

        Assertions.assertEquals(true, lst.taskList.getFirst().status);
        Assertions.assertEquals(false, lst.taskList.getLast().status);
    }

    @Test
    public void testRetrieveAllIncompleteTasks() {
        Task task1 = new Task("Clean");
        Task task2 = new Task("Wash");

        TodoList lst = new TodoList();
        lst.addTask(task1);
        lst.addTask(task2);

        lst.changeStatusOfTasks(task1, false);
        lst.changeStatusOfTasks(task2, true);

        Assertions.assertNotEquals(lst.viewAllTasks(), lst.getIncompleteTasks());
    }

    @Test
    public void testRetrieveAllCompleteTasks() {
        Task task1 = new Task("Clean");
        Task task2 = new Task("Wash");

        TodoList lst = new TodoList();
        lst.addTask(task1);
        lst.addTask(task2);

        lst.changeStatusOfTasks(task1, true);
        lst.changeStatusOfTasks(task2, true);

        Assertions.assertEquals(lst.viewAllTasks(), lst.getCompleteTask());
    }

    @Test
    public void testIfTaskExists() {
        Task task1 = new Task("Clean");
        Task task2 = new Task("Wash");
        TodoList lst = new TodoList();
        lst.addTask(task1);
        String exists = "Task exists";
        String notExists = "Task does not exists";

        Assertions.assertEquals(exists, lst.checkIfTaskExists(task1));
        Assertions.assertNotEquals(notExists, lst.checkIfTaskExists(task2));
    }

    @Test
    public void testRemoveTaskFromList() {
        Task task1 = new Task("Clean");
        Task task2 = new Task("Wash");
        TodoList lst = new TodoList();
        lst.addTask(task1);
        lst.addTask(task2);

        ArrayList<Task> equalList = new ArrayList<>();
        equalList.add(task1);
        equalList.add(task2);

        Assertions.assertEquals(equalList, lst.viewAllTasks());

        lst.removeTask(task2);
        Assertions.assertNotEquals(equalList, lst.viewAllTasks());
    }

    @Test
    public void testAscSorted() {
        Task task1 = new Task("aa");
        Task task2 = new Task ("ab");

        TodoList lst = new TodoList();
        lst.addTask(task2);
        lst.addTask(task1);
        List<Task> sorted = lst.ascOrder();

        Assertions.assertEquals(task2, sorted.getLast());
        Assertions.assertEquals(task1, sorted.getFirst());
        Assertions.assertNotEquals(task2, sorted.getFirst());
        Assertions.assertNotEquals(task1, sorted.getLast());

    }

    @Test
    public void testDescSorted() {
        Task task1 = new Task("aa");
        Task task2 = new Task ("ab");

        TodoList lst = new TodoList();
        lst.addTask(task1);
        lst.addTask(task2);
        List<Task> sorted = lst.descOrder();

        Assertions.assertEquals(task2, sorted.getFirst());
        Assertions.assertNotEquals(task2, sorted.getLast());
        Assertions.assertEquals(task1, sorted.getLast());
        Assertions.assertNotEquals(task1, sorted.getFirst());
    }
}
