package guisim.server;



import guisim.usb.HardwareOutput;
import guisim.usb.Output;
import io.mth.foil.j.Foil;
import io.mth.foil.j.Config;
import io.mth.foil.j.Configs;
import io.mth.foil.j.DefaultConfigs;
import io.mth.foil.j.DefaultFoils;
import io.mth.foil.j.Foils;


import gnu.io.*;

import javax.servlet.Servlet;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

public class GuiSim {
    private static final Foils foils = new DefaultFoils();
    private static final Configs c = new DefaultConfigs();
    private static Output device;

    static Enumeration	      portList;
    static CommPortIdentifier portId;
    static String	      messageString = "Hello, world!";
    static SerialPort	      serialPort;
    static OutputStream       outputStream;
    static boolean	      outputBufferEmptyFlag = false;

    public static void main(String[] args) {
        //TODO: comm port search??
        if (args.length > 0) {
            if(args[0].equals("COM3")){
                //SimpleWrite(args);
            }
        }

        try
		{
			CommDriver RXTXDriver = (CommDriver) Class.forName("gnu.io.RXTXCommDriver").newInstance();
			RXTXDriver.initialize();
		}
		catch (Throwable e)
		{
			System.err.println(e + " thrown while loading " + "gnu.io.RXTXCommDriver");
		}
        HardwareOutput usb = new HardwareOutput();
        OutputStream stream = null;
        try {
            stream = usb.start();
        } catch (NoSuchPortException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Servlet foo;
        if (stream != null){
            foo = new GuiSimServlet(stream);
        } else {
            System.out.println("Dataloader starting...");
            foo = new DataLoaderServlet();
        }

        Config config = c.compound(
           //c.servlet("/guisim", "/*", new GuiSimServlet(stream)),
           //c.servlet("/dataloader", "/*", new DataLoaderServlet()),
           c.servlet("/guisim", "/*", foo),
           c.path("/", "src/web")
        )
                ;
        Foil foil = foils.nu("guisim", 10080, config);
        foil.run();


    }
}
