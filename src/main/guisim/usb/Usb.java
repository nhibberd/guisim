package guisim.usb;

import javax.comm.*;
import javax.sound.sampled.Port;
import java.util.Enumeration;

public class Usb {

    //http://en.wikibooks.org/wiki/Serial_Programming/Serial_Java
    public void AutoSetupPort(){
        Enumeration commPort = CommPortIdentifier.getPortIdentifiers();
        CommPortIdentifier portId = null;  // will be set if port found

        while (commPort.hasMoreElements()) {
            CommPortIdentifier pid = (CommPortIdentifier) commPort.nextElement();
            if(pid.getPortType() == CommPortIdentifier.PORT_SERIAL &&
               pid.getName().equals("asd")) {       //arduino ID/name?
                portId = pid;
            }
        }
        SerialPort port = null;

        try {
            port = (SerialPort) portId.open("arduino", 10000);
        } catch(PortInUseException e) {
            //error
        }
        try {
            port.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        } catch(UnsupportedCommOperationException e) {
            //error
        }
    }

    public void SetupPort() throws NoSuchPortException {
        CommPortIdentifier commPort = CommPortIdentifier.getPortIdentifier("asd");  //arduino ID/name?

        SerialPort port = null;
        try{
            port = (SerialPort) commPort.open("arduion", 10);
        } catch(PortInUseException e) {
            //error
        }
        try {
            port.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        } catch(UnsupportedCommOperationException e) {
            //error
        }


    }
}
