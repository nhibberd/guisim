package guisim.server;

import guisim.json.Flight;
import guisim.load.SyntheticHardwareEvents;
import guisim.model.FromGuiObjects;
import guisim.model.FromHardware;

public class DataLoaderService {
    private final SyntheticHardwareEvents hardwareEvents = new SyntheticHardwareEvents();

    //public void store(String data) {
    public void store(FromGuiObjects data) {
        //TODO: redo
        //for text area
        /*for (String first : data.split(",")){
            String[] second = first.split(" ");
            short roll = Short.parseShort(second[0]);
            short pitch = Short.parseShort(second[1]);
            short yaw = Short.parseShort(second[2]);
            FromHardware event = new FromHardware(roll, pitch, yaw);
            hardwareEvents.put(event);
        }  */
        FromHardware event = new FromHardware(data.roll.deg, data.pitch.deg, data.yaw.deg);
        hardwareEvents.put(event);

    }

    public Flight poll() {
        FromHardware next = hardwareEvents.next();
        Flight flight = new Flight();
        flight.roll = next.roll;
        flight.pitch = next.pitch;
        flight.yaw = next.yaw;
        return flight;
    }
}
