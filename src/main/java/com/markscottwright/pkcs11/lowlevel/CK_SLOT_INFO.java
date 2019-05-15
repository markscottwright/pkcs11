package com.markscottwright.pkcs11.lowlevel;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder(value = { "slotDescription", "manufacturerID", "flags",
        "hardwareVersion", "softwareVersion" })
public class CK_SLOT_INFO extends Structure {
    public byte[] slotDescription = new byte[64];
    public byte[] manufacturerID = new byte[32];
    public CK_FLAGS flags;
    public CK_VERSION hardwareVersion;
    public CK_VERSION softwareVersion;

    public CK_SLOT_INFO() {
        super(ALIGN_NONE);
    }

    public String getSlotDescription() {
        return new String(slotDescription);
    }

    public String getManufacturerID() {
        return new String(manufacturerID);
    }
}
