package guisim.load;

import guisim.model.FromHardware;
import scalaz.Input;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;

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
           // read as much as we can handle
           readLength = read(readBuffer);

           // if input stream has closed, we have lost connection to
//device and must shutdown.
           if (readLength < 0)
               return;

           // how much can we use right now? fill up working buffer
//as much as possible
           int newLength = Math.min(workingBuffer.length - workingLength, readLength);
           System.arraycopy(readBuffer, 0, workingBuffer, workingLength, newLength);
           workingLength += newLength;

           // if working buffer is full, process it and clear for reuse.
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
        //TODO process working buffer
    }

    private int read(byte[] buffer) {
        try {
            return device.read(buffer,0,workingBuffer.length-workingLength);
        } catch (IOException e) {
            return -1; // terminate if we can't read from device,
//probably should log as well.

        }
    }
}