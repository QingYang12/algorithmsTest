package test.test.test3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * 给定一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 *a，b，c ，
 * *使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * */
public class Test {

    public static void main(String[] args) {
        int[] nums=new int[] {-1, 0, 1, 2, -1, -4};
        List arr=new ArrayList();
        int i=0;
        int j=1;
        int k=2;
        while(i<=nums.length-3){

            while(j<=nums.length-2){

                while(k<=nums.length-1){
                    //判断添加条件
                    if(nums[i]+nums[j]+nums[k]==0){
                        HashMap item=new HashMap();
                        item.put("value",nums[i]+","+nums[j]+","+nums[k]);
                        arr.add(item);
                    }
                    k++;
                }
                j++;
                k=j;
            }
            i++;
            j=i;
        }




    }
}
