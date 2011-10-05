package guisim.load;

import java.util.concurrent.atomic.AtomicReference;
import guisim.model.FromHardware;
import guisim.server.ServerException;

public class AtomRef {
    private static final AtomicReference<FromHardware> events = new AtomicReference<FromHardware>();

    public void set(FromHardware f) {
        events.set(f);
    }
    public FromHardware get() {
        //return events.get();
        try {
            return events.get();
        } catch (NullPointerException e) {
            throw new ServerException(e);
        }
    }
}