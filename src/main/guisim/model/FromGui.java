package guisim.model;

public class FromGui {
    public final short degrees;
    public final short p;
    public final short i;
    public final short d;

    //doing some random bs test
    public short roll;
    public short RollP;
    public short RollI;
    public short RollD;
    public short pitch;
    public short PitchP;
    public short PitchI;
    public short PitchD;
    public short yaw;
    public short YawP;
    public short YawI;
    public short YawD;

    public FromGui(short degrees, short p, short i, short d) {
        this.degrees = degrees;
        this.p = p;
        this.i = i;
        this.d = d;
    }
}
