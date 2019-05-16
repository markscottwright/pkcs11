package com.markscottwright.pkcs11.lowlevel;

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

    static void check(String functionName, long rv) throws Pkcs11Exception {
        if (CKR.OK != rv)
            throw new Pkcs11Exception(functionName, rv);
    }

    public static void isOk(String functionName, CK_RV rv)
            throws Pkcs11Exception {
        check(functionName, rv.longValue());
    }
}
