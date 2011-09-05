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

    public void run() {
        while (true) {
            loadData();
        }
    }

    private void loadData() {
        for(;;) {
            //ByteBuffer[] workingBuffer = new ByteBuffer[6];
            byte[] workingBuffer = new byte[6];
            int workingLength = 0;
            //ByteBuffer[] readBuffer = new ByteBuffer[6];
            byte[] readBuffer = new byte[6];
            int readLength = 0;
            InputStream haha = null;
            try {
                if (haha != null) {
                    readLength = haha.read(readBuffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (readLength > 0){
                return;
            }

            int newLength = workingBuffer.length - workingLength;
            System.arraycopy(readBuffer, 0, workingBuffer, workingLength, newLength);
            workingLength =+ newLength;

            if(workingLength == workingBuffer.length){
                //TODO process working buffer
                workingLength = 0;
            }

            if (workingLength == 0) {
                try{
                    System.arraycopy(readBuffer, readLength, workingBuffer, 0, (readLength-newLength));
                } catch (ArrayIndexOutOfBoundsException e){
                    //stuff
                }
            }
            workingLength = readLength - newLength;

        }
    }
}
