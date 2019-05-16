package com.markscottwright.pkcs11.lowlevel;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class CKM {
    public final static long RSA_PKCS_KEY_PAIR_GEN = 0x00000000;
    public final static long RSA_PKCS = 0x00000001;
    public final static long RSA_9796 = 0x00000002;
    public final static long RSA_X_509 = 0x00000003;
    public final static long MD2_RSA_PKCS = 0x00000004;
    public final static long MD5_RSA_PKCS = 0x00000005;
    public final static long SHA1_RSA_PKCS = 0x00000006;
    public final static long RIPEMD128_RSA_PKCS = 0x00000007;
    public final static long RIPEMD160_RSA_PKCS = 0x00000008;
    public final static long RSA_PKCS_OAEP = 0x00000009;
    public final static long RSA_X9_31_KEY_PAIR_GEN = 0x0000000A;
    public final static long RSA_X9_31 = 0x0000000B;
    public final static long SHA1_RSA_X9_31 = 0x0000000C;
    public final static long RSA_PKCS_PSS = 0x0000000D;
    public final static long SHA1_RSA_PKCS_PSS = 0x0000000E;
    public final static long DSA_KEY_PAIR_GEN = 0x00000010;
    public final static long DSA = 0x00000011;
    public final static long DSA_SHA1 = 0x00000012;
    public final static long DH_PKCS_KEY_PAIR_GEN = 0x00000020;
    public final static long DH_PKCS_DERIVE = 0x00000021;
    public final static long X9_42_DH_KEY_PAIR_GEN = 0x00000030;
    public final static long X9_42_DH_DERIVE = 0x00000031;
    public final static long X9_42_DH_HYBRID_DERIVE = 0x00000032;
    public final static long X9_42_MQV_DERIVE = 0x00000033;
    public final static long RC2_KEY_GEN = 0x00000100;
    public final static long RC2_ECB = 0x00000101;
    public final static long RC2_CBC = 0x00000102;
    public final static long RC2_MAC = 0x00000103;
    public final static long RC2_MAC_GENERAL = 0x00000104;
    public final static long RC2_CBC_PAD = 0x00000105;
    public final static long RC4_KEY_GEN = 0x00000110;
    public final static long RC4 = 0x00000111;
    public final static long DES_KEY_GEN = 0x00000120;
    public final static long DES_ECB = 0x00000121;
    public final static long DES_CBC = 0x00000122;
    public final static long DES_MAC = 0x00000123;
    public final static long DES_MAC_GENERAL = 0x00000124;
    public final static long DES_CBC_PAD = 0x00000125;
    public final static long DES2_KEY_GEN = 0x00000130;
    public final static long DES3_KEY_GEN = 0x00000131;
    public final static long DES3_ECB = 0x00000132;
    public final static long DES3_CBC = 0x00000133;
    public final static long DES3_MAC = 0x00000134;
    public final static long DES3_MAC_GENERAL = 0x00000135;
    public final static long DES3_CBC_PAD = 0x00000136;
    public final static long CDMF_KEY_GEN = 0x00000140;
    public final static long CDMF_ECB = 0x00000141;
    public final static long CDMF_CBC = 0x00000142;
    public final static long CDMF_MAC = 0x00000143;
    public final static long CDMF_MAC_GENERAL = 0x00000144;
    public final static long CDMF_CBC_PAD = 0x00000145;
    public final static long MD2 = 0x00000200;
    public final static long MD2_HMAC = 0x00000201;
    public final static long MD2_HMAC_GENERAL = 0x00000202;
    public final static long MD5 = 0x00000210;
    public final static long MD5_HMAC = 0x00000211;
    public final static long MD5_HMAC_GENERAL = 0x00000212;
    public final static long SHA_1 = 0x00000220;
    public final static long SHA_1_HMAC = 0x00000221;
    public final static long SHA_1_HMAC_GENERAL = 0x00000222;
    public final static long RIPEMD128 = 0x00000230;
    public final static long RIPEMD128_HMAC = 0x00000231;
    public final static long RIPEMD128_HMAC_GENERAL = 0x00000232;
    public final static long RIPEMD160 = 0x00000240;
    public final static long RIPEMD160_HMAC = 0x00000241;
    public final static long RIPEMD160_HMAC_GENERAL = 0x00000242;
    public final static long CAST_KEY_GEN = 0x00000300;
    public final static long CAST_ECB = 0x00000301;
    public final static long CAST_CBC = 0x00000302;
    public final static long CAST_MAC = 0x00000303;
    public final static long CAST_MAC_GENERAL = 0x00000304;
    public final static long CAST_CBC_PAD = 0x00000305;
    public final static long CAST3_KEY_GEN = 0x00000310;
    public final static long CAST3_ECB = 0x00000311;
    public final static long CAST3_CBC = 0x00000312;
    public final static long CAST3_MAC = 0x00000313;
    public final static long CAST3_MAC_GENERAL = 0x00000314;
    public final static long CAST3_CBC_PAD = 0x00000315;
    public final static long CAST5_KEY_GEN = 0x00000320;
    public final static long CAST128_KEY_GEN = 0x00000320;
    public final static long CAST5_ECB = 0x00000321;
    public final static long CAST128_ECB = 0x00000321;
    public final static long CAST5_CBC = 0x00000322;
    public final static long CAST128_CBC = 0x00000322;
    public final static long CAST5_MAC = 0x00000323;
    public final static long CAST128_MAC = 0x00000323;
    public final static long CAST5_MAC_GENERAL = 0x00000324;
    public final static long CAST128_MAC_GENERAL = 0x00000324;
    public final static long CAST5_CBC_PAD = 0x00000325;
    public final static long CAST128_CBC_PAD = 0x00000325;
    public final static long RC5_KEY_GEN = 0x00000330;
    public final static long RC5_ECB = 0x00000331;
    public final static long RC5_CBC = 0x00000332;
    public final static long RC5_MAC = 0x00000333;
    public final static long RC5_MAC_GENERAL = 0x00000334;
    public final static long RC5_CBC_PAD = 0x00000335;
    public final static long IDEA_KEY_GEN = 0x00000340;
    public final static long IDEA_ECB = 0x00000341;
    public final static long IDEA_CBC = 0x00000342;
    public final static long IDEA_MAC = 0x00000343;
    public final static long IDEA_MAC_GENERAL = 0x00000344;
    public final static long IDEA_CBC_PAD = 0x00000345;
    public final static long GENERIC_SECRET_KEY_GEN = 0x00000350;
    public final static long CONCATENATE_BASE_AND_KEY = 0x00000360;
    public final static long CONCATENATE_BASE_AND_DATA = 0x00000362;
    public final static long CONCATENATE_DATA_AND_BASE = 0x00000363;
    public final static long XOR_BASE_AND_DATA = 0x00000364;
    public final static long EXTRACT_KEY_FROM_KEY = 0x00000365;
    public final static long SSL3_PRE_MASTER_KEY_GEN = 0x00000370;
    public final static long SSL3_MASTER_KEY_DERIVE = 0x00000371;
    public final static long SSL3_KEY_AND_MAC_DERIVE = 0x00000372;
    public final static long SSL3_MASTER_KEY_DERIVE_DH = 0x00000373;
    public final static long TLS_PRE_MASTER_KEY_GEN = 0x00000374;
    public final static long TLS_MASTER_KEY_DERIVE = 0x00000375;
    public final static long TLS_KEY_AND_MAC_DERIVE = 0x00000376;
    public final static long TLS_MASTER_KEY_DERIVE_DH = 0x00000377;
    public final static long SSL3_MD5_MAC = 0x00000380;
    public final static long SSL3_SHA1_MAC = 0x00000381;
    public final static long MD5_KEY_DERIVATION = 0x00000390;
    public final static long MD2_KEY_DERIVATION = 0x00000391;
    public final static long SHA1_KEY_DERIVATION = 0x00000392;
    public final static long PBE_MD2_DES_CBC = 0x000003A0;
    public final static long PBE_MD5_DES_CBC = 0x000003A1;
    public final static long PBE_MD5_CAST_CBC = 0x000003A2;
    public final static long PBE_MD5_CAST3_CBC = 0x000003A3;
    public final static long PBE_MD5_CAST5_CBC = 0x000003A4;
    public final static long PBE_MD5_CAST128_CBC = 0x000003A4;
    public final static long PBE_SHA1_CAST5_CBC = 0x000003A5;
    public final static long PBE_SHA1_CAST128_CBC = 0x000003A5;
    public final static long PBE_SHA1_RC4_128 = 0x000003A6;
    public final static long PBE_SHA1_RC4_40 = 0x000003A7;
    public final static long PBE_SHA1_DES3_EDE_CBC = 0x000003A8;
    public final static long PBE_SHA1_DES2_EDE_CBC = 0x000003A9;
    public final static long PBE_SHA1_RC2_128_CBC = 0x000003AA;
    public final static long PBE_SHA1_RC2_40_CBC = 0x000003AB;
    public final static long PKCS5_PBKD2 = 0x000003B0;
    public final static long PBA_SHA1_WITH_SHA1_HMAC = 0x000003C0;
    public final static long KEY_WRAP_LYNKS = 0x00000400;
    public final static long KEY_WRAP_SET_OAEP = 0x00000401;
    public final static long SKIPJACK_KEY_GEN = 0x00001000;
    public final static long SKIPJACK_ECB64 = 0x00001001;
    public final static long SKIPJACK_CBC64 = 0x00001002;
    public final static long SKIPJACK_OFB64 = 0x00001003;
    public final static long SKIPJACK_CFB64 = 0x00001004;
    public final static long SKIPJACK_CFB32 = 0x00001005;
    public final static long SKIPJACK_CFB16 = 0x00001006;
    public final static long SKIPJACK_CFB8 = 0x00001007;
    public final static long SKIPJACK_WRAP = 0x00001008;
    public final static long SKIPJACK_PRIVATE_WRAP = 0x00001009;
    public final static long SKIPJACK_RELAYX = 0x0000100a;
    public final static long KEA_KEY_PAIR_GEN = 0x00001010;
    public final static long KEA_KEY_DERIVE = 0x00001011;
    public final static long FORTEZZA_TIMESTAMP = 0x00001020;
    public final static long BATON_KEY_GEN = 0x00001030;
    public final static long BATON_ECB128 = 0x00001031;
    public final static long BATON_ECB96 = 0x00001032;
    public final static long BATON_CBC128 = 0x00001033;
    public final static long BATON_COUNTER = 0x00001034;
    public final static long BATON_SHUFFLE = 0x00001035;
    public final static long BATON_WRAP = 0x00001036;
    public final static long ECDSA_KEY_PAIR_GEN = 0x00001040;
    public final static long EC_KEY_PAIR_GEN = 0x00001040;
    public final static long ECDSA = 0x00001041;
    public final static long ECDSA_SHA1 = 0x00001042;
    public final static long ECDH1_DERIVE = 0x00001050;
    public final static long ECDH1_COFACTOR_DERIVE = 0x00001051;
    public final static long ECMQV_DERIVE = 0x00001052;
    public final static long JUNIPER_KEY_GEN = 0x00001060;
    public final static long JUNIPER_ECB128 = 0x00001061;
    public final static long JUNIPER_CBC128 = 0x00001062;
    public final static long JUNIPER_COUNTER = 0x00001063;
    public final static long JUNIPER_SHUFFLE = 0x00001064;
    public final static long JUNIPER_WRAP = 0x00001065;
    public final static long FASTHASH = 0x00001070;
    public final static long AES_KEY_GEN = 0x00001080;
    public final static long AES_ECB = 0x00001081;
    public final static long AES_CBC = 0x00001082;
    public final static long AES_MAC = 0x00001083;
    public final static long AES_MAC_GENERAL = 0x00001084;
    public final static long AES_CBC_PAD = 0x00001085;
    public final static long DSA_PARAMETER_GEN = 0x00002000;
    public final static long DH_PKCS_PARAMETER_GEN = 0x00002001;
    public final static long X9_42_DH_PARAMETER_GEN = 0x00002002;
    public final static long VENDOR_DEFINED = 0x80000000;

    private static HashMap<Long, String> names = new HashMap<>();
    static {
        try {
            for (Field f : CKM.class.getFields()) {
                if (Modifier.isStatic(f.getModifiers())
                        && Modifier.isFinal(f.getModifiers())
                        && f.getType().equals(Long.TYPE)) {
                    names.put(f.getLong(null), "CKM_" + f.getName());
                }
            }
        } catch (SecurityException | IllegalArgumentException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static String toString(CK_MECHANISM_TYPE m) {
        return toString(m.longValue());
    }

    public static String toString(long v) {
        return names.getOrDefault(v, String.format("CKM(0x%x)", v));
    }
}
