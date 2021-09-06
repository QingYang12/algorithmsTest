package test.test.test1;

/**
 * 生产者消费者练习
 *
 *
 */
public class Test {
    public  volatile static int key =0;

    public static void main(String[] args) {
        try {
            Test t= new Test();
            new Thread(()->{
                t.product();

            }).start();
            new Thread(()->{
                t.consumer();
            }).start();
        }catch (Exception e){

            System.out.println(e.getMessage());
        }

    }
    public  synchronized void  product() {
        try {
            while(key>=10){
                this.wait();
            }
            while(key<=10){
                key++;
                System.out.println("P:"+key);
            }
            this.notify();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    public  synchronized void consumer() {
        try {
            while(key<=10){
                this.wait();
            }
                while(key>=0){
                    key--;
                    System.out.println("C:"+key);
                }

            this.notify();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
