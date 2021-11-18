package record.z_proTest.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("开始");
        AtomicInteger num = new AtomicInteger(0);
        ReentrantLock rtl = new ReentrantLock();
        Condition c1 = rtl.newCondition();
        Condition c2 = rtl.newCondition();
        try {
            new Thread(
                    () -> {

                        try {
                            while (true) {
                                rtl.lock();
                                c2.signal();
                                while (num.intValue() <= 10) {
                                    num.getAndAdd(1);
                                    System.out.println("product " + num.intValue());
                                };
                                c1.await();
                                rtl.unlock();

                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
            ).start();

            new Thread(
                    () -> {
                        try {
                            while (true) {
                                rtl.lock();
                                c1.signal();
                                while (num.intValue() >= 5) {
                                    num.getAndAdd(-1);
                                    System.out.println("consumer " + num.intValue());
                                };
                                c2.await();
                                rtl.unlock();

                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
            ).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
