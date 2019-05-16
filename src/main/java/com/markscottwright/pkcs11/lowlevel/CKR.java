package com.markscottwright.pkcs11.lowlevel;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class CKR {
    public final static long OK = 0;
    public final static long CANCEL = 0x00000001;
    public final static long HOST_MEMORY = 0x00000002;
    public final static long SLOT_ID_INVALID = 0x00000003;
    public final static long GENERAL_ERROR = 0x00000005;
    public final static long FUNCTION_FAILED = 0x00000006;
    public final static long ARGUMENTS_BAD = 0x00000007;
    public final static long NO_EVENT = 0x00000008;
    public final static long NEED_TO_CREATE_THREADS = 0x00000009;
    public final static long CANT_LOCK = 0x0000000A;
    public final static long ATTRIBUTE_READ_ONLY = 0x00000010;
    public final static long ATTRIBUTE_SENSITIVE = 0x00000011;
    public final static long ATTRIBUTE_TYPE_INVALID = 0x00000012;
    public final static long ATTRIBUTE_VALUE_INVALID = 0x00000013;
    public final static long DATA_INVALID = 0x00000020;
    public final static long DATA_LEN_RANGE = 0x00000021;
    public final static long DEVICE_ERROR = 0x00000030;
    public final static long DEVICE_MEMORY = 0x00000031;
    public final static long DEVICE_REMOVED = 0x00000032;
    public final static long ENCRYPTED_DATA_INVALID = 0x00000040;
    public final static long ENCRYPTED_DATA_LEN_RANGE = 0x00000041;
    public final static long FUNCTION_CANCELED = 0x00000050;
    public final static long FUNCTION_NOT_PARALLEL = 0x00000051;
    public final static long FUNCTION_NOT_SUPPORTED = 0x00000054;
    public final static long KEY_HANDLE_INVALID = 0x00000060;
    public final static long KEY_SIZE_RANGE = 0x00000062;
    public final static long KEY_TYPE_INCONSISTENT = 0x00000063;
    public final static long KEY_NOT_NEEDED = 0x00000064;
    public final static long KEY_CHANGED = 0x00000065;
    public final static long KEY_NEEDED = 0x00000066;
    public final static long KEY_INDIGESTIBLE = 0x00000067;
    public final static long KEY_FUNCTION_NOT_PERMITTED = 0x00000068;
    public final static long KEY_NOT_WRAPPABLE = 0x00000069;
    public final static long KEY_UNEXTRACTABLE = 0x0000006A;
    public final static long MECHANISM_INVALID = 0x00000070;
    public final static long MECHANISM_PARAM_INVALID = 0x00000071;
    public final static long OBJECT_HANDLE_INVALID = 0x00000082;
    public final static long OPERATION_ACTIVE = 0x00000090;
    public final static long OPERATION_NOT_INITIALIZED = 0x00000091;
    public final static long PIN_INCORRECT = 0x000000A0;
    public final static long PIN_INVALID = 0x000000A1;
    public final static long PIN_LEN_RANGE = 0x000000A2;
    public final static long PIN_EXPIRED = 0x000000A3;
    public final static long PIN_LOCKED = 0x000000A4;
    public final static long SESSION_CLOSED = 0x000000B0;
    public final static long SESSION_COUNT = 0x000000B1;
    public final static long SESSION_HANDLE_INVALID = 0x000000B3;
    public final static long SESSION_PARALLEL_NOT_SUPPORTED = 0x000000B4;
    public final static long SESSION_READ_ONLY = 0x000000B5;
    public final static long SESSION_EXISTS = 0x000000B6;
    public final static long SESSION_READ_ONLY_EXISTS = 0x000000B7;
    public final static long SESSION_READ_WRITE_SO_EXISTS = 0x000000B8;
    public final static long SIGNATURE_INVALID = 0x000000C0;
    public final static long SIGNATURE_LEN_RANGE = 0x000000C1;
    public final static long TEMPLATE_INCOMPLETE = 0x000000D0;
    public final static long TEMPLATE_INCONSISTENT = 0x000000D1;
    public final static long TOKEN_NOT_PRESENT = 0x000000E0;
    public final static long TOKEN_NOT_RECOGNIZED = 0x000000E1;
    public final static long TOKEN_WRITE_PROTECTED = 0x000000E2;
    public final static long UNWRAPPING_KEY_HANDLE_INVALID = 0x000000F0;
    public final static long UNWRAPPING_KEY_SIZE_RANGE = 0x000000F1;
    public final static long UNWRAPPING_KEY_TYPE_INCONSISTENT = 0x000000F2;
    public final static long USER_ALREADY_LOGGED_IN = 0x00000100;
    public final static long USER_NOT_LOGGED_IN = 0x00000101;
    public final static long USER_PIN_NOT_INITIALIZED = 0x00000102;
    public final static long USER_TYPE_INVALID = 0x00000103;
    public final static long USER_ANOTHER_ALREADY_LOGGED_IN = 0x00000104;
    public final static long USER_TOO_MANY_TYPES = 0x00000105;
    public final static long WRAPPED_KEY_INVALID = 0x00000110;
    public final static long WRAPPED_KEY_LEN_RANGE = 0x00000112;
    public final static long WRAPPING_KEY_HANDLE_INVALID = 0x00000113;
    public final static long WRAPPING_KEY_SIZE_RANGE = 0x00000114;
    public final static long WRAPPING_KEY_TYPE_INCONSISTENT = 0x00000115;
    public final static long RANDOM_SEED_NOT_SUPPORTED = 0x00000120;
    public final static long RANDOM_NO_RNG = 0x00000121;
    public final static long DOMAIN_PARAMS_INVALID = 0x00000130;
    public final static long BUFFER_TOO_SMALL = 0x00000150;
    public final static long SAVED_STATE_INVALID = 0x00000160;
    public final static long INFORMATION_SENSITIVE = 0x00000170;
    public final static long STATE_UNSAVEABLE = 0x00000180;
    public final static long CRYPTOKI_NOT_INITIALIZED = 0x00000190;
    public final static long CRYPTOKI_ALREADY_INITIALIZED = 0x00000191;
    public final static long MUTEX_BAD = 0x000001A0;
    public final static long MUTEX_NOT_LOCKED = 0x000001A1;
    public final static long VENDOR_DEFINED = 0x80000000;

    private static HashMap<Long, String> names = new HashMap<>();
    static {
        try {
            for (Field f : CKM.class.getFields()) {
                if (Modifier.isStatic(f.getModifiers())
                        && Modifier.isFinal(f.getModifiers())
                        && f.getType().equals(Long.TYPE)) {
                    names.put(f.getLong(null), "CKR_" + f.getName());
                }
            }
        } catch (SecurityException | IllegalArgumentException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static String toString(CK_RV m) {
        return toString(m.longValue());
    }

    public static String toString(long v) {
        return names.getOrDefault(v, String.format("CKR(0x%x)", v));
    }
}
