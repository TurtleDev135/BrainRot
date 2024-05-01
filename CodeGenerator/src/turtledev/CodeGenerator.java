package turtledev;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class CodeGenerator {
    public int linesGenerated;
    public int numbersAccounted;

    public CodeGenerator() {
        this.linesGenerated = 0;
        this.numbersAccounted = 0;
    }

    private String indent() {
        String output = "";
        for (int i = 0; i < 4; i++) {
            output += " ";
        }
        return output;
    }

    public void generateLines(String path, int numLines, JLabel callback) {
        try {
            updateCurrentFileMeta(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //begin writing
        try {
            FileWriter fw = new FileWriter(path);
            if (linesGenerated == 0) {
                fw.write(
                        "while True: \n" +
                        indent() + "input = str(input(\"Enter a number: \"))"
                );
            }
            for (int i = 0; i < numLines; i++) {
                fw.write(indent()+"if input == ");
                //after each line is written
                linesGenerated++;
                callback.setText("Lines Generated: " + this.linesGenerated);
            }

            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateCurrentFileMeta(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = "";
        while (line != null) {
            line = reader.readLine();
            linesGenerated++;
            if (line.substring(4,6) == "if") {
                System.out.println(line.substring(4,6));
            }
        }
        reader.close();
    }
}
