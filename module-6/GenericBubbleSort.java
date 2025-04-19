// Lea Trueworthy
// April 16, 2025
// M6 Programming assignment
// Description: Write a program with two generic bubbleSort methods: one that uses Comparable and one that uses a Comparator to sort an array.

import java.util.Comparator;

public class GenericBubbleSort {

    public static void main(String[] args) {
        // Example using Comparable
        Integer[] numbers = { 5, 3, -4, 9, 0, 1, 12, 7, 60, 8 };
        System.out.println("Original (Comparable):");
        printArray(numbers);

        bubbleSort(numbers);
        System.out.println("Sorted (Comparable):");
        printArray(numbers);

        // Example using Comparator
        String[] names = { "Moo", "Quack", "Chirp", "Buzz", "Hoot" };
        System.out.println("Original (Comparator):");
        printArray(names);

        bubbleSort(names, Comparator.naturalOrder());
        System.out.println("Sorted (Comparator - naturalOrder):");
        printArray(names);
    }

    // Bubble Sort using comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; ++i) {
            for (int j = 0; j < list.length - 1 - i; ++j) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Bubble Sort using comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; ++i) {
            for (int j = 0; j < list.length - 1 - i; ++j) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // utility method to print arrays
    public static <T> void printArray(T[] array) {
        System.out.print("array = {");
        for (T element : array) {
            System.out.print(" [" + element + "] ");
        }
        System.out.println("};\n");
    }
}
