package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        Options options = new Options(args);
        OutputManager outputManager = new OutputManager();
        if (options.haveErrors()) {
            outputManager.printConsole("Error! CLI args are incorrect");
            System.exit(1);
        }
        Encrypter encrypter = "unicode".equals(options.getAlg()) ? new UnicodeEncrypter() : new ShiftEncrypter();
        String data = encrypter.encrypt(options.getData(), options.getKey());
        if (!options.getOutputFileName().isBlank()) {
            FileHelper.writeFile(data, options.getOutputFileName());
        } else {
            outputManager.printConsole(data);
        }
    }

}
