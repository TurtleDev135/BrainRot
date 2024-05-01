package turtledev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CodeGenerator {
    public int linesGenerated;

    public CodeGenerator() {
        this.linesGenerated = 0;
    }

    public void start(String path) {
        try {
            linesGenerated = getCurrentFileLength(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Scanner scanner = new Scanner(new File(path));

            
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
