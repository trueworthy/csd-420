// Lea Trueworthy
// March 26, 2025
// M2 Programming assignment
// Description: Write a program that generates random integers and doubles, stores them in arrays, and writes them to a file named [yourname] datafile.dat. If the file doesn't exist, it's created; otherwise, new data is appended.

import java.io.*;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        // Create Random object to generate random numbers
        Random random = new Random();

        // Store 5 random integers and 5 random doubles
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        // Generate 5 random integers and 5 random doubles
        for (int i = 0; i < 5; i++) {
            intArray[i] = random.nextInt(100); // Integer between 0 and 99
            doubleArray[i] = random.nextDouble() * 100; // Double between 0 and 100
        }

        // File name: Mine kept appearing under C:\Users\Lea
        String fileName = "trueworthy_datafile.dat";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Write data to file
            writer.write("Random Integers:\n");
            for (int num : intArray) {
                writer.write(num + " ");
            }
            writer.write("\n");

            writer.write("Random Doubles:\n");
            for (double num : doubleArray) {
                writer.write(num + " ");
            }
            writer.write("\n");

            System.out.println("Data has been added to the file!");

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
