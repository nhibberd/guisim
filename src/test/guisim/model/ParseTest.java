package guisim.model;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParseTest {
    Parse parse = new Parse();
    short one = 1;
    short negativeone = -1;
    short twenty = 20;


    @Test
    public void datapointFromGui() {
        checkDatapointFromGui(one, one, one, one, new byte[]{0x00, 0x01, 0x00, 0x01, 0x00, 0x01, 0x00, 0x01});
        checkDatapointFromGui(negativeone, negativeone, negativeone, negativeone, new byte[]{(byte) 0xff,
                (byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff});
        checkDatapointFromGui(twenty, twenty, twenty, twenty, new byte[]{(byte) 0x00, (byte) 0x14,
                (byte) 0x00, (byte) 0x14,(byte) 0x00, (byte) 0x14,(byte) 0x00, (byte) 0x14});
    }

    @Test
    public void parseShort() {
        checkParseShort(one, 0x00, 0x01);
        checkParseShort(negativeone, 0xff, 0xff);
        checkParseShort(twenty, 0x00, 0x14);
        checkParseShort((short) 100, 0x00, 0x64);
    //    checkParseShort((short) 255, 0x00, 0xFF);
        checkParseShort((short) 256, 0x01, 0x00);
        checkParseShort((short) 360, 0x01, 0x68);
    //    checkParseShort((short) 360, 0xFE, 0x97);
    }

    @Test
    public void shortToByte(){
        checkShortToByte((short) 1, (byte) 0x00, (byte) 0x01);
        checkShortToByte((short) -1, (byte) 0xff, (byte) 0xff);
        checkShortToByte((short) 20, (byte) 0x00, (byte) 0x14);
        checkShortToByte((short) 360, (byte) 0x01, (byte) 0x68);
       // checkShortToByte((short) 360, (byte) 0xFE, (byte) 0x97);
    }

    @Test
    public void parser(){
        checkParser(one);
        checkParser(negativeone);
        checkParser(twenty);
        checkParser((short) -20);
        checkParser((short) 255);
        checkParser((short) 256);
        checkParser((short) 360);
    }

    @Test
    public void parser2(){
        checkParser2((byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00);
        checkParser2((byte) 0x00,(byte) 0x01,(byte) 0x00,(byte) 0x01);
        checkParser2((byte) 0x00,(byte) 0x14,(byte) 0x00, (byte) 0x14);
        checkParser2((byte) 0x00,(byte) 0x14,(byte) 0x00, (byte) 0x14);
        checkParser2((byte) 0x01,(byte) 0x00,(byte) 0x01, (byte) 0x00);
        checkParser2((byte) 0x01,(byte) 0x68,(byte) 0x01,(byte) 0x68);
        checkParser2((byte) 0xFF,(byte) 0xFF,(byte) 0xFF,(byte) 0xFF);
    }

    private void checkParseShort(short s, int i, int i1) {
        assertEquals(s, parse.parseToShort((byte) i, (byte) i1));
    }

    private void checkDatapointFromGui(short degrees, short p, short i, short d, byte[] data) {
        FromGui test = new FromGui(degrees, p, i, d);
        assertArrayEquals(parse.datapointFromGui(test), data);
    }

    private void checkShortToByte(short s, byte b1, byte b2) {
        assertArrayEquals(parse.parseToBytes(s), new byte[]{b1, b2} );
    }

    private void checkParser(short s) {
        byte[] z = parse.parseToBytes(s);
        assertEquals(s, parse.parseToShort( z[0], z[1]));
    }

    private void checkParser2(byte a,byte b,byte c,byte d) {
        assertArrayEquals( new byte[] { c, d }, parse.parseToBytes(parse.parseToShort(a,b)));
    }
}
