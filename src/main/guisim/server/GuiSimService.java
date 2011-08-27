package guisim.server;

import guisim.json.Flight;
import sun.security.util.Cache;

import javax.xml.crypto.Data;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class GuiSimService {
    Flight fred = new Flight();
    AtomicReference<Flight> cache = new AtomicReference<Flight>();

    public Flight poll() {
        //TODO: return fred from fake data, AtomicReference
        //cache.get();
        return cache.get();
    }

    //rework GuiSimService to setFred with threading, will be called by GuiSimTestService.
    public void set(Flight data) {
        fred.pitch = data.pitch;
        fred.roll = data.roll;
        fred.yaw = data.yaw;
    }
}
