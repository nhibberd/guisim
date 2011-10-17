package guisim.model;

public class Parse {
    /*public FromGui datapoint(byte[] data) {
        if (data.length != 8)
            throw new IllegalArgumentException("Invalid length, datapoint must be 8 bytes");
        short degrees = parseToShort(data[0], data[1]);
        short p = parseToShort(data[2], data[3]);
        short i = parseToShort(data[4], data[5]);
        short d = parseToShort(data[6], data[7]);
        return new FromGui(degrees, p, i, d);
    } */

    public FromHardware datapointFromHardware(byte[] data) {
        if (data.length != 8)
            throw new IllegalArgumentException("Invalid length, datapoint must be 8 bytes");
        short roll = parseToShort(data[0], data[1]);
        short pitch = parseToShort(data[2], data[3]);
        short yaw = parseToShort(data[4], data[5]);
        return new FromHardware(roll, pitch, yaw);
    }

    //TODO: parse >156 digit
    public short parseToShort(byte b1, byte b2) {
        return (short) ((b1 << 8) | b2);
    }

    public byte[] parseToBytes(short s) {
        byte b1 = (byte) (s >>> 8);
        byte b2 = (byte) (s & 0xFF);
        return new byte[] { b1, b2 };
    }
}
