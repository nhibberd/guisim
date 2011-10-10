package guisim.model;

public class FromGui {
    public final short roll;
    public final short rollP;
    public final short rollI;
    public final short rollD;
    public final short pitch;
    public final short pitchP;
    public final short pitchI;
    public final short pitchD;
    public final short yaw;
    public final short yawP;
    public final short yawI;
    public final short yawD;

    //TODO: change to a nest object, client and server side { Roll, pitch, yaw } each with {de, p, i, d }

    public FromGui(short roll, short rollP, short rollI, short rollD, short pitch, short pitchP, short pitchI,
                   short pitchD, short yaw, short yawP, short yawI, short yawD) {
        this.roll = roll;
        this.rollP = rollP;
        this.rollI = rollI;
        this.rollD = rollD;
        this.pitch = pitch;
        this.pitchP = pitchP;
        this.pitchI = pitchI;
        this.pitchD = pitchD;
        this.yaw = yaw;
        this.yawP = yawP;
        this.yawI = yawI;
        this.yawD = yawD;
    }
}
