package org.howard.edu.lsp.assignment5;

/**
 * Driver class for testing the IntegerSet implementation.
 * Demonstrates various set operations such as add, remove, union,
 * intersection, difference, complement, and more.
 */
public class Driver {
	/**
	 * Main method to execute test cases for IntegerSet class.
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		try {
			IntegerSet set1 = new IntegerSet();
			set1.add(1);
			set1.add(2);
			set1.add(3);
			System.out.println("Initial Set1: " + set1);

			IntegerSet set2 = new IntegerSet();
			set2.add(3);
			set2.add(4);
			set2.add(5);
			System.out.println("Initial Set2: " + set2);

			System.out.println("\n--- Testing add() (no duplicates) ---");
			set1.add(3);
			System.out.println("Set1 after adding 3 again: " + set1);

			System.out.println("\n--- Testing contains() ---");
			System.out.println("Set1 contains 2? " + set1.contains(2));
			System.out.println("Set1 contains 7? " + set1.contains(7));

			System.out.println("\n--- Testing smallest() and largest() ---");
			System.out.println("Smallest in Set1: " + set1.smallest());
			System.out.println("Largest in Set1: " + set1.largest());

			System.out.println("\n--- Testing union() ---");
			System.out.println("Set1 before union: " + set1);
			System.out.println("Set2: " + set2);
			set1.union(set2);
			System.out.println("Set1 after union with Set2: " + set1);

			System.out.println("\n--- Testing intersect() ---");
			set1 = new IntegerSet();
			set1.add(1); set1.add(2); set1.add(3);
			System.out.println("Reset Set1: " + set1);
			set1.intersect(set2);
			System.out.println("Set1 after intersect with Set2: " + set1);

			System.out.println("\n--- Testing diff() ---");
			set1 = new IntegerSet();
			set1.add(1); set1.add(2); set1.add(3);
			System.out.println("Reset Set1: " + set1);
			set1.diff(set2);
			System.out.println("Set1 after diff with Set2: " + set1);

			System.out.println("\n--- Testing complement() ---");
			set1 = new IntegerSet();
			set1.add(1); set1.add(2); set1.add(3);
			System.out.println("Reset Set1: " + set1);
			set1.complement(set2);
			System.out.println("Set1 after complement with Set2: " + set1);

			System.out.println("\n--- Testing equals() ---");
			IntegerSet set3 = new IntegerSet();
			set3.add(5); set3.add(4); set3.add(3);
			System.out.println("Set2: " + set2);
			System.out.println("Set3: " + set3);
			System.out.println("Set2 equals Set3? " + set2.equals(set3));

			System.out.println("\n--- Testing clear() and isEmpty() ---");
			set3.clear();
			System.out.println("Set3 after clear: " + set3);
			System.out.println("Set3 is empty? " + set3.isEmpty());

			System.out.println("\n--- Testing remove() ---");
			set2.remove(4);
			System.out.println("Set2 after removing 4: " + set2);

			System.out.println("\n--- Testing smallest/largest exception ---");
			set3 = new IntegerSet();
			System.out.println("Trying smallest() on empty set...");
			try {
				set3.smallest();
			} catch (IntegerSetException e) {
				System.out.println("Caught exception: " + e.getMessage());
			}
			System.out.println("Trying largest() on empty set...");
			try {
				set3.largest();
			} catch (IntegerSetException e) {
				System.out.println("Caught exception: " + e.getMessage());
			}
		} catch (IntegerSetException e) {
			System.out.println("Unexpected exception: " + e.getMessage());
		}
	}
}
