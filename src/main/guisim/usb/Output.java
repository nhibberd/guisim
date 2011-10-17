package guisim.usb;

import gnu.io.NoSuchPortException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Output {
    public void write(OutputStream device);
    public OutputStream get();
    public OutputStream start() throws NoSuchPortException, IOException;
}
