package guisim.load;

import guisim.model.FromHardware;
import guisim.model.Parse;
import scalaz.Input;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class HardwareLoader implements Runnable {
   private final HardwareEvents hardwareEvents = new HardwareEvents();
   private final InputStream device;
   private final byte[] workingBuffer = new byte[6];
   private int workingLength = 0;
   private final byte[] readBuffer = new byte[6];
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
           // copy the left over read bytes into the working buffer
           /*if (newLength  < readLength) {
             workingLength = readLength - newLength;
             System.arraycopy(readBuffer, newLength, workingBuffer, 0, newLength);
          } */
       }
   }

    private void process(byte[] bytes) {
        System.out.println(Arrays.toString(bytes));
        Parse parser = new Parse();
        short roll = parser.parseToShort(bytes[0], bytes[1]);
        short pitch = parser.parseToShort(bytes[2], bytes[3]);
        short yaw = parser.parseToShort(bytes[4], bytes[5]);
        FromHardware event = new FromHardware(roll, pitch, yaw);
        hardwareEvents.put(event);
    }

    private int read(byte[] buffer) {
        try {
            return device.read(buffer,0,workingBuffer.length-workingLength);
        } catch (IOException e) {
            return -1; // terminate if we can't read from device, and log
        }
    }
}