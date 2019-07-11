import java.io.UnsupportedEncodingException;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import  java.io.BufferedInputStream;
public class testByte2String {
    /*---------------------
        作者：独行客-编码爱好者
        来源：CSDN
        原文：https://blog.csdn.net/donkeyboy001/article/details/86894107
        版权声明：本文为博主原创文章，转载请附上博文链接！
        网络传输时，Java中byte[]转String问题
        */
    public static void main(String[] args) {
        byte bytes[] = new byte[]{50, 0, -1, 28, -24};
        String string = new String(bytes);
        byte[] ret = string.getBytes();

        String isoString;
        byte[] isoret = null;
        try {
            isoString = new String(bytes, "ISO-8859-1");
            isoret = isoString.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(System.getProperty("file.encoding"));
        System.out.println(ret);
        System.out.println(isoret);
      /*  ---------------------
                作者：hjxgood
        来源：CSDN
        原文：https://blog.csdn.net/hjxgood/article/details/20057989
        版权声明：本文为博主原创文章，转载请附上博文链接！
    }*/
    }
}

