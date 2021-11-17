package record.algorithms;
/**
 * 二分法递归
 */
public class Test_Half1 {
    public static void main(String[] args) {
        int[] arr={ 1,2,4,6,7};
        int start=0;
        int target=6;
        int end=arr.length-1;
        int res=halfFinder(start,end,arr,target);
        System.out.println(res);
    }


    public static int  halfFinder(int start,int end,int[] arr,int target){
        int middle=(start+end)/2;
        if(arr[middle]>target){
            return halfFinder(start,middle,arr,target);
        }else if (arr[middle]<target){
            return halfFinder(middle,end,arr,target);
        }else if(arr[middle]==target){
            return middle;
        }else{
            return -1;
        }

    }
}
