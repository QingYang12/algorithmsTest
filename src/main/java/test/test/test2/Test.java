package test.test.test2;

/**
 * 找出字符串中的所有回文
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        String str="babad";
        char[]strArr=str.toCharArray();
        int i=str.length()-1;
        int j=0;
        while(j<=strArr.length-1){

            while(j<i){
                if(strArr[j] ==strArr[i]){
                    boolean key=checkHW(j,i,strArr);
                    if(key==true){
                        System.out.println(str.substring(j,i+1));
                    }
                    i=str.length()-1;
                    break;
                }else{
                    i--;
                }

            }
            j++;
        }



    }
    public static  boolean checkHW(int j,int i,char[] strArr){
        boolean key=false;
        while(true){

            if(strArr[i]!=strArr[j]){
                break;
            }else if(j<=i){
                key=true;
                break;
            }

            j++;
            i--;
        }

        return key;
    }
}
