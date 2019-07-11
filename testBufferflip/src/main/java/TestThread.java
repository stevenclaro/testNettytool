import java.util.Random;
import java.util.concurrent.*;

public class TestThread {
/*---------------------
    作者：独行客-编码爱好者
    来源：CSDN
    原文：https://blog.csdn.net/donkeyboy001/article/details/86894107
    版权声明：本文为博主原创文章，转载请附上博文链接！
    */
public static void main(String[] args) {

        //创建线程池
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        //声明执行结果
        ScheduledFuture<Integer> furture=null;

        try {
            for (int i = 0; i <20; i++) {
                ScheduledFuture result = service.schedule(new Callable(){

                    @Override
                    public Object call() throws Exception {
                        System.out.println(Thread.currentThread().getName());
                        return new Random().nextInt(100);
                    }

                }, 3, TimeUnit.SECONDS);
                //每执行一次就打印一次结果，此结果就是线程的执行结果
                System.err.println(result.get());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //关闭线程池
            service.shutdown();
        }
    }
}

