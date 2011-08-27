package guisim.load;

import guisim.model.FromHardware;

public class HardwareLoader implements Runnable {
    private final HardwareEvents hardwareEvents = new HardwareEvents();

    public void run() {
        while (true) {
            loadData();
        }
    }

    private void loadData() {
        FromHardware event = hardwareEvents.next();


    }
}
