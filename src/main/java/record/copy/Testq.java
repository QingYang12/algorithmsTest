package record.copy;
import  org.apache.commons.beanutils.BeanUtils;
/**
 *测试拷贝后原对象是否被删除2
 */
public class Testq {
    public static void main(String[] args) {
        String strx="";
        String str="1";
        String str1="1,2";
        System.out.println("x"+strx.split(",").length);
        System.out.println("xx"+str.split(",").length);
        System.out.println("yy"+str1.split(",").length);
        System.out.println(10700%64);
        try {
            Qp p=new Qp();
            p.p1="1";
            p.p2=2;
            QQ qq=new QQ();
            qq.q1="1";
            qq.q2=2;
            qq.q3=3;
            Qw qw=new Qw();
            qw.setW1("1");
            qw.setW2(2);
            qw.setW3(3);
            qw.setW4(qq);
            qw.setP1("1");
            qw.setP2(2);
            Qw qwclone=new Qw();

            BeanUtils.copyProperties(qwclone,  qw);
            Qw qwclone2=qw.clone();


            System.out.println(1);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("促销实体拷贝异常");
        }

    }
}
