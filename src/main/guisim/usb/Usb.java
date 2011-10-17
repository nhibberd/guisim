package guisim.usb;

import gnu.io.*;
import guisim.load.HardwareLoader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Usb {

    public OutputStream start() throws NoSuchPortException, IOException {
        try
		{
			CommDriver RXTXDriver = (CommDriver) Class.forName("gnu.io.RXTXCommDriver").newInstance();
			RXTXDriver.initialize();
		}
		catch (Throwable e)
		{
			System.err.println(e + " thrown while loading " + "gnu.io.RXTXCommDriver");
		}

        CommPortIdentifier communicationPort = null;
        String thisPort = "COM3";
        try{
            communicationPort = CommPortIdentifier.getPortIdentifier(thisPort);
        } catch(NoSuchPortException e) {
            //error
            System.err.println("No such port " + thisPort);
        }
        SerialPort port = null;
        try{
            if (communicationPort != null) {
                port = (SerialPort) communicationPort.open("Arduion UNO", 10);
                System.out.println(".open");
            }
        } catch(PortInUseException e) {
            //error
            System.err.println(thisPort + " is in use.");
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
            return port.getOutputStream();
        }
        return null;
    }

    private static void startLoader(InputStream data) {
        HardwareLoader worker = new HardwareLoader(data);
        Thread t = new Thread(worker);
        t.setDaemon(true);
        t.start();
    }
}
