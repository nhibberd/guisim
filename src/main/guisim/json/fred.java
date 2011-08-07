package guisim.json;

public class Fred {
    public int yaw = 0;
    public int pitch = 5;
    public int roll = 20;

    public String toString() {
        return "Fred[\n" +
               "  yaw = " + yaw + "\n" +
               "  pitch = " + pitch + "\n" +
               "  roll = " + roll + "\n" +
               "]";
    }
}
