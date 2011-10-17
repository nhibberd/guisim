package guisim.model;

public class FromGuiObjects {
    public final FromGui r;
    public final FromGui p;
    public final FromGui y;

    public FromGuiObjects(FromGui roll, FromGui pitch, FromGui yaw) {
        this.r = roll;
        this.p = pitch;
        this.y = yaw;
    }
}