package turtledev;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class CodeGenerator {
    public int linesGenerated;

    public CodeGenerator() {
        this.linesGenerated = 0;
    }

    public void generateLines(String path, int numLines, JLabel callback) {
        try {
            linesGenerated = getCurrentFileLength(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //begin writing
        try {
            FileWriter fw = new FileWriter(path);
            

            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getCurrentFileLength(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        int output = 0;
        while (reader.readLine() != null) output++;
        reader.close();
        return output;
    }
}
