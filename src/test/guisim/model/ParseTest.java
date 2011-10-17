package guisim.model;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParseTest {
    Parse parse = new Parse();
    short one = 1;
    short negativeone = -1;
    short twenty = 20;

    /*@Test
    public void datapoint() {
        checkDatapoint(one, one, one, one, new byte[]{0x00, 0x01, 0x00, 0x01, 0x00, 0x01, 0x00, 0x01});
    }  */

    @Test
    public void parseShort() {
        checkParseShort(one, 0x00, 0x01);
        checkParseShort(negativeone, 0xff, 0xff);
        checkParseShort(twenty, 0x00, 0x14);
        //checkParseShort((short) -360, 0xFC, 0x98);
        checkParseShort((short) 360, 0xFE, 0x97);
    }

    @Test
    public void shortToByte(){
        checkShortToByte((short) 1, (byte) 0x00, (byte) 0x01);
        checkShortToByte((short) -1, (byte) 0xff, (byte) 0xff);
        checkShortToByte((short) 20, (byte) 0x00, (byte) 0x14);
        checkShortToByte((short) 360, (byte) 0x01, (byte) 0x68);
    }

    private void checkParseShort(short s, int i, int i1) {
        assertEquals(s, parse.parseToShort((byte) i, (byte) i1));
    }

    /*private void checkDatapoint(short degrees, short p, short i, short d, byte[] data) {
        FromGui result = parse.datapoint(data);
        assertEquals(degrees, result.degrees);
        assertEquals(p, result.p);
        assertEquals(i, result.i);
        assertEquals(d, result.d);
    }    */

    private void checkShortToByte(short s, byte b1, byte b2) {
        assertArrayEquals(parse.parseToBytes(s), new byte[]{b1, b2} );
    }
}
