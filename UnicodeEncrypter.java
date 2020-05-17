package encryptdecrypt;

public class UnicodeEncrypter extends Encrypter {
    @Override
    public String encrypt(String msg, int offset) {
        StringBuilder sb = new StringBuilder();
        for (char c : msg.toCharArray()) {
            sb.append((char)(c+offset));
        }
        return sb.toString();
    }
}
