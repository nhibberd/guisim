package guisim.load;

import guisim.json.Flight;
import guisim.server.ServerException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HardwareEvents {
    // This is static so that there is only ever one set of flights shared between everything.
    private static final BlockingQueue<Flight> flights = new LinkedBlockingQueue<Flight>();

    public void put(Flight f) {
        try {
            flights.put(f);
        } catch (InterruptedException e) {
            throw new ServerException(e);
        }
    }

    public Flight next() {
        try {
            return flights.take();
        } catch (InterruptedException e) {
            throw new ServerException(e);
        }
    }
}
