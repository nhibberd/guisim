package guisim.load;

import guisim.model.FromHardware;
import guisim.server.ServerException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SyntheticHardwareEvents {
    // This is static so that there is only ever one set of events shared between everything.
    private static final BlockingQueue<FromHardware> events = new LinkedBlockingQueue<FromHardware>();

    public void put(FromHardware f) {
        try {
            events.put(f);
        } catch (InterruptedException e) {
            throw new ServerException(e);
        }
    }

    public FromHardware next() {
        try {
            return events.take();
        } catch (InterruptedException e) {
            throw new ServerException(e);
        }
    }
}
