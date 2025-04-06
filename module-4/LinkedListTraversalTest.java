// Lea Trueworthy
// March 31, 2025
// M4 Programming assignment
// Description: Write a program that measures how fast a LinkedList can be traversed using an iterator compared to get(index).

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class LinkedListTraversalTest {
    public static void main(String[] args) {
        testLinkedListPerformance(50000);
        testLinkedListPerformance(500000);
    }

    private static void testLinkedListPerformance(int size) {
        List<Integer> list = new LinkedList<>();

        // Populate with 'size' elements
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Measure time using iterator
        long startTime = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.nanoTime();
        long iteratorTime = endTime - startTime;

        // Measure time using get(index)
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        long getIndexTime = endTime - startTime;

        // Print results
        System.out.println("For " + size + " elements:");
        System.out.println("Iterator traversal time: " + iteratorTime + " ns");
        System.out.println("get(index) traversal time: " + getIndexTime + " ns");
        System.out.println();
    }
}
