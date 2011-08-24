package guisim.server;

import guisim.json.Fred;

public class DataLoaderService {
    Fred fred = new Fred();

    public Fred poll() {
        //TODO: pop? the first 3 elements of return from read()
            //create new string and run through the process again or pop from string[]?
            /*
                public static String removeCharAt(String s, int pos) {
                   return s.substring(0,pos)+s.substring(pos+1);
                }
             */

        return fred;


        //TODO: convert to bytes, and pass to GuiSimServlet (AtomicReference)

    }

    public void store(String data) {
        String[] input = read(data);
        //TODO: Split the input into fred objects
        fred.pitch = Integer.parseInt(input[0]);
        fred.roll = Integer.parseInt(input[1]);
        fred.yaw = Integer.parseInt(input[2]);

        //TODO: Start polling

    }

    public String[] read(String data){
        String[] data2 = data.split(",");
        String[] he = {""};
        for (int i = 0; i < data2.length; i++){
            String[] hehe = data2[i].split(" ");
            he[i] = hehe[i];
        }
        return he;
    }

    /*
    ret[0] = (byte)(x & 0xff);
    ret[1] = (byte)((x >> 8) & 0xff);
    */
    public static byte[] toBytes(short s)
    {
        return new byte[]{(byte)(s & 0x00FF),(byte)((s & 0xFF00)>>8)};

    }
}
