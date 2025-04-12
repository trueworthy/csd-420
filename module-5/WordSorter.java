// Lea Trueworthy
// April 8, 2025
// M5 Programming assignment
// Description: Write a program that reads words from a file, removes duplicates, and sorts them in both ascending and descending orders.

import java.io.*;
import java.util.*;

public class WordSorter {
    public static void main(String[] args) {
        String fileName = "collection_of_words.txt";
        Set<String> words = new HashSet<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                words.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return;
        }

        // Ascending order
        List<String> ascList = new ArrayList<>(words);
        Collections.sort(ascList);
        System.out.println("Ascending order:");
        for (String word : ascList) {
            System.out.println(word);
        }

        // Descending order
        List<String> descList = new ArrayList<>(words);
        Collections.sort(descList, Collections.reverseOrder());
        System.out.println("\nDescending order:");
        for (String word : descList) {
            System.out.println(word);
        }
    }
}

