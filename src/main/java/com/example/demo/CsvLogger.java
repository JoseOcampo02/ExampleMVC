package com.example.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvLogger {

    // Change this to the Desktop location
    private static final String FILE_PATH = System.getProperty("user.home") + "/Desktop/numbers.csv";

    public static void logValidEntry(String number, String type) {
        writeToCsv(number, type);
    }

    public static void logError(String input, String error) {
        writeToCsv(input, error);
    }

    private static void writeToCsv(String input, String result) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(input + "," + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


