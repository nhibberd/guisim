package guisim.server;

import guisim.json.Flight;
import guisim.load.HardwareEvents;
import guisim.model.FromGuiObjects;
import guisim.model.FromHardware;
import guisim.usb.Output;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class GuiSimService {
    private final HardwareEvents events = new HardwareEvents();

    public Flight poll() {
        Flight flight = new Flight();
        FromHardware next = events.get();
        flight.roll = next.roll;
        flight.pitch = next.pitch;
        flight.yaw = next.yaw;
        return flight;
    }

    public void send(FromGuiObjects data, OutputStream output) throws IOException {
        byte[] outputData = new byte[24];
        System.arraycopy( data.roll.compactParse(),0,outputData,0,8);
        System.arraycopy( data.pitch.compactParse(),0,outputData,8,8);
        System.arraycopy( data.yaw.compactParse(),0,outputData,16,8);
        System.out.println(Arrays.toString(outputData));
        output.write(outputData);
    }
}
