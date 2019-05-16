package pkcs11;

import static com.markscottwright.pkcs11.lowlevel.Pkcs11Exception.isOk;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

import com.markscottwright.pkcs11.lowlevel.CKM;
import com.markscottwright.pkcs11.lowlevel.CK_MECHANISM_TYPE;
import com.markscottwright.pkcs11.lowlevel.CK_ULONG_PTR;
import com.markscottwright.pkcs11.lowlevel.Pkcs11Exception;
import com.sun.jna.NativeLong;

public class MechanismTest extends SoftHsmTest {
    private static final int CKM_AES_CBC = 0x1082;

    @Test
    public void mechanismList_hasExpectedMechanisms() throws Pkcs11Exception {
        CK_ULONG_PTR numMechanisms = new CK_ULONG_PTR();
        numMechanisms.setValue(new NativeLong(0));
        isOk("C_GetMechanismList", functions.C_GetMechanismList.invoke(slotId,
                null, numMechanisms));
        assertThat(numMechanisms.getValue().intValue()).isGreaterThan(5);

        CK_MECHANISM_TYPE[] mechanisms = new CK_MECHANISM_TYPE[numMechanisms
                .getValue().intValue()];
        isOk("C_GetMechanismList", functions.C_GetMechanismList.invoke(slotId,
                mechanisms, numMechanisms));
        assertThat(Arrays.stream(mechanisms)
                .anyMatch(m -> m.intValue() == CKM_AES_CBC));
        Arrays.stream(mechanisms).map(CKM::toString)
                .anyMatch(m -> "CKM_DES_CBC".equals(m));
    }

}
