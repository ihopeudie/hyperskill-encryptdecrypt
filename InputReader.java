package encryptdecrypt;

import java.util.Scanner;

public class InputReader {

    public static String readString() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

    public static int readInt() {
        try (Scanner scanner = new Scanner(System.in)) {
            return Integer.parseInt(scanner.nextLine());
        }
    }
}
