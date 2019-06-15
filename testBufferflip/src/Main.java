import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        ByteBuffer buffer=ByteBuffer.allocate(88);
        String value="Netty权威指南";
        buffer.put(value.getBytes());
        buffer.flip();
        byte[] vArray=new byte[buffer.remaining()];
        buffer.get(vArray);
        String decodeValue=new String(vArray);
        System.out.println(decodeValue);
    }
}
