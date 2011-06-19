package guisim.parse;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParseTest {
    Parse parse = new Parse();
    short one = 1;
    short negativeone = -1;

    @Test
    public void datapoint() {
        checkDatapoint(one, one, one, one, new byte[]{0x00, 0x01, 0x00, 0x01, 0x00, 0x01, 0x00, 0x01});
    }

    @Test
    public void parseShort() {
        checkParseShort(one, 0x00, 0x01);
        checkParseShort(negativeone, 0xff, 0xff);
    }

    private void checkParseShort(short s, int i, int i1) {

    }

    private void checkDatapoint(short degrees, short p, short i, short d, byte[] data) {
        DataPoint result = parse.datapoint(data);
        assertEquals(degrees, result.degrees);
        assertEquals(p, result.p);
        assertEquals(i, result.i);
        assertEquals(d, result.d);
    }
}
