/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaassignmentstringoperations;

/**
 *
 * author 230500226 (Shahied Rustin)
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;

public class StringOperation {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        
        // Tokenize the sentence
        String[] words = sentence.split("\\s+");
        
        // Regular expression to identify words starting with a vowel
        Pattern pattern = Pattern.compile("^[aeiouAEIOU].*");
        
        // StringBuilder to collect the output for the file
        StringBuilder output = new StringBuilder();
        output.append("--------- batch ---------\n");
        
        int count = 1;
        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                // Capitalize the first letter
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1);
                // Print to console
                System.out.println(count + ". " + capitalizedWord);
                // Append to output
                output.append(count).append(". ").append(capitalizedWord).append("\n");
                count++;
            }
        }
        
        // Write to file
        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write(output.toString());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
