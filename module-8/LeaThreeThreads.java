// Lea Trueworthy
// April 24, 2025
// M8 Programming assignment
// Description: Write a program that creates three separate threads to each generate 10,000 random characters: one for letters (a–z), one for digits (0–9), and one for symbols (!, @, #, $, %, &, *). 
// The program displays the output in a text area within a window.

import javax.swing.*;

public class LeaThreeThreads extends JFrame {
    private JTextArea textArea = new JTextArea();

    public LeaThreeThreads() {
        setTitle("Lea Three Threads Output");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JScrollPane(textArea));
        setVisible(true);

        // Start all three threads
        Thread lettersThread = new Thread(() -> outputRandomLetters());
        Thread numbersThread = new Thread(() -> outputRandomNumbers());
        Thread symbolsThread = new Thread(() -> outputRandomSymbols());

        lettersThread.start();
        numbersThread.start();
        symbolsThread.start();
    }

    private void outputRandomLetters() {
        for (int i = 0; i < 10000; i++) {
            char letter = (char) ('a' + (int)(Math.random() * 26)); // random a-z
            appendText(letter);
        }
    }

    private void outputRandomNumbers() {
        for (int i = 0; i < 10000; i++) {
            char number = (char) ('0' + (int)(Math.random() * 10)); // random 0-9
            appendText(number);
        }
    }

    private void outputRandomSymbols() {
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        for (int i = 0; i < 10000; i++) {
            char symbol = symbols[(int)(Math.random() * symbols.length)];
            appendText(symbol);
        }
    }

    private void appendText(char c) {
        SwingUtilities.invokeLater(() -> textArea.append(String.valueOf(c)));
    }

    public static void main(String[] args) {
        new LeaThreeThreads();
    }
}

