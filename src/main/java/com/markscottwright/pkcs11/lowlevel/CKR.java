package com.markscottwright.pkcs11.lowlevel;

import com.sun.jna.NativeLong;

public enum CKR {
    //@formatter:off
    OK                                (0),
    CANCEL                            (0x00000001),
    HOST_MEMORY                       (0x00000002),
    SLOT_ID_INVALID                   (0x00000003),
    GENERAL_ERROR                     (0x00000005),
    FUNCTION_FAILED                   (0x00000006),
    ARGUMENTS_BAD                     (0x00000007),
    NO_EVENT                          (0x00000008),
    NEED_TO_CREATE_THREADS            (0x00000009),
    CANT_LOCK                         (0x0000000A),
    ATTRIBUTE_READ_ONLY               (0x00000010),
    ATTRIBUTE_SENSITIVE               (0x00000011),
    ATTRIBUTE_TYPE_INVALID            (0x00000012),
    ATTRIBUTE_VALUE_INVALID           (0x00000013),
    DATA_INVALID                      (0x00000020),
    DATA_LEN_RANGE                    (0x00000021),
    DEVICE_ERROR                      (0x00000030),
    DEVICE_MEMORY                     (0x00000031),
    DEVICE_REMOVED                    (0x00000032),
    ENCRYPTED_DATA_INVALID            (0x00000040),
    ENCRYPTED_DATA_LEN_RANGE          (0x00000041),
    FUNCTION_CANCELED                 (0x00000050),
    FUNCTION_NOT_PARALLEL             (0x00000051),
    FUNCTION_NOT_SUPPORTED            (0x00000054),
    KEY_HANDLE_INVALID                (0x00000060),
    KEY_SIZE_RANGE                    (0x00000062),
    KEY_TYPE_INCONSISTENT             (0x00000063),
    KEY_NOT_NEEDED                    (0x00000064),
    KEY_CHANGED                       (0x00000065),
    KEY_NEEDED                        (0x00000066),
    KEY_INDIGESTIBLE                  (0x00000067),
    KEY_FUNCTION_NOT_PERMITTED        (0x00000068),
    KEY_NOT_WRAPPABLE                 (0x00000069),
    KEY_UNEXTRACTABLE                 (0x0000006A),
    MECHANISM_INVALID                 (0x00000070),
    MECHANISM_PARAM_INVALID           (0x00000071),
    OBJECT_HANDLE_INVALID             (0x00000082),
    OPERATION_ACTIVE                  (0x00000090),
    OPERATION_NOT_INITIALIZED         (0x00000091),
    PIN_INCORRECT                     (0x000000A0),
    PIN_INVALID                       (0x000000A1),
    PIN_LEN_RANGE                     (0x000000A2),
    PIN_EXPIRED                       (0x000000A3),
    PIN_LOCKED                        (0x000000A4),
    SESSION_CLOSED                    (0x000000B0),
    SESSION_COUNT                     (0x000000B1),
    SESSION_HANDLE_INVALID            (0x000000B3),
    SESSION_PARALLEL_NOT_SUPPORTED    (0x000000B4),
    SESSION_READ_ONLY                 (0x000000B5),
    SESSION_EXISTS                    (0x000000B6),
    SESSION_READ_ONLY_EXISTS          (0x000000B7),
    SESSION_READ_WRITE_SO_EXISTS      (0x000000B8),
    SIGNATURE_INVALID                 (0x000000C0),
    SIGNATURE_LEN_RANGE               (0x000000C1),
    TEMPLATE_INCOMPLETE               (0x000000D0),
    TEMPLATE_INCONSISTENT             (0x000000D1),
    TOKEN_NOT_PRESENT                 (0x000000E0),
    TOKEN_NOT_RECOGNIZED              (0x000000E1),
    TOKEN_WRITE_PROTECTED             (0x000000E2),
    UNWRAPPING_KEY_HANDLE_INVALID     (0x000000F0),
    UNWRAPPING_KEY_SIZE_RANGE         (0x000000F1),
    UNWRAPPING_KEY_TYPE_INCONSISTENT  (0x000000F2),
    USER_ALREADY_LOGGED_IN            (0x00000100),
    USER_NOT_LOGGED_IN                (0x00000101),
    USER_PIN_NOT_INITIALIZED          (0x00000102),
    USER_TYPE_INVALID                 (0x00000103),
    USER_ANOTHER_ALREADY_LOGGED_IN    (0x00000104),
    USER_TOO_MANY_TYPES               (0x00000105),
    WRAPPED_KEY_INVALID               (0x00000110),
    WRAPPED_KEY_LEN_RANGE             (0x00000112),
    WRAPPING_KEY_HANDLE_INVALID       (0x00000113),
    WRAPPING_KEY_SIZE_RANGE           (0x00000114),
    WRAPPING_KEY_TYPE_INCONSISTENT    (0x00000115),
    RANDOM_SEED_NOT_SUPPORTED         (0x00000120),
    RANDOM_NO_RNG                     (0x00000121),
    DOMAIN_PARAMS_INVALID             (0x00000130),
    BUFFER_TOO_SMALL                  (0x00000150),
    SAVED_STATE_INVALID               (0x00000160),
    INFORMATION_SENSITIVE             (0x00000170),
    STATE_UNSAVEABLE                  (0x00000180),
    CRYPTOKI_NOT_INITIALIZED          (0x00000190),
    CRYPTOKI_ALREADY_INITIALIZED      (0x00000191),
    MUTEX_BAD                         (0x000001A0),
    MUTEX_NOT_LOCKED                  (0x000001A1),
    VENDOR_DEFINED                    (0x80000000);
    //@formatter:on

    private long value;

    private CKR(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public boolean equals(long v) {
        return this.value == v;
    }

    public boolean equals(NativeLong v) {
        return this.value == v.longValue();
    }
}
