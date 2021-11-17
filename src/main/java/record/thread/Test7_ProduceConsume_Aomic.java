package record.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产消费者模式
 * 简单版
 * 使用 Atomic
 *
 */
class Test7_ProduceConsume_Aomic {
    static volatile AtomicInteger s=new AtomicInteger(0);
    // AtomicReference<List> atomicStudent = new AtomicReference<List>();  Atomic对象例子
    public static void main(String[] args) {

        new Thread(()->{
            while(true){
                if(s.get()<=500000){
                    Test7_ProduceConsume_Aomic.product();
                }
            }
        }).start();
        new Thread(()->{
            while(true){
                if(s.get()>=1000000){
                    Test7_ProduceConsume_Aomic.consumer();
                }
            }
        }).start();


    }

    public static  void  product(){
        int i=0;
        while(i<500000){
            i++;
            Test7_ProduceConsume_Aomic.s.getAndAdd(1);
            System.out.println("S++");
            System.out.println(Test7_ProduceConsume_Aomic.s);
        }
    }
    public static  void consumer(){
        int i=0;
        while(i<500000){
            i++;
            Test7_ProduceConsume_Aomic.s.getAndAdd(-1);
            System.out.println("S--");
            System.out.println(Test7_ProduceConsume_Aomic.s);
        }
    }
}
