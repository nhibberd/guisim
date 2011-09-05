package guisim.usb;

import java.io.IOException;
import java.io.OutputStream;

public class Output {
    public void main(byte[] data, OutputStream device){
        try {
            device.write(data);
        } catch (IOException e) {
            e.printStackTrace();
            //error
        }
    }
}
