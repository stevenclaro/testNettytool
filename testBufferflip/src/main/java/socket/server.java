package socket;

import java.io.IOException;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.net.ServerSocket;
        import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);
        while (true) {
            Socket socket = ss.accept();
          //  new Thread(() -> {
                try {
                    //socket.setKeepAlive(true);

                    socket.setReceiveBufferSize(8 * 1024);
                    socket.setSendBufferSize(8 * 1024);
                    InputStream is = socket.getInputStream();
                    OutputStream os = socket.getOutputStream();
                    try {
                        byte[] bytes = new byte[1024];
                       // while (is.read(bytes) > -1) {
                            System.out.println(System.currentTimeMillis() + " received message: " + new String(bytes, "UTF-8").trim());
                            os.write("ok".getBytes("UTF-8"));
                            os.flush();
                        //    bytes = new byte[1024];
                        //}
                        try {
                            TimeUnit.SECONDS.sleep(3000000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (!socket.isInputShutdown()) {
                            socket.shutdownInput();
                        }
                        if (!socket.isOutputShutdown()) {
                            socket.shutdownOutput();
                        }
                        if (!socket.isClosed()) {
                            socket.close();
                        }
                        System.out.println("服务端进程已经结束");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
          //  }).start();
        }
    }
}