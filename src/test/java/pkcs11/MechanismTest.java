package pkcs11;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.markscottwright.pkcs11.lowlevel.CK_FUNCTION_LIST;
import com.markscottwright.pkcs11.lowlevel.CK_MECHANISM_TYPE;
import com.markscottwright.pkcs11.lowlevel.CK_RV;
import com.markscottwright.pkcs11.lowlevel.CK_SLOT_ID;
import com.markscottwright.pkcs11.lowlevel.CK_ULONG_PTR;
import com.markscottwright.pkcs11.lowlevel.Pkcs11;
import com.markscottwright.pkcs11.lowlevel.Pkcs11Exception;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

/**
 * Set environment variable SOFTHSM2_CONF=softhsm\windows\softhsm2.conf to run
 * this
 * 
 * Slot id is 125480439
 */
public class MechanismTest {
    private static final int CKM_AES_CBC = 0x1082;
    private CK_FUNCTION_LIST functions;
    private CK_SLOT_ID slotId;

    @Before
    public void setUp() throws Pkcs11Exception {
        assertThat(System.getenv("SOFTHSM2_CONF"))
                .isEqualToIgnoringCase("softhsm\\windows\\softhsm2.conf");
        var pkcs11 = Native.load("softhsm\\windows\\softhsm2.dll",
                Pkcs11.class);
        functions = Pkcs11.getFunctionList(pkcs11);
        CK_RV rv = functions.C_Initialize.invoke(Pointer.NULL);
        assertThat(rv.intValue()).isEqualTo(0);

        slotId = new CK_SLOT_ID();
        slotId.setValue(125480439);
    }

    @After
    public void tearDown() {
        var rv = functions.C_Finalize.invoke(Pointer.NULL);
        assertThat(rv.intValue()).isEqualTo(0);
    }

    @Test
    public void mechanismList_hasExpectedMechanisms() throws Pkcs11Exception {
        CK_ULONG_PTR numMechanisms = new CK_ULONG_PTR();
        numMechanisms.setValue(new NativeLong(0));
        var rv = functions.C_GetMechanismList.invoke(slotId, null,
                numMechanisms);
        assertThat(rv.intValue()).isEqualTo(0);
        assertThat(numMechanisms.getValue().intValue()).isGreaterThan(5);

        CK_MECHANISM_TYPE[] mechanisms = new CK_MECHANISM_TYPE[numMechanisms
                .getValue().intValue()];
        rv = functions.C_GetMechanismList.invoke(slotId, mechanisms,
                numMechanisms);
        assertThat(rv.intValue()).isEqualTo(0);
        assertThat(Arrays.stream(mechanisms)
                .anyMatch(m -> m.intValue() == CKM_AES_CBC));
    }

}
