// Lea Trueworthy
// March 31, 2025
// M3 Programming assignment
// Description: Write a test program that removes duplicates from an ArrayList of 50 random numbers between 1 and 20 and should return a new list with only unique values.

import java.util.ArrayList;
import java.util.Random;

public class NewArray {
    
    public static void main(String[] args) {
        // Generate random values between 1 and 20
        ArrayList<Integer> originalList = generateRandomList(50, 1, 20);
        
        // Print original list
        System.out.println("Original List: " + originalList);
        
        // Remove duplicates
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);
        
        System.out.println("List without duplicates: " + uniqueList);
    }
    
    // Generate random integers between min and max
    public static ArrayList<Integer> generateRandomList(int size, int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < size; i++) {
            int value = random.nextInt(max - min + 1) + min; // Random value between min and max
            list.add(value);
        }
        
        return list;
    }

    // Static method to remove duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> uniqueList = new ArrayList<>();
        
        for (E element : list) {
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }
        
        return uniqueList;
    }
}
