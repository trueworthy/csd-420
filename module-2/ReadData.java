// Lea Trueworthy
// March 26, 2025
// M2 Programming assignment
// Description: Write a program will read the data from the file and display the integers and doubles that were written in the first program.

import java.io.*;

public class ReadData {
    public static void main(String[] args) {
        // File name: Mine kept appearing under C:\Users\Lea
        String fileName = "trueworthy_datafile.dat";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Read each line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: The file you are looking for may not exist!");
            e.printStackTrace();
        }
    }
}
