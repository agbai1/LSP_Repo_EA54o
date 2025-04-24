package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Manages a collection of tasks with operations to add, retrieve, update, and print them.
 */
public class TaskManager {
    private Map<String, Task> taskMap = new HashMap<>();

    /**
     * Adds a new task to the system.
     * @param name the name of the task
     * @param priority the task priority
     * @param status the initial task status
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (taskMap.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        taskMap.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     * @param name the task name
     * @return the Task object
     * @throws TaskNotFoundException if the task does not exist
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task task = taskMap.get(name);
        if (task == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return task;
    }

    /**
     * Updates the status of a task by name.
     * @param name the task name
     * @param newStatus the new status ("TODO", "IN_PROGRESS", or "DONE")
     * @throws TaskNotFoundException if the task does not exist
     */
    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(newStatus);
    }

    /**
     * Prints all tasks grouped by their current status.
     */
    public void printTasksGroupedByStatus() {
        Map<String, List<Task>> grouped = new TreeMap<>();
        for (Task task : taskMap.values()) {
            grouped.computeIfAbsent(task.getStatus(), k -> new ArrayList<>()).add(task);
        }

        System.out.println("Tasks grouped by status:");
        for (String status : List.of("TODO", "IN_PROGRESS", "DONE")) {
            System.out.println(status + ":");
            List<Task> tasks = grouped.getOrDefault(status, new ArrayList<>());
            for (Task t : tasks) {
                System.out.println("  " + t);
            }
        }
    }
}
