package com.markscottwright.pkcs11;

import com.markscottwright.pkcs11.lowlevel.CK_FUNCTION_LIST;
import com.markscottwright.pkcs11.lowlevel.CK_SLOT_ID;
import com.markscottwright.pkcs11.lowlevel.CK_TOKEN_INFO;
import com.markscottwright.pkcs11.lowlevel.CK_ULONG_PTR;
import com.markscottwright.pkcs11.lowlevel.Pkcs11;
import com.markscottwright.pkcs11.lowlevel.Pkcs11Exception;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

public class Main {
    public static void main(String[] args) throws Pkcs11Exception {
        String lib;
        if (args.length < 1)
            lib = "etoken";
        else
            lib = args[0];
        var pkcs11 = Native.load(lib, Pkcs11.class);
        CK_FUNCTION_LIST functions = Pkcs11.getFunctionList(pkcs11);

        functions.C_Initialize.invoke(Pointer.NULL);

        CK_ULONG_PTR numSlots = new CK_ULONG_PTR();
        int maxSlots = 100;
        numSlots.setValue(new NativeLong(maxSlots));
        CK_SLOT_ID[] slots = new CK_SLOT_ID[maxSlots];
        functions.C_GetSlotList.invoke(true, slots, numSlots);

        for (int i = 0; i < numSlots.getValue().intValue(); ++i) {
            CK_TOKEN_INFO tokenInfo = new CK_TOKEN_INFO();
            functions.C_GetTokenInfo.invoke(slots[i], tokenInfo);
            System.out.println(slots[i] + " " + tokenInfo.getLabel());
        }
        functions.C_Finalize.invoke(Pointer.NULL);
    }
}
