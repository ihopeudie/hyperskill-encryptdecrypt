package encryptdecrypt;

import java.util.Arrays;
import java.util.List;

public class ShiftEncrypter extends Encrypter {

    public static final List<String> ALPHABET = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));
    public static final List<String> ALPHABET_BIG = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));

    @Override
    public String encrypt(String msg, int offset) {
        StringBuilder sb = new StringBuilder();
        for (String letter : msg.split("")) {
            List<String> listToCheck = null;
            if (ALPHABET.contains(letter)) {
                listToCheck = ALPHABET;
            }
            if (ALPHABET_BIG.contains(letter)) {
                listToCheck = ALPHABET_BIG;
            }
            if (listToCheck == null) {
                sb.append(letter);
                continue;
            }
            int index = listToCheck.indexOf(letter);
            int nextIndex = index + offset;
            while (nextIndex > listToCheck.size()) {
                nextIndex -= listToCheck.size();
            }
            while (nextIndex < 0) {
                nextIndex += listToCheck.size();
            }
            sb.append(listToCheck.get(nextIndex));
        }
        return sb.toString();
    }
}
