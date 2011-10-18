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
    //private final HardwareEvents events = new HardwareEvents();
    private final HardwareEvents events = new HardwareEvents();
    private final Flight error = new Flight();

    public Flight poll() {
        Flight flight = new Flight();
        if (error.pitch != 666) {
            FromHardware next = events.get();
            flight.roll = next.roll;
            flight.pitch = next.pitch;
            flight.yaw = next.yaw;
            return flight;
        } else if ( error != null) {
            return error;
        }
        return flight;
    }

    public void error() {
        error.roll = 666;
        error.pitch = 666;
        error.yaw = 666;
    }

    //public void send(FromGuiObjects data, Output output) throws IOException {
    public void send(FromGuiObjects data, OutputStream output) throws IOException {
        //TODO: fix this

        byte[] outputData = new byte[24];
        System.arraycopy( data.roll.compactParse(),0,outputData,0,8);
        System.arraycopy( data.pitch.compactParse(),0,outputData,8,8);
        System.arraycopy( data.yaw.compactParse(),0,outputData,16,8);

        System.out.println(Arrays.toString(outputData));
        output.write(outputData);
    }
}
