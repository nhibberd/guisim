package guisim.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParseTest {
    Parse parse = new Parse();
    short one = 1;
    short negativeone = -1;
    short twenty = 20;

    @Test
    public void datapoint() {
        checkDatapoint(one, one, one, one, new byte[]{0x00, 0x01, 0x00, 0x01, 0x00, 0x01, 0x00, 0x01});
    }

    @Test
    public void parseShort() {
        checkParseShort(one, 0x00, 0x01);
        checkParseShort(negativeone, 0xff, 0xff);
        checkParseShort(twenty, 0x00, 0x14);
        checkParseShort((short) -360, 0xFC, 0x98);
    }

    private void checkParseShort(short s, int i, int i1) {
        assertEquals(s, parse.parseToShort((byte) i, (byte) i1));
    }

    private void checkDatapoint(short degrees, short p, short i, short d, byte[] data) {
        FromGui result = parse.datapoint(data);
        assertEquals(degrees, result.degrees);
        assertEquals(p, result.p);
        assertEquals(i, result.i);
        assertEquals(d, result.d);
    }
}
