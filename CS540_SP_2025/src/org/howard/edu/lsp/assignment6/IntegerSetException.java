package org.howard.edu.lsp.assignment6;

/**
 * Custom exception for IntegerSet operations on empty sets
 */
public class IntegerSetException extends Exception {
    public IntegerSetException(String message) {
        super(message);
    }
}
