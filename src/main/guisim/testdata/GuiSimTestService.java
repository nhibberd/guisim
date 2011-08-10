package guisim.testdata;

import guisim.json.Fred;

public class GuiSimTestService {
    Fred fred = new Fred();

    public Fred poll() {
        return fred;
    }

    public void set(Fred data) {
        fred.pitch = data.pitch;
        fred.roll = data.roll;
        fred.yaw = data.yaw;
    }
}
