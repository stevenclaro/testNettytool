import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
//该代码测试线程名称的使用
public class TestThreadSchedule {
    public static void main(String[] args) {
        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(10);
            for(int i=0;i<=100000000;i++) {
               ScheduledFuture<?> future = executor.schedule(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread().getName() + "Now it is 1 seconds later");
                        }
                    }, 1, TimeUnit.SECONDS);
            //...
            }
        executor.shutdown();
    }
}