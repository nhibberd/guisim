package guisim.model;

import javax.swing.plaf.basic.BasicBorders;

public class Parse {
    public FromGui datapoint(byte[] data) {
        if (data.length != 8)
            throw new IllegalArgumentException("Invalid length, datapoint must be 8 bytes");
        short degrees = parseShort(data[0], data[1]);
        short p = parseShort(data[2], data[3]);
        short i = parseShort(data[4], data[5]);
        short d = parseShort(data[6], data[7]);
        return new FromGui(degrees, p, i, d);
    }

    public FromHardware datapointFromHardware(byte[] data) {
        if (data.length != 8)
            throw new IllegalArgumentException("Invalid length, datapoint must be 8 bytes");
        short roll = parseShort(data[0], data[1]);
        short pitch = parseShort(data[2], data[3]);
        short yaw = parseShort(data[4], data[5]);
        return new FromHardware(roll, pitch, yaw);
    }

    public short parseShort(byte b1, byte b2) {
        return (short) ((b1 << 8) | b2);
    }

    public byte[] toBytes(short s) {
        byte b1 = (byte) (s >>> 8);
        byte b2 = (byte) (s & 0xFF);
        return new byte[] { b1, b2 };
    }
}
