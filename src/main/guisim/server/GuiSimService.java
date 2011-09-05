package guisim.server;

import guisim.json.Flight;
import guisim.load.HardwareEvents;
import guisim.model.FromHardware;
import guisim.model.Parse;

import java.io.IOException;
import java.io.OutputStream;

public class GuiSimService {
    private final HardwareEvents events = new HardwareEvents();

    public Flight poll() {
        FromHardware next = events.next();
        Flight flight = new Flight();
        flight.roll = next.roll;
        flight.pitch = next.pitch;
        flight.yaw = next.yaw;
        return flight;
    }

    public void send(Flight data, OutputStream device) throws IOException {
        Parse parse = new Parse();
        byte[] outputData = new byte[6];
        System.arraycopy(parse.parseToBytes((short) data.roll),0,outputData,0,2);
        System.arraycopy(parse.parseToBytes((short) data.pitch),0,outputData,2,2);
        System.arraycopy(parse.parseToBytes((short) data.yaw), 0, outputData, 4, 2);
        device.write(outputData);
    }
}
