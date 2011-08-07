package guisim.server;

import guisim.json.Fred;

import java.util.Random;

public class GuiSimService {
    Random r = new Random();

    public Fred poll() {
        Fred fred = new Fred();
        fred.pitch = r.nextInt();
        fred.roll = r.nextInt();
        fred.yaw = r.nextInt();
        return fred;
    }
}
