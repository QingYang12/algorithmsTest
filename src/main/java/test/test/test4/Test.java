package test.test.test4;
    /*
     *两个有序数组合并成一个有序数组
     * 链表写法
    1，2，4，6，9
    2，2，3，4
    1，2，2，2，3，4，4，6，9

     */

public class Test {



    public static void main(String[] args) {
        //组装单链表
        Node nodeone1=new Node(1);
        Node nodeone2=new Node(2);
        Node nodeone3=new Node(4);
        Node nodeone4=new Node(6);
        Node nodeone5=new Node(9);



        Node nodetwe1=new Node(2);
        Node nodetwe2=new Node(2);
        Node nodetwe3=new Node(3);
        Node nodetwe4=new Node(4);

        //设置关系
        nodeone1.next=nodeone2;
        nodeone2.next=nodeone3;
        nodeone3.next=nodeone4;
        nodeone4.next=nodeone5;

        nodetwe1.next=nodetwe2;
        nodetwe2.next=nodetwe3;
        nodetwe3.next=nodetwe4;


         Node res=null;
        //组合成新的单连表
        sort(nodeone1,nodetwe1,res);
        //打印res
        System.out.println("开始打印数组");
        Node temp=res;
        while(temp!=null){
            System.out.println(temp.value);
            temp=res.next;
        };



    }

    //组合成新的单连表
    public  static Node sort(Node nodeone,Node nodetwe ,Node resnode){
        /*循环比较
        1，2，4，6，9
        2，2，3，4

        *谁小取谁
        *谁小谁向后移动*/
        //初始化参数
        Node node1temp=nodeone;
        Node node2temp=nodetwe;
        Node resnodetemp=null;


        while(node1temp!=null&&node2temp!=null){

            System.out.println("node compare : "+node1temp.value+"  "+node2temp.value);
            if(resnodetemp==null){
                resnodetemp=new Node();
            }
            if(node1temp.value<=node2temp.value){
                //node1 小 取node1 node1向后移动；
                resnodetemp.value=node1temp.value;
                node1temp=node1temp.next;
            }else{
                //node2 小 取node2 node2向后移动；
                resnodetemp.value=node2temp.value;
                node2temp=node2temp.next;
            }
            System.out.println("node get: "+resnodetemp.value);
            //res赋值向后移动

        }
        //截取剩下数组长度
        if(node1temp==null){
            //取2
            resnodetemp=node2temp.next;
        }else{
            //取1
            resnodetemp=node1temp.next;
        }
        return resnode;
    }
}
