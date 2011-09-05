package guisim.usb;

import java.io.IOException;
import java.io.OutputStream;

public class Output {
    private final OutputStream device;

    public Output(OutputStream device) {
        this.device = device;
    }

    public void main(byte[] data){
        try {
            device.write(data);
        } catch (IOException e) {
            e.printStackTrace();
            //error
        }
    }
}
