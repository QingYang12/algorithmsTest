package test.test.test5;

public class Test6 {
    public static void main(String[] args) {
        int n=6;
        Test6 t=new Test6();
        t.eatfunction(n,"");
    }

    public void   eatfunction(int n ,String res){
        if(n>0){
            int k=3;
            int j=2;
            int s=1;
            String resk=res+k;
            eatfunction(n-k,resk);
            String resj=res+j;
            eatfunction(n-j,resj);
            String ress=res+s;
            eatfunction(n-s,ress);
        }else{
            if(n==0){
                System.out.println(res);
            }

        }
    }
}
