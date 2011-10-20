package guisim.usb;

import gnu.io.NoSuchPortException;

import java.io.IOException;
import java.io.OutputStream;

public class SyntheticOutput implements Output{
    public SyntheticOutput() {

    }

    public OutputStream start() throws NoSuchPortException, IOException {
        return null;
    }
}
