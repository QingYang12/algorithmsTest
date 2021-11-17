package record.z_proTest.thread;

import java.util.concurrent.CountDownLatch;

/**
 *
 */
public class MyTask  implements Runnable{

        private int taskNum;
        private CountDownLatch latch;

        public MyTask(int num, CountDownLatch latchs) {
            this.taskNum = num;
            this.latch = latchs;
        }

        @Override
        public void run() {
            System.out.println("正在执行task "+taskNum);
            try {
                Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task "+taskNum+"执行完毕");
            latch.countDown();
        }
}
