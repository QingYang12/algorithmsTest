package record.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产消费者模式
 * 线程通信第一版 synchronized 同一个对象 wait notify    实现锁资源争抢 从而实现线程通讯
 */
public class Test8_ProduceConsume_synchronized {
    public static volatile AtomicInteger s=new AtomicInteger(0);
    // AtomicReference<List> atomicStudent = new AtomicReference<List>();  Atomic对象例子
    public static volatile Object t1=new Object();
    public static void main(String[] args) {
        new Thread(()->{
            try {
                while(true){
                    synchronized (t1) {

                        System.out.println("p start ");
                        Test8_ProduceConsume_synchronized.product();
                        System.out.println("p end ");
                        t1.notify();
                        t1.wait();

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{

            try {
                while(true){
                    synchronized (t1) {
                            System.out.println("c start wait");
                            System.out.println("c end wait");
                            Test8_ProduceConsume_synchronized.consumer();
                            t1.notify();
                            t1.wait();


                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();
    }

    public  static void  product()throws Exception{
        int i=0;
        while(i<5){
            i++;
            Test8_ProduceConsume_synchronized.s.getAndAdd(1);
            System.out.println("S++");
            System.out.println(Test8_ProduceConsume_synchronized.s);
        }
    }
    public  static void consumer()throws Exception{
        int i=0;
        while(i<5){
            i++;
            Test8_ProduceConsume_synchronized.s.getAndAdd(-1);
            System.out.println("S--");
            System.out.println(Test8_ProduceConsume_synchronized.s);
        }
    }
}
