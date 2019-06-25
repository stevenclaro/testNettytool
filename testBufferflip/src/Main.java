import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

/*
* 该代码测试了申请缓存
* 进行编码
* 放入到缓存
* 然后读出
* 然后进行解码（String类型的解码）
* 没有测试的内容
*   将编码后的内容进行网络传送，
*   释放缓存
* */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        //先分配一个缓冲区
        /*ByteBuffer buffer=ByteBuffer.allocate(1);*/
        ByteBuffer buffer=ByteBuffer.allocate(88);
        String value="Netty权威指南";
        //对该缓冲区进行赋值
        /*value.getBytes()是对输入的编码，因为是string，所以编码很简单，直接就是getBytes（），有一些编码是比较复杂的，如POJO编码。主要就是要
                编为Byte，然后放入到缓冲区
        */
        //需要注意的是，。如果缓存区剩余可写空间不够， 就会发生BufferOverflowException
        //为了避免发生这个问题，通常在进行put的时候会对剩余可用空间进行校验.
        try
        {
             buffer.put(value.getBytes());
        }
        catch (BufferOverflowException ex)
        {
            ex.printStackTrace();
        }
        finally {

        }
        System.out.println("buffer被写入的内容为:"+value.getBytes()+"buffer被写入的尺寸为"+value.getBytes().length+"buffer剩余的尺寸为"+(buffer.capacity()-buffer.position()));
        System.out.println("当前的postion位置:"+buffer.position());
        System.out.println("当前的limit位置:"+buffer.limit());
        System.out.println("当前的Capacity:"+buffer.capacity());
        System.out.println("当前的buffer.remaining:"+buffer.remaining());
        buffer.flip();
        System.out.println("执行flip之后，当前的postion位置:"+buffer.position());
        System.out.println("执行flip之后，当前的limit位置:"+buffer.limit());
        System.out.println("执行flip之后，当前的Capacity:"+buffer.capacity());
        System.out.println("执行flip之后,当前的buffer.remaining:"+buffer.remaining());
        //remaining() 返回 limit - position
        byte[] vArray=new byte[buffer.remaining()];

        buffer.get(vArray);
        //得到这个缓存区，然后进行解码，这个是比较简单的String解码，也可以比较复杂的解码
        String decodeValue=new String(vArray);
        //这个时候，并没有释放buffer，这个如果积压，可能会带来内存泄漏。
        //也没有释放vArray。但是这个可以被JVM的GC来释放。如果全部依赖GC，也有可能在高性能情况下，会出现GC的老生代负荷太大导出服务器不可用
        System.out.println(decodeValue);
    }
}
