package guisim.server;

import guisim.json.Flight;
import guisim.load.HardwareEvents;
import guisim.model.FromGui;
import guisim.model.FromHardware;
import guisim.model.Parse;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

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

    public void send(FromGui data, OutputStream device) throws IOException {
        Parse parse = new Parse();
        byte[] outputData = new byte[24];

        System.arraycopy(parse.parseToBytes( data.roll),0,outputData,0,2);
        System.arraycopy(parse.parseToBytes( data.RollP),0,outputData,2,2);
        System.arraycopy(parse.parseToBytes( data.RollI),0, outputData, 4, 2);
        System.arraycopy(parse.parseToBytes( data.RollD),0, outputData, 6, 2);
        System.arraycopy(parse.parseToBytes( data.pitch),0,outputData,8,2);
        System.arraycopy(parse.parseToBytes( data.PitchP),0,outputData,10,2);
        System.arraycopy(parse.parseToBytes( data.PitchI),0, outputData, 12, 2);
        System.arraycopy(parse.parseToBytes( data.PitchD),0, outputData, 14, 2);
        System.arraycopy(parse.parseToBytes( data.yaw),0,outputData,16,2);
        System.arraycopy(parse.parseToBytes( data.YawP),0,outputData, 18,2);
        System.arraycopy(parse.parseToBytes( data.YawI),0, outputData, 20, 2);
        System.arraycopy(parse.parseToBytes( data.YawD),0, outputData, 22, 2);

        System.out.println(outputData);
        System.out.println(Arrays.toString(outputData));
        device.write(outputData);
    }
}
