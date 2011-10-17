package guisim.server;

import guisim.json.Flight;
import guisim.load.AtomRef;
import guisim.load.HardwareEvents;
import guisim.model.FromGui;
import guisim.model.FromGuiObjects;
import guisim.model.FromHardware;
import guisim.model.Parse;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class GuiSimService {
    //private final HardwareEvents events = new HardwareEvents();
    private final AtomRef events = new AtomRef();

    public Flight poll() {
        FromHardware next = events.get();
        Flight flight = new Flight();
        flight.roll = next.roll;
        flight.pitch = next.pitch;
        flight.yaw = next.yaw;
        System.out.println(" -- " + flight.roll + " --  ");
        return flight;
    }

    public void send(FromGuiObjects data, OutputStream device) throws IOException {
        //TODO: fix this

        byte[] outputData = new byte[24];
        System.arraycopy( data.roll.compactParse(),0,outputData,0,8);
        System.arraycopy( data.pitch.compactParse(),0,outputData,8,8);
        System.arraycopy( data.yaw.compactParse(),0,outputData,16,8);

        System.out.println(Arrays.toString(outputData));
        device.write(outputData);
    }
}
