package guisim.server;

import guisim.json.Fred;

import javax.xml.crypto.Data;
import java.util.Random;

public class GuiSimService {
    Fred fred = new Fred();

    public Fred poll() {
        return fred;
    }

    //rework GuiSimService to setFred with threading, will be called by GuiSimTestService.
    public void set(Fred data) {
        fred.pitch = data.pitch;
        fred.roll = data.roll;
        fred.yaw = data.yaw;
    }
}
