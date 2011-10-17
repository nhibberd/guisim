package guisim.model;

public class FromGuiObjects {
    public final FromGui roll;
    public final FromGui pitch;
    public final FromGui yaw;

    public FromGuiObjects(FromGui roll, FromGui pitch, FromGui yaw) {
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
    }
}