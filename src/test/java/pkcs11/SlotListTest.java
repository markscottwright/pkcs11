package pkcs11;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.markscottwright.pkcs11.lowlevel.CK_FUNCTION_LIST;
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
public class SlotListTest {

    private CK_FUNCTION_LIST functions;

    @Before
    public void setUp() throws Pkcs11Exception {
        assertThat(System.getenv("SOFTHSM2_CONF"))
                .isEqualToIgnoringCase("softhsm\\windows\\softhsm2.conf");
        var pkcs11 = Native.load("softhsm\\windows\\softhsm2.dll",
                Pkcs11.class);
        functions = Pkcs11.getFunctionList(pkcs11);
        CK_RV rv = functions.C_Initialize.invoke(Pointer.NULL);
        assertThat(rv.intValue()).isEqualTo(0);
    }

    @After
    public void tearDown() {
        var rv = functions.C_Finalize.invoke(Pointer.NULL);
        assertThat(rv.intValue()).isEqualTo(0);
    }

    @Test
    public void softHsmEnvironment_hasOneSlot() throws Pkcs11Exception {
        CK_ULONG_PTR numSlots = new CK_ULONG_PTR();
        int maxSlots = 100;
        numSlots.setValue(new NativeLong(maxSlots));
        CK_SLOT_ID[] slots = new CK_SLOT_ID[maxSlots];
        var rv = functions.C_GetSlotList.invoke(true, slots, numSlots);

        // 1 for actual slot, 1 for the softhsm initial slot
        assertThat(rv.intValue()).isEqualTo(0);
        assertThat(numSlots.getValue().longValue()).isEqualTo(2);
    }

    @Test
    public void getSlotList_withNullList_populatesCount() {
        CK_ULONG_PTR numSlots = new CK_ULONG_PTR();
        int maxSlots = 0;
        numSlots.setValue(new NativeLong(maxSlots));
        var rv = functions.C_GetSlotList.invoke(true, null, numSlots);

        // 1 for actual slot, 1 for the softhsm initial slot
        assertThat(rv.intValue()).isEqualTo(0);
        assertThat(numSlots.getValue().longValue()).isEqualTo(2);
    }

}
