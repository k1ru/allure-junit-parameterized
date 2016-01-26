package ru.sbertech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public static List<String[]> listFromFile = new ArrayList<String[]>();

    public List<String[]> parseFile(File file) {
        System.out.println(">> readFile: " + file.getAbsolutePath() + "\n");

        try {
            BufferedReader reader = new BufferedReader(new FileReader("dataFile.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                listFromFile.add(line.split(";"));
            }
        } catch (IOException e) {
            System.err.format(">> IOException: %s%n", e);
        }

        return listFromFile;
    }
}