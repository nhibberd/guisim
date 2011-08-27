package guisim.server;

import guisim.json.Flight;
import guisim.load.HardwareEvents;
import guisim.model.FromHardware;
import sun.security.util.Cache;

import javax.xml.crypto.Data;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

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

    public void send(Flight flight) {
        // TODO send to hardware
    }
}
