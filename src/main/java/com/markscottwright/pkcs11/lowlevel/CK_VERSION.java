package com.markscottwright.pkcs11.lowlevel;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder(value = { "major", "minor" })
public class CK_VERSION extends Structure {
    public byte major;
    public byte minor;
    
    public CK_VERSION() {
        super(ALIGN_NONE);
    }
}
