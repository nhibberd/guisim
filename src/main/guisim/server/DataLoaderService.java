package guisim.server;

import guisim.json.Flight;
import scala.runtime.Int;
import sun.security.util.Cache;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

public class DataLoaderService {
    LinkedList<Flight> DataList = new LinkedList<Flight>();

    private AtomicReference<Flight> stats = new AtomicReference<Flight>(new Flight());

    public void haha() {
        boolean test = false;
        while(!test) {
            //wait 200ms?
            Flight data = DataList.poll();
            byte[] roll = toBytes((short) data.roll);
            byte[] pitch =  toBytes((short) data.pitch);
            byte[] yaw =  toBytes((short) data.yaw);
            //byte[] foo = {roll, pitch, yaw};

            /*
            AtomicReference he = new AtomicReference(foo);
            he.set(data);
            */
        }
        //TODO: convert to bytes, and pass to GuiSimServlet (AtomicReference)
        //new AtomicReference<Flight>.set(Flight );
    }

    public Flight poll() {
        return DataList.poll(); //Retrieves and removes object
    }

    public void store(String data) {
        for (String first : data.split(",")){
            String[] second = first.split(" ");
            Flight fred = new Flight();
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
