package guisim.model;

public class FromHardware {
    public final short roll;
    public final short pitch;
    public final short yaw;

    public FromHardware(short roll, short pitch, short yaw) {
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
    }
}