package record.designpatterns;

/**
 * 单例练习-饿汉模式
 */
public class Singleton1 {
    private static Singleton1 single1=new Singleton1();

    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        return single1;
    }
}
