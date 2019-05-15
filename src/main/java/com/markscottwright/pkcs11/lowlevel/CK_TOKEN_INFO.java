package com.markscottwright.pkcs11.lowlevel;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

//@formatter:off
@FieldOrder(value = { 
                "label",
                "manufacturerID",
                "model",
                "serialNumber",
                "flags",
                "ulMaxSessionCount",
                "ulSessionCount",
                "ulMaxRwSessionCount",
                "ulRwSessionCount",
                "ulMaxPinLen",
                "ulMinPinLen",
                "ulTotalPublicMemory",
                "ulFreePublicMemory",
                "ulTotalPrivateMemory",
                "ulFreePrivateMemory",
                "hardwareVersion",
                "firmwareVersion",
                "utcTime"
         })
//@formatter:on
public class CK_TOKEN_INFO extends Structure {
    public byte label[] = new byte[32]; /* blank padded */
    public byte manufacturerID[] = new byte[32]; /* blank padded */
    public byte model[] = new byte[16]; /* blank padded */
    public byte serialNumber[] = new byte[16]; /* blank padded */
    public CK_FLAGS flags; /* see below */
    public CK_ULONG ulMaxSessionCount; /* max open sessions */
    public CK_ULONG ulSessionCount; /* sess. now open */
    public CK_ULONG ulMaxRwSessionCount; /* max R/W sessions */
    public CK_ULONG ulRwSessionCount; /* R/W sess. now open */
    public CK_ULONG ulMaxPinLen; /* in bytes */
    public CK_ULONG ulMinPinLen; /* in bytes */
    public CK_ULONG ulTotalPublicMemory; /* in bytes */
    public CK_ULONG ulFreePublicMemory; /* in bytes */
    public CK_ULONG ulTotalPrivateMemory; /* in bytes */
    public CK_ULONG ulFreePrivateMemory; /* in bytes */
    public CK_VERSION hardwareVersion; /* version of hardware */
    public CK_VERSION firmwareVersion; /* version of firmware */
    public byte utcTime[] = new byte[16]; /* time */

    public CK_TOKEN_INFO() {
        super(ALIGN_NONE);
    }

    public String getLabel() {
        return new String(label);
    }
}
