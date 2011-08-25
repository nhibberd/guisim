package guisim.server;

import guisim.json.Fred;
import scala.runtime.Int;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

public class DataLoaderService {
    //Fred fred = new Fred();
    LinkedList<Fred> DataList = new LinkedList<Fred>();

    public void haha() {
        boolean test = true;
        while(test) {
            //wait 200ms?
            Fred data = poll();
            byte[] roll = toBytes((short) data.roll);
            byte[] pitch =  toBytes((short) data.pitch);
            byte[] yaw =  toBytes((short) data.yaw);

            /*
            AtomicReference he = new AtomicReference();
            he.set(data);
            */
        }
        //TODO: convert to bytes, and pass to GuiSimServlet (AtomicReference)
    }

    public Fred poll() {
        return DataList.poll(); //Retrieves and removes object
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
        haha();
    }

    public byte[] toBytes(short s)
    {
        byte b1 = (byte) (s >>> 8);
        byte b2 = (byte) (s & 0xFF);
        return new byte[] { b1, b2 };
    }
}
