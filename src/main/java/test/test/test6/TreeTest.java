package test.test.test6;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {
    public static void main(String[] args) {
        /*
                1--2
                    --5
                 --3
                4
         */
        List<TreeNode> srcarr =new ArrayList();
        TreeNode node1=new TreeNode();
        node1.setId(1);
        srcarr.add(node1);
        TreeNode node2=new TreeNode();
        node2.setId(2);
        node2.setPid(1);
        srcarr.add(node2);
        TreeNode node3=new TreeNode();
        node3.setId(3);
        node3.setPid(1);
        srcarr.add(node3);
        TreeNode node4=new TreeNode();
        node4.setId(4);
        srcarr.add(node4);
        TreeNode node5=new TreeNode();
        node5.setId(5);
        node5.setPid(2);
        srcarr.add(node5);
        List<TreeNode> resarr =buildTreeFun(srcarr);
        System.out.println("1");
    }

    //组装树
    public static List<TreeNode>  buildTreeFun(List<TreeNode> srcList){
        int srclength=srcList.size();
        List leafList1=findLeafFun(srcList);
        List resrcList=arrRemoveArrFun(srcList,leafList1);
        List linkLeafList=linkChildFun(resrcList,leafList1);
        int linklength=linkLeafList.size();
        if(linklength==srclength){
            return linkLeafList;
        }else{
            return buildTreeFun(linkLeafList);
        }

    }
    //寻找子节点
    public static List<TreeNode> findLeafFun(List<TreeNode> srcList){
        List<TreeNode> arr =new ArrayList();
        for(TreeNode srcitem:srcList){
            boolean isLeaf=true;
            for(TreeNode thisitem:srcList){
                if(thisitem.pid==srcitem.id){
                    isLeaf=false;
                }
            }
            if(isLeaf&&srcitem.pid!=null){
                arr.add(srcitem);
            }
        }
        return arr;
    }
    //原始集合剔除子节点集合
    public static List<TreeNode>  arrRemoveArrFun(List<TreeNode> srcList,List<TreeNode> leafList){
        List<TreeNode>  arr =new ArrayList();
        for(TreeNode srcitem:srcList){
            boolean islike=false;
            for(TreeNode thisitem:leafList){
                if(thisitem.id==srcitem.id){
                    islike=true;
                }
            }
            if(!islike){
                arr.add(srcitem);
            }
        }
        return arr;
    }
    //组装叶子节点到其上一级节点上
    public static List<TreeNode>  linkChildFun(List<TreeNode> srcList,List<TreeNode> leafList){
        for(TreeNode srcitem:srcList){
            boolean islike=false;
            for(TreeNode thisitem:leafList){
                if(thisitem.pid==srcitem.id){
                    srcitem.childList.add(thisitem);
                }
            }
        }
        return srcList;
    }



}
