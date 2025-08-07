# Supermarket

---
+ I want to add tasks to my todo list.
+ I want to see all the tasks in my todo list.
+ I want to change the status of a task between incomplete and complete.
+ I want to be able to get only the complete tasks.
+ I want to be able to get only the incomplete tasks.
+ I want to search for a task and receive a message that says it wasn't found if it doesn't exist.
+ I want to remove tasks from my list.
+ I want to see all the tasks in my list ordered alphabetically in ascending order.
+ I want to see all the tasks in my list ordered alphabetically in descending order.
---
| Classes  | Members        | Methods                                 | Scenario                 | Output                               | 
|----------|----------------|-----------------------------------------|--------------------------|--------------------------------------|
| TodoList |                | addTasks(Task task)                     | valid parameter          | task added to list of tasks          |
|          |                |                                         | invalid parameter (null) | no task added                        |
|          |                | seeAllTasks()                           |                          | return all tasks                     |
|          |                | changeStatus(Task task, boolean status) | valid parameter          | status changed on given task         |
|          |                |                                         | invalid parameter (null) | no change made                       |
|          |                | getTaskBasedOnStatus(String status)     | status = complete        | return all complete tasks            |
|          |                |                                         | status = incomplete      | return all incomplete tasks          |
|          |                | searchForTask(Task task)                | task in map              | return that task was found           |
|          |                |                                         | task not in map          | return that task was not found       |
|          |                | removeTask(Task task)                   | if task in map           | remove task from map                 |
|          |                |                                         | if not in map            | nothing happens                      |
|          |                | orderAllTaskAscOrder()                  |                          | returns all task in ascending order  |
|          |                | orderAllTasksDescOrder()                |                          | returns all task in descending order |
| Tasks    | boolean status |                                         |                          |                                      |
|          | String name    |                                         |                          |                                      |
|          |                | changeStatus()                          | status is true           | member status becomes true           |
|          |                | changeStatus()                          | status is false          | member status becomes false          |




 




