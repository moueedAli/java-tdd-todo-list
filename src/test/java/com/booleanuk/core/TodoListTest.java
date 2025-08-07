package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
