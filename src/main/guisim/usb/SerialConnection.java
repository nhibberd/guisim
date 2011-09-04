package guisim.usb;

import javax.comm.*;

public class SerialConnection implements SerialPortEventListener,
					 CommPortOwnershipListener {
    public void ownershipChange(int i) {
    }

    public void serialEvent(SerialPortEvent serialPortEvent) {
    }
}
