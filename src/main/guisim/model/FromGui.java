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
        byte[] outputData = new byte[6];
        System.arraycopy(parse.parseToBytes( this.deg ),0,outputData,0,2);
        System.arraycopy(parse.parseToBytes( this.P ),0,outputData,2,2);
        System.arraycopy(parse.parseToBytes( this.I ),0, outputData, 4, 2);
        System.arraycopy(parse.parseToBytes( this.D ),0, outputData, 6, 2);
        return outputData;
    }
}