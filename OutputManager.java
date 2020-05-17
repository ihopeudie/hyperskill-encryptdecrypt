package encryptdecrypt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class OutputManager {
    public void writeToFile(String fileName, String data) {
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            printConsole("Error! Can't write to file " + fileName);
            e.printStackTrace();
        }
    }

    public void printConsole(String s) {
        System.out.println(s);
    }
}
