package encryptdecrypt;

public class Options {
    String mode;
    int key;
    String data;
    String outputFileName;
    String inputFileName;
    String alg;
    boolean haveErrors;

    public static final String ARG_MODE = "-mode";
    public static final String ARG_KEY = "-key";
    public static final String ARG_DATA = "-data";
    public static final String ARG_IN = "-in";
    public static final String ARG_OUT = "-out";
    public static final String ARG_ALG = "-alg";

    public Options(String[] args) {
        this.mode = "enc";
        this.key = 0;
        this.data = "";
        this.outputFileName = "";
        this.inputFileName = "";
        this.haveErrors = false;
        this.alg = "shift";

        if (args.length % 2 != 0) {
            this.haveErrors = true;
            return;
        }

        for (int i = 0; i < args.length / 2; i++) {
            String cmd = args[i * 2];
            String value = args[(i * 2) + 1];
            switch (cmd) {
                case ARG_MODE: {
                    this.mode = value;
                    break;
                }
                case ARG_KEY: {
                    this.key = Integer.parseInt(value);
                    break;
                }
                case ARG_DATA: {
                    this.data = value;
                    break;
                }
                case ARG_IN: {
                    this.inputFileName = value;
                    break;
                }
                case ARG_OUT: {
                    this.outputFileName = value;
                    break;
                }

                case ARG_ALG: {
                    this.alg = value;
                }
            }
        }
        if ("dec".equals(this.mode)) {
            this.key = -this.key;
        }
        if (this.data.isBlank() && !this.inputFileName.isBlank()) {
            this.data = FileHelper.readFile(this.inputFileName);
        }
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public boolean haveErrors() {
        return haveErrors;
    }

    public void setHaveErrors(boolean haveErrors) {
        this.haveErrors = haveErrors;
    }

    @Override
    public String toString() {
        return "Options{" +
                "mode='" + mode + '\'' +
                ", key=" + key +
                ", data='" + data + '\'' +
                ", outputFileName='" + outputFileName + '\'' +
                ", inputFileName='" + inputFileName + '\'' +
                ", haveErrors=" + haveErrors +
                '}';
    }
}
