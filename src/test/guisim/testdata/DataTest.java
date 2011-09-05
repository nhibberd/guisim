package guisim.testdata;


import guisim.model.Parse;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DataTest {
    Parse parse = new Parse();

    @Test
    public void shortToByte(){
        //call
        checkShortToByte((short) 1, (byte) 0x00, (byte) 0x01);
        checkShortToByte((short) -1, (byte) 0xff, (byte) 0xff);
        checkShortToByte((short) 20, (byte) 0x00, (byte) 0x14);
        checkShortToByte((short) 360, (byte) 0x01, (byte) 0x68);
    }

    private void checkShortToByte(short s, byte b1, byte b2) {
        assertArrayEquals(parse.parseToBytes(s), new byte[]{b1, b2} );
    }

}

