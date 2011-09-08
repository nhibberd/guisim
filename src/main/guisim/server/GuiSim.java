package guisim.server;



import com.sun.org.apache.bcel.internal.util.ClassPath;
import guisim.usb.Usb;
import io.mth.foil.j.Foil;
import io.mth.foil.j.Config;
import io.mth.foil.j.Configs;
import io.mth.foil.j.DefaultConfigs;
import io.mth.foil.j.DefaultFoils;
import io.mth.foil.j.Foils;


import gnu.io.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;

public class GuiSim {
    private static final Foils foils = new DefaultFoils();
    private static final Configs c = new DefaultConfigs();

    static Enumeration	      portList;
    static CommPortIdentifier portId;
    static String	      messageString = "Hello, world!";
    static SerialPort	      serialPort;
    static OutputStream       outputStream;
    static boolean	      outputBufferEmptyFlag = false;

    public static void main(String[] args) {
        if (args.length > 0) {
            if(args[0].equals("COM3")){
                SimpleWrite(args);
            }
        }

        try
		{
			CommDriver RXTXDriver = (CommDriver) Class.forName("gnu.io.RXTXCommDriver").newInstance();
			RXTXDriver.initialize();
	        System.out.println("try");
		}
		catch (Throwable e)
		{
			System.err.println(e + " thrown while loading " + "gnu.io.RXTXCommDriver");
		}


        Usb usb = new Usb();
        OutputStream device = null;
        try {
            device = usb.start();
        } catch (NoSuchPortException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Config config = c.compound(
           c.servlet("/guisim", "/*", new GuiSimServlet(device)),
           c.servlet("/dataloader", "/*", new DataLoaderServlet()),
           c.path("/", "src/web")
        )
                ;
        Foil foil = foils.nu("guisim", 10080, config);
        foil.run();


    }

public static void SimpleWrite(String[] args) {
    System.out.println("SimpleWrite");
	boolean portFound = false;
	String  defaultPort = "COM3";

	if (args.length > 0) {
	    defaultPort = args[0];
	}

	portList = CommPortIdentifier.getPortIdentifiers();

	while (portList.hasMoreElements()) {
	    portId = (CommPortIdentifier) portList.nextElement();

	    if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {

		if (portId.getName().equals(defaultPort)) {
		    System.out.println("Found port " + defaultPort);

		    portFound = true;

		    try {
			serialPort =
			    (SerialPort) portId.open("SimpleWrite", 2000);
		    } catch (PortInUseException e) {
			System.out.println("Port in use.");

			continue;
		    }

		    try {
			outputStream = serialPort.getOutputStream();
		    } catch (IOException e) {}

		    try {
			serialPort.setSerialPortParams(9600,
						       SerialPort.DATABITS_8,
						       SerialPort.STOPBITS_1,
						       SerialPort.PARITY_NONE);
		    } catch (UnsupportedCommOperationException e) {}


		    try {
		    	serialPort.notifyOnOutputEmpty(true);
		    } catch (Exception e) {
			System.out.println("Error setting event notification");
			System.out.println(e.toString());
			System.exit(-1);
		    }


		    System.out.println(
		    	"Writing \""+messageString+"\" to "
			+serialPort.getName());

		    try {
			outputStream.write(messageString.getBytes());
		    } catch (IOException e) {}

		    try {
		       Thread.sleep(2000);  // Be sure data is xferred before closing
		    } catch (Exception e) {}
		    serialPort.close();
		    System.exit(1);
		}
	    }
	}

	if (!portFound) {
	    System.out.println("port " + defaultPort + " not found.");
	}
    }
}
