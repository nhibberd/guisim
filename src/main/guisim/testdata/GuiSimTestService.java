package guisim.testdata;

import guisim.json.Fred;
import scalaz.O;

public class GuiSimTestService {
    Fred fred = new Fred();

    public Fred poll() {
        //Seperate data structure to individual fred objects.
        //Remove the current object, create a new object using the next block of data from the fake data

        return fred;
    }

    //Set needs to store the entire fake data, separated by commas (1 2 3, 4 5 6, 2 4 6, 10 20 360)
    public void store(Fred data) {
        fred.pitch = data.pitch;
        fred.roll = data.roll;
        fred.yaw = data.yaw;

    }

    public void read(String data){
        /* Create an array for each block of numbers, each array element with 3 sub-elements? */
        String[] data2 = data.split(",");
        String[] test = {""};
        for (int i = 0; i < data2.length; i++){
            String[] he = data2[i].split(" ");
            for (int q = 0; q < he.length; i++){
                test[q] = he[q];
            }
        }

    }


    //Create bytes to send to GuiSimService
        //rework GuiSimService to setFred with threading
    /*
    ret[0] = (byte)(x & 0xff);
    ret[1] = (byte)((x >> 8) & 0xff);
    */
    public static byte[] toBytes(short s)
    {
        return new byte[]{(byte)(s & 0x00FF),(byte)((s & 0xFF00)>>8)};
    }


}
