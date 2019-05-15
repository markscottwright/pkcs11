package pkcs11;

public class Pkcs11Exception extends Exception {

    private String functionName;
    private long rv;

    public Pkcs11Exception(String functionName, long rv) {
        super(functionName + " failed with exit code:" + rv);
        this.functionName = functionName;
        this.rv = rv;
    }

    public String getFunctionName() {
        return functionName;
    }

    public long getRv() {
        return rv;
    }

}
