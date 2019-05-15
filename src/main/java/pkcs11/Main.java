package pkcs11;

import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

public class Main {
    public static void main(String[] args) throws Pkcs11Exception {
        var pkcs11 = Native.load(
                // "etoken",
                "D:\\tools\\softhsm\\bin\\SoftHSMv2-x64\\softhsm2",
                Pkcs11.class);
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
