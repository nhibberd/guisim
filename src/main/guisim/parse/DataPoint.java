package guisim.parse;

public class DataPoint {
    public final short degrees;
    public final short p;
    public final short i;
    public final short d;

    public DataPoint(short degrees, short p, short i, short d) {
        this.degrees = degrees;
        this.p = p;
        this.i = i;
        this.d = d;
    }
}
