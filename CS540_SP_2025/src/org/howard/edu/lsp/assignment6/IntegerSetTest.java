package org.howard.edu.lsp.assignment6;

import org.howard.edu.lsp.assignment6.IntegerSet;
import org.howard.edu.lsp.assignment6.IntegerSetException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test toString() format")
    public void testToString() {
        set1.add(1);
        set1.add(2);
        assertEquals("[1, 2]", set1.toString());
    }
    
    @Test
    @DisplayName("Test add() avoids duplicates")
    public void testAdd() {
        set1.add(1);
        set1.add(2);
        set1.add(2);
        assertEquals(2, set1.length());
    }

    @Test
    @DisplayName("Test case for clear()")
    public void testClear() {
        set1.add(10);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    @Test
    @DisplayName("Test case for length()")
    public void testLength() {
        set1.add(3);
        set1.add(5);
        assertEquals(2, set1.length());
    }

    @Test
    @DisplayName("Test case for equals()")
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("Test case for contains()")
    public void testContains() {
        set1.add(4);
        assertTrue(set1.contains(4));
        assertFalse(set1.contains(10));
    }

    @Test
    @DisplayName("Test case for largest()")
    public void testLargest() throws IntegerSetException {
        set1.add(5);
        set1.add(10);
        set1.add(3);
        assertEquals(10, set1.largest());
    }

    @Test
    @DisplayName("Test exception for largest() on empty set")
    public void testLargestException() {
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set1.largest();
        });
        assertEquals("Set is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test case for smallest()")
    public void testSmallest() throws IntegerSetException {
        set1.add(5);
        set1.add(10);
        set1.add(3);
        assertEquals(3, set1.smallest());
    }

    @Test
    @DisplayName("Test exception for smallest() on empty set")
    public void testSmallestException() {
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set1.smallest();
        });
        assertEquals("Set is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test case for remove()")
    public void testRemove() {
        set1.add(7);
        set1.add(8);
        set1.remove(7);
        assertFalse(set1.contains(7));
    }

    @Test
    @DisplayName("Test case for union()")
    public void testUnion() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        assertTrue(set1.contains(1) && set1.contains(2) && set1.contains(3));
    }

    @Test
    @DisplayName("Test case for intersect()")
    public void testIntersect() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.intersect(set2);
        assertEquals("[2]", set1.toString());
    }

    @Test
    @DisplayName("Test case for diff()")
    public void testDiff() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.diff(set2);
        assertEquals("[1]", set1.toString());
    }

    @Test
    @DisplayName("Test case for complement()")
    public void testComplement() {
        set1.add(1);
        set1.add(2);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set1.complement(set2);
        assertEquals("[3]", set1.toString());
    }

    @Test
    @DisplayName("Test case for isEmpty()")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty());
        set1.add(10);
        assertFalse(set1.isEmpty());
    }
}
