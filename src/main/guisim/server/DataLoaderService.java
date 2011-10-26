package guisim.server;

import guisim.json.Flight;
import guisim.load.SyntheticHardwareEvents;
import guisim.model.FromGuiObjects;
import guisim.model.FromHardware;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class DataLoaderService {
    private final SyntheticHardwareEvents hardwareEvents = new SyntheticHardwareEvents();
    private boolean done = false;

    public void readFile(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("test.txt"));
            String str;
            if (!done){
            System.out.println("Dataloader: reading local test file");
                while ((str = reader.readLine()) != null) {
                    for (String first : str.split(",")){
                        String[] second = first.trim().split(" ");
                        if (!(second[0].equals(""))){
                            short roll = Short.parseShort(second[0]);
                            short pitch = Short.parseShort(second[1]);
                            short yaw = Short.parseShort(second[2]);
                            FromHardware event = new FromHardware(roll, pitch, yaw);
                            hardwareEvents.put(event);
                        } else {
                            done = true;
                        }

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
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
