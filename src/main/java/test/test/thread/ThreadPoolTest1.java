package test.test.thread;

import java.util.Date;
import java.util.concurrent.*;

public class ThreadPoolTest1 {
    public static void main(String[] args) {
        try {
            //AbortPolicy    满了会抛出异常 执行不完
            //CallerRunsPolicy   满了会等待   能执行完
            //DiscardPolicy    满了  会丢弃  少数据
            //DiscardOldestPolicy  满了  会丢弃（丢弃最早进入队列的）  少数据
            //keepAliveTime是线程池中空闲线程等待工作的超时时间。一旦超时便销毁线程。
            Date date1=new Date();
            CountDownLatch latch =new CountDownLatch(500);
            final int poolSize = (int)(4/(1-0.9));
            RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
            ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 40, 200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(20),handler);
            //4盒8G
            for(int i=0;i<500;i++){
                MyTask myTask = new MyTask(i,latch);
                executor.execute(myTask);
                System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                        executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
            }
            latch.await();
            Date date2=new Date();
            long time=date2.getTime()-date1.getTime();
            System.out.println("总耗时ms："+time);
            executor.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
