package test.test.test6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test15 {
    public static void main(String[] args) {
        Qw q1=new Qw();
        q1.setId(1l);
        Qw q2=new Qw();
        q2.setId(2l);
        Qw q3=new Qw();
        q3.setId(3l);
        Qw q4=new Qw();
        q4.setId(4l);
        Qw q5=new Qw();
        q5.setId(5l);
        Qw q6=new Qw();
        q6.setId(6l);
        Qw q7=new Qw();
        q7.setId(7l);

        List<Qw> jddjPlummetsRrpPluList=new ArrayList();
        jddjPlummetsRrpPluList.add(q1);
        jddjPlummetsRrpPluList.add(q2);
        jddjPlummetsRrpPluList.add(q3);
        jddjPlummetsRrpPluList.add(q4);
        jddjPlummetsRrpPluList.add(q5);
        jddjPlummetsRrpPluList.add(q6);
        jddjPlummetsRrpPluList.add(q7);
        List<Qw>  jdSecKillList=new ArrayList();
        jdSecKillList.add(q6);
        jdSecKillList.add(q7);
        //jddjPlummetsRrpPluList = jddjPlummetsRrpPluList.stream().filter(item -> !jdSecKillList.contains(item)).collect(Collectors.toList());
        jddjPlummetsRrpPluList=removeListItemFun(jddjPlummetsRrpPluList,jdSecKillList);
        System.out.println(1);

    }
    /**
     *
     * @param orgarr  原始数组
     * @param fliterarr 需要剔除的项
     * @return 剔除后的剩余项数组
     */

    public  static List<Qw>  removeListItemFun(List<Qw> orgarr,List<Qw> fliterarr){
        List<Qw> resArr=new ArrayList<>();
        for(Qw orgitem :orgarr){
            Long orgid=orgitem.getId();
            boolean key=true;
            for(Qw flitem :fliterarr){
                Long flid=flitem.getId();
                if(orgid.equals(flid)){
                    key=false;
                }
            }
            if(key){
                resArr.add(orgitem);
            }
        }

        return  resArr;
    }
}
