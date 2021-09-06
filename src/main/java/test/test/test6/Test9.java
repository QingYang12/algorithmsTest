package test.test.test6;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产消费者模式
 * 线程通信第二版 synchronized 同一个对象 wait notify    实现锁资源争抢 从而实现线程通讯
 */
public class Test9 {
    public  static  AtomicInteger s=new AtomicInteger(0);
    public static void main(String[] args) {

        ReentrantLock lock=new ReentrantLock();
        Condition tcpthread1=lock.newCondition();
        Condition tcpthread2=lock.newCondition();
        new Thread(()->{
            try {
                while(true){
                    lock.lock();
                    System.out.println("p start ");
                    Test9.product();
                    System.out.println("p end ");
                    System.out.println("p await  c signal");
                    tcpthread1.await();
                    tcpthread2.signal();
                    lock.unlock();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{

            try {
                while(true){
                    lock.lock();
                    System.out.println("c start ");
                    Test9.consumer();
                    System.out.println("c end ");
                    System.out.println("c await  p signal");
                    tcpthread1.signal();
                    tcpthread2.await();
                    lock.unlock();
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
            Test9.s.getAndAdd(1);
            System.out.println("S++");
            System.out.println(Test9.s);
        }
    }
    public  static void consumer()throws Exception{
        int i=0;
        while(i<5){
            i++;
            Test9.s.getAndAdd(-1);
            System.out.println("S--");
            System.out.println(Test9.s);
        }
    }
}
