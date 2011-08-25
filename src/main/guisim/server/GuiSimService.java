package guisim.server;

import guisim.json.Flight;

import javax.xml.crypto.Data;
import java.util.Random;

public class GuiSimService {
    Flight fred = new Flight();

    public Flight poll() {
        //TODO: return fred from fake data, AtomicReference
        return fred;
    }

    //rework GuiSimService to setFred with threading, will be called by GuiSimTestService.
    public void set(Flight data) {
        fred.pitch = data.pitch;
        fred.roll = data.roll;
        fred.yaw = data.yaw;
    }
}
