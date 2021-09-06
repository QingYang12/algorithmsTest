package test.test.test6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/*
* CountDownLatch是一个同步工具类
* ，它允许一个或多个线程一直等待，直到其他线程执行完后再执行。
*
* 例如，应用程序的主线程希望在负责启动框架服务的线程已经启动所有框架服务之后执行
 */
public class Test10 {
    public static void main(String[] args) {
        try {
            CountDownLatch countdown=new CountDownLatch(7);
            AtomicInteger s=new AtomicInteger(7);
            while(true){
                if( s.get()>=0){
                    new Thread(()->{
                        System.out.println(" 线程"+s.get()+"被创建");
                        countdown.countDown();
                        s.getAndAdd(-1);
                    }
                    ).start();
                }else{
                    break;
                }
                Thread.sleep(2000);


            }
            System.out.println("等待子线程都执行结束");
            countdown.await();
            System.out.println("子线程都执行结束了，主线程被唤醒 继续执行主线程");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
