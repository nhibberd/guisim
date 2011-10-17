package guisim.model;

public class FromGui {
    public final short deg;
    public final short P;
    public final short I;
    public final short D;

    public FromGui(short deg, short P, short I, short D ) {
        this.deg = deg;
        this.P = P;
        this.I = I;
        this.D = D;
    }

    public byte[] compactParse (){
        Parse parse = new Parse();
        parse.datapointFromGui(this);
        return parse.datapointFromGui(this);
    }
}