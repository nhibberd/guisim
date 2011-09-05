package guisim.usb;

import guisim.load.HardwareLoader;

import javax.comm.*;
import javax.sound.sampled.Port;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class Usb {
    private static CommPortIdentifier communicationPort = null;

    public void main() throws NoSuchPortException, IOException {
        communicationPort = CommPortIdentifier.getPortIdentifier("asd");  //arduino ID/name?

        SerialPort port = null;
        try{
            port = (SerialPort) communicationPort.open("arduion", 10);
        } catch(PortInUseException e) {
            //error
        }
        try {
            port.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        } catch(UnsupportedCommOperationException e) {
            //error
        }
        startLoader(port.getInputStream());
    }

    private static void startLoader(InputStream data) {
        HardwareLoader worker = new HardwareLoader(data);
        Thread t = new Thread(worker);
        t.setDaemon(true);
        t.start();
    }
}
