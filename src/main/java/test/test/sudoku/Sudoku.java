package test.test.sudoku;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {
    public static void main(String[] args) {
        String[][]  board = {
                            {"5","3",".",".","7",".",".",".","."},
                            {"6",".",".","1","9","5",".",".","."},
                            {".","9","8",".",".",".",".","6","."},
                            {"8",".",".",".","6",".",".",".","3"},
                            {"4",".",".","8",".","3",".",".","1"},
                            {"7",".",".",".","2",".",".",".","6"},
                            {".","6",".",".",".",".","2","8","."},
                            {".",".",".","4","1","9",".",".","5"},
                            {".",".",".",".","8",".",".","7","9"}};
        //输出：{{"5","3","4","6","7","8","9","1","2"},{"6","7","2","1","9","5","3","4","8"},{"1","9","8","3","4","2","5","6","7"},{"8","5","9","7","6","1","4","2","3"},{"4","2","6","8","5","3","7","9","1"},{"7","1","3","9","2","4","8","5","6"},{"9","6","1","5","3","7","2","8","4"},{"2","8","7","4","1","9","6","3","5"},{"3","4","5","2","8","6","1","7","9"}}
        /**
         * 主流程
         * 1，1-9 全扫描校验 能确定唯一填数则填入；
         * 2，全扫描校验不在能填入则终止循环
         */
        String[][] resboard=allcheck(board);
        System.out.println(JSONObject.toJSON(resboard).toString());
    }
    /**
     * 全扫描校验   给定数字 依次执行
     *     先内九宫格校验通过则进行横行校验，
     *     横行校验通过则进行纵列校验，
     *     纵列校验结束
     *     判断 是否可填入唯一值，有则填入，不能确定跳过
     *
     * 实现逻辑
     *
     *
     */
    public static String[][] allcheck(String[][] board){

        Boolean key=false;//是否需要继续递归
        //生成分片
        List<SudokuPoint> partitionArr=new ArrayList<>();
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                SudokuPoint sudokuPoint=new SudokuPoint();
                sudokuPoint.setPointI(3*i);
                sudokuPoint.setPointJ(3*j);
                partitionArr.add(sudokuPoint);
            }
        }
        //主要逻辑
        for(int num=1;num<=9;num++){
            for(int partition=0;partition<=8;partition++){
                if(checkSudoku(num,partitionArr.get(partition),board)){
                    Integer[] rowArr={0,1,2};
                    List<Integer> rowArrRes=new ArrayList();
                    Integer[] colArr={0,1,2};
                    List<Integer> colArrRes=new ArrayList();
                    for(int i=0;i<=2;i++){
                        if(checkRow(num,partitionArr.get(partition),rowArr[i],board)){
                            rowArrRes.add(rowArr[i]);
                        }
                        if(checkCol(num,partitionArr.get(partition),colArr[i],board)){
                            colArrRes.add(colArr[i]);
                        }
                    }
                    if(rowArrRes.size()==1&&colArrRes.size()==1){
                        insertBoard(num,rowArrRes.get(0),colArrRes.get(0),partitionArr.get(partition),board);
                        key=true;
                    }
                }
            }
        }
        if(key){
            return  allcheck(board);
        }else {
            return  board;
        }

    }
    /**
     *内九宫格校验
     * 返回 Boolean
     * true 表示九宫格内可填入该数字
     *
     * 实现逻辑
     *
     * num 验证数；  partition分片；  board 数组
     */
    public static Boolean checkSudoku(Integer num,SudokuPoint partition,String[][] board){
        Boolean res=true;
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                String item=board[partition.getPointI()+i][partition.getPointJ()+j];
                if(String.valueOf(num).equals(item)){
                    res=false;
                }
            }
        }
        return  res;
    }
    /**
     *横行校验
     * 返回 Boolean
     * true  表示该行可填入该数字
     * false 表示该行不可填入该数字
     *
     * 实现逻辑
     *
     *num 验证数；  partition分片； row第几行；  board 数组；
     */
    public static Boolean checkRow(Integer num,SudokuPoint partition,Integer row,String[][] board){
        Boolean res=true;
        for(int j=0;j<=2;j++){
            String item=board[partition.getPointI()+row][partition.getPointJ()+j];
            if(String.valueOf(num).equals(item)){
                res=false;
            }
        }
        return  res;
    }
    /**
     *纵列校验
     * 返回 Boolean
     * true  表示该列可填入该数字
     * false 表示该列不可填入该数字
     *
     * 实现逻辑
     *
     * num 验证数；  partition分片； col第几列； board 数组；
     */
    public static Boolean checkCol(Integer num,SudokuPoint partition,Integer col,String[][] board){
        Boolean res=true;
        for(int j=0;j<=2;j++){
            String item=board[partition.getPointI()+j][partition.getPointJ()+col];
            if(String.valueOf(num).equals(item)){
                res=false;
            }
        }
        return  res;
    }

    /**
     * 填入数组中
     * @param num
     * @param row
     * @param col
     * @param board
     * @return
     */
    public static void insertBoard(Integer num,Integer row,Integer col,SudokuPoint partition,String[][] board){
        board[partition.getPointI()+row][partition.getPointJ()+col]=String.valueOf(num);
    }






    ///////////////////////////////////////
    @Test
    public  void testCheckSudoku(){
        String[][]  board = {{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}};
        SudokuPoint sudokuPoint=new SudokuPoint();
        sudokuPoint.setPointI(0);
        sudokuPoint.setPointJ(3);
        Boolean res=checkSudoku(1,sudokuPoint,board);
        System.out.println(res);
    }

}
