package guisim.usb;

import guisim.load.HardwareLoader;

import javax.comm.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Usb {
    public void main() throws NoSuchPortException, IOException {
        CommPortIdentifier communicationPort = CommPortIdentifier.getPortIdentifier("asd");  //arduino ID/name?

        SerialPort port = null;
        try{
            port = (SerialPort) communicationPort.open("arduion", 10);
        } catch(PortInUseException e) {
            //error
        }
        try {
            if (port != null) {
                port.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            }
        } catch(UnsupportedCommOperationException e) {
            //error
        }
        if (port != null) {
            startLoader(port.getInputStream());
            startOutput(port.getOutputStream());
        }
    }

    private static void startOutput(OutputStream data) {
        Output outputWorker = new Output(data);
    }

    private static void startLoader(InputStream data) {
        HardwareLoader worker = new HardwareLoader(data);
        Thread t = new Thread(worker);
        t.setDaemon(true);
        t.start();
    }
}
