package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * IntegerSet class models a collection of unique integers, 
 * ensuring no duplicates are present. It includes functionality 
 * for standard set operations such as union, intersection, 
 *  difference, and complement
 *  
 *  Implementation of the javadoc was provided by ChatGPT (OpenAI) for academic support.
 */
public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor for an empty set
     */
    public IntegerSet() {}

    /**
     * Constructor that initializes the set with a list of integers
     * @param set List of integers to initialize the set with
     */
    public IntegerSet(ArrayList<Integer> set) {
        for (int item : set) {
            if (!this.set.contains(item)) {
                this.set.add(item);
            }
        }
    }

    /**
     * Clears the internal list of the set
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set
     * @return length of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if this set is equal to another object
     * @param o the object to compare to
     * @return true if sets contain the same elements
     */
    public boolean equals(Object o) {
        if (o instanceof IntegerSet) {
            IntegerSet other = (IntegerSet) o;
            return set.containsAll(other.set) && other.set.containsAll(set);
        }
        return false;
    }

    /**
     * Checks if the set contains a specific value
     * @param value the value to check for
     * @return true if value is in the set
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set
     * @return largest integer
     * @throws IntegerSetException if the set is empty
     */
    public int largest() throws IntegerSetException {
        if (set.isEmpty()) throw new IntegerSetException("Set is empty");
        return Collections.max(set);
    }

    /**
     * Returns the smallest value in the set
     * @return smallest integer
     * @throws IntegerSetException if the set is empty
     */
    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) throw new IntegerSetException("Set is empty");
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if not already present
     * @param item the item to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists
     * @param item the item to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs union with another set
     * @param intSetb the other set
     */
    public void union(IntegerSet intSetb) {
        for (int item : intSetb.set) {
            if (!set.contains(item)) {
                set.add(item);
            }
        }
    }

    /**
     * Performs intersection with another set
     * @param intSetb the other set
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Performs set difference
     * @param intSetb the other set
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Performs set complement
     * @param intSetb the other set
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complement = new ArrayList<Integer>();
        for (int item : intSetb.set) {
            if (!set.contains(item)) {
                complement.add(item);
            }
        }
        set = complement;
    }

    /**
     * Checks if the set is empty
     * @return true if set is empty
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set
     * @return string representation
     */
    public String toString() {
        return set.toString();
    }
}

/**
 * Exception thrown when an operation is performed on an empty IntegerSet
 */
class IntegerSetException extends Exception {
    public IntegerSetException(String message) {
        super(message);
    }
}
