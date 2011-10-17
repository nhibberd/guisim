package guisim.usb;

import gnu.io.NoSuchPortException;

import java.io.IOException;
import java.io.OutputStream;

public class SyntheticOutput implements Output {
    public OutputStream write(OutputStream device) {
        return device;
    }

    public OutputStream start() throws NoSuchPortException, IOException {
        return null;
    }
}
