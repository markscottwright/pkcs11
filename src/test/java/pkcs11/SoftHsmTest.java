package pkcs11;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;

import com.markscottwright.pkcs11.lowlevel.CK_FUNCTION_LIST;
import com.markscottwright.pkcs11.lowlevel.CK_RV;
import com.markscottwright.pkcs11.lowlevel.CK_SLOT_ID;
import com.markscottwright.pkcs11.lowlevel.Pkcs11;
import com.markscottwright.pkcs11.lowlevel.Pkcs11Exception;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

/**
 * Base for tests that use the SoftHsm emulator - sets up PKCS11 connections and
 * valid slot id
 */
public class SoftHsmTest {

    protected CK_FUNCTION_LIST functions;
    protected CK_SLOT_ID slotId;

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

}