package pkcs11;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder(value = { "cryptokiVersion", "manufacturerId", "flags",
        "libraryDescription", "libraryVersion" })
public class CK_INFO extends Structure {
    public CK_VERSION cryptokiVersion;
    public byte[] manufacturerId = new byte[32];
    public CK_FLAGS flags;
    public byte[] libraryDescription = new byte[32];
    public CK_VERSION libraryVersion;

    public CK_INFO() {
        super(ALIGN_NONE);
    }

    String getManufacturerId() {
        return new String(manufacturerId);
    }

    String getLibraryDescription() {
        return new String(libraryDescription);
    }
}
