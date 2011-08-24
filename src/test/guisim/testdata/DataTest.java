package guisim.testdata;


import org.junit.Test;
import scala.runtime.Int;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DataTest {
    GuiSimTestService service = new GuiSimTestService();

    @Test
    public void stringToArray(){
        //call
        String[] testString = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        checkStringToArray(testString, "1 2 3, 4 5 6, 7 8 9");
    }

    private void checkStringToArray(String[] i, String s) {
        assertArrayEquals(i, service.read(s));
    }

}

