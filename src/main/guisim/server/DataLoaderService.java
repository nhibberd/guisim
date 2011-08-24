package guisim.server;

import guisim.json.Fred;

import java.util.LinkedList;

public class DataLoaderService {
    //Fred fred = new Fred();
    LinkedList<Fred> DataList = new LinkedList<Fred>();

    public Fred poll() {
        return DataList.poll();

        //TODO: convert to bytes, and pass to GuiSimServlet (AtomicReference)

    }

    public void store(String data) {
        for (String first : data.split(",")){
            String[] second = first.split(" ");
            Fred fred = new Fred();
            fred.pitch = Integer.parseInt(second[0]);
            fred.roll = Integer.parseInt(second[1]);
            fred.yaw = Integer.parseInt(second[2]);
            DataList.add(fred);
        }
    }


    /*
    ret[0] = (byte)(x & 0xff);
    ret[1] = (byte)((x >> 8) & 0xff);
    */
    public byte[] toBytes(short s)
    {
        byte b1 = (byte) (s >>> 8);
        byte b2 = (byte) (s & 0xFF);
        return new byte[] { b1, b2 };
    }
}
