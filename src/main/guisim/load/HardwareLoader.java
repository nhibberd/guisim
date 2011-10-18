package guisim.load;

import guisim.model.FromHardware;
import guisim.model.Parse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class HardwareLoader implements Runnable {
   //private final HardwareEvents hardwareEvents = new HardwareEvents();
   private final HardwareEvents hardwareEvents = new HardwareEvents();
   private final InputStream device;
   private final byte[] workingBuffer = new byte[8];      //TODO:added check now 8 bytes
   private int workingLength = 0;
   private final byte[] readBuffer = new byte[8];
   private int readLength = 0;


   public HardwareLoader(InputStream device) {
       this.device = device;
   }

   public void run() {
       for(;;) {
           readLength = read(readBuffer);

           if (readLength < 0)
               return;

           int newLength = Math.min(workingBuffer.length - workingLength, readLength);
           System.arraycopy(readBuffer, 0, workingBuffer, workingLength, newLength);
           workingLength += newLength;

           if (workingLength == workingBuffer.length){
               process(workingBuffer);
               workingLength = 0;
          }
       }
   }

    private void process(byte[] bytes) {
        System.out.println(Arrays.toString(bytes));
        Parse parser = new Parse();
        short zero = 0;
        FromHardware event = new FromHardware(zero, zero, zero);

        //FromHardware event = parser.datapointFromHardware(bytes);


        //TODO: for testing
        short check = parser.parseToShort(bytes[0], bytes[1]);
        System.out.println(check);
        if (check == 65535 ){
            short roll = parser.parseToShort(bytes[2], bytes[3]);
            short pitch = parser.parseToShort(bytes[4], bytes[5]);
            short yaw = parser.parseToShort(bytes[6], bytes[7]);
            System.out.println(roll);
            System.out.println(pitch);
            System.out.println(yaw);
            event = new FromHardware(roll, pitch, yaw);
        }
        hardwareEvents.set(event);
    }

    private int read(byte[] buffer) {
        try {
            return device.read(buffer,0,workingBuffer.length-workingLength);
        } catch (IOException e) {
            return -1; // terminate if we can't read from device, and log
        }
    }
}