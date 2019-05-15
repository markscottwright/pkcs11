package pkcs11;

import com.sun.jna.Library;
import com.sun.jna.ptr.PointerByReference;

public interface Pkcs11 extends Library {
    CK_RV C_GetFunctionList(PointerByReference function_list);
    
    static CK_FUNCTION_LIST getFunctionList(Pkcs11 pkcs11) throws Pkcs11Exception {
        PointerByReference functionList = new PointerByReference();
        CK_RV rv = pkcs11.C_GetFunctionList(functionList);
        if (rv.longValue() != 0)
            throw new Pkcs11Exception("C_GetFunctionList", rv.longValue());
        return new CK_FUNCTION_LIST(functionList.getValue());
    }
}
