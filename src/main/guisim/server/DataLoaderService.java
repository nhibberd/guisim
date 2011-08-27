package guisim.server;

import guisim.json.Flight;
import guisim.load.HardwareEvents;
import guisim.model.FromHardware;

public class DataLoaderService {
    private final HardwareEvents hardwareEvents = new HardwareEvents();

    public void store(String data) {
        for (String first : data.split(",")){
            String[] second = first.split(" ");
            short roll = Short.parseShort(second[0]);
            short pitch = Short.parseShort(second[1]);
            short yaw = Short.parseShort(second[2]);
            FromHardware event = new FromHardware(roll, pitch, yaw);
            hardwareEvents.put(event);
        }
    }
}
