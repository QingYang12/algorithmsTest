package record.algorithms;

/**
 * 二分法非递归
 */
public class Test_Half2 {
    public static void main(String[] args) {
        int[] arr={ 1,2,4,6,7};
        int start=0;
        int target=6;
        int end=arr.length-1;
        int middle=(start+end)/2;
        while(arr[middle]!=target&&middle!=start&&middle!=end){
            if(arr[middle]>target){
                end=middle;
            }
            if(arr[middle]<target){
                start=middle;
            }
            middle=(start+end)/2;
        }
        if(middle==start||middle==end){
            System.out.println(-1);
        }else{
            System.out.println(middle);
        }

    }
}
