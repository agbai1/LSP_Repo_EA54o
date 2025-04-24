package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when a task cannot be found in the TaskManager.
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
