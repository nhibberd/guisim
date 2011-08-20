package guisim.testdata;

import guisim.json.Fred;

public class GuiSimTestService {
    Fred fred = new Fred();

    public Fred poll() {
        return fred;
    }

    //Set needs to store the entire fake data, separated by commas (1 2 3, 4 5 6, 2 4 6, 10 20 360)
    public void set(Fred data) {
        fred.pitch = data.pitch;
        fred.roll = data.roll;
        fred.yaw = data.yaw;
    }
    //Create bytes to send to GuiSimService
        //rework GuiSimService to setFred with threading



}
