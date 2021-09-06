package test.test.test6;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**回环栅栏  CyclicBarrier
 * 所有线程等待其他线程都执行完毕后，
 * 所有线程才继续执行。
 *
 */
public class Test11 {
    public static void main(String[] args) {
        try {
            CyclicBarrier cycbarrier=new CyclicBarrier(5);
            AtomicInteger s =new AtomicInteger(5);
            System.out.println("所有线程等待其他线程都执行完毕");
            while(true){
                if(s.get()>0){
                    new Thread(()->{
                        try {
                            int temp=s.get();
                            s.getAndAdd(-1);
                            System.out.println(temp+"线程执行完成，进入等待状态");
                            cycbarrier.await();
                            System.out.println(temp+"线程同时继续执行--------");
                        }catch (Exception e){
                            e.printStackTrace();
                        }


                    }
                    ).start();
                }else{
                    break;
                }
                Thread.sleep(2000);
            }


        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
