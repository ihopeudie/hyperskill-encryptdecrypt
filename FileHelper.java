package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHelper {
    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
            return sb.toString();
        } catch (Exception e) {
            new OutputManager().printConsole("Error! Can not read file " + fileName);
        }
        return sb.toString();
    }

    public static void writeFile(String data, String outputFileName) {
        try (FileWriter writer = new FileWriter(outputFileName)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
