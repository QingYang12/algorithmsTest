package test.test.test6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产消费者模式
 * 简单版
 *
 *
 */
class Test7 {
    static volatile AtomicInteger s=new AtomicInteger(0);
    public static void main(String[] args) {

        new Thread(()->{
            while(true){
                if(s.get()<=500000){
                    Test7.product();
                }
            }
        }).start();
        new Thread(()->{
            while(true){
                if(s.get()>=1000000){
                    Test7.consumer();
                }
            }
        }).start();


    }

    public static  void  product(){
        int i=0;
        while(i<500000){
            i++;
            Test7.s.getAndAdd(1);
            System.out.println("S++");
            System.out.println(Test7.s);
        }
    }
    public static  void consumer(){
        int i=0;
        while(i<500000){
            i++;
            Test7.s.getAndAdd(-1);
            System.out.println("S--");
            System.out.println(Test7.s);
        }
    }
}
