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
                        indent() + "inp = int(input(\"Enter a number: \"))\n"
                );
                linesGenerated=2;
            }
            for (int i = 0; i < numLines; i++) {
                fw.write(indent()+"if inp == " + numbersAccounted + ":\n");
                numbersAccounted++;
                fw.write(indent()+indent()+"print(\"Even\")\n");
                fw.write(indent()+"if inp == " + numbersAccounted + ":\n");
                numbersAccounted++;
                fw.write(indent()+indent()+"print(\"Odd\")\n");
                //after each line is written
                linesGenerated+=4;
                callback.setText("Lines Generated: " + this.linesGenerated);
            }
            fw.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateCurrentFileMeta(String path) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            return;
        }
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();;
        while (line != null) {
            linesGenerated++;
            if (line.substring(4,6) == "if") {
                System.out.println(line.substring(4,6));
            }
            line = reader.readLine();
        }
        reader.close();
    }
}
