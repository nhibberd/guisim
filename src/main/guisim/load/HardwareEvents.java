package guisim.load;

import java.util.concurrent.atomic.AtomicReference;

import guisim.model.FromHardware;

public class HardwareEvents {
    private static final AtomicReference<FromHardware> events = new AtomicReference<FromHardware>();

    public void set(FromHardware data) {
        events.set(data);
    }
    public FromHardware get() {
        FromHardware result = events.get();
        return result != null ? result : new FromHardware((short) 0,(short) 0,(short) 0);
    }
}