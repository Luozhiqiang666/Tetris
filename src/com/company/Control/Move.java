package com.company.Control;
import com.company.Modle.*;
import com.company.View.Window;

//判断能否继续移动
public class Move {
    public static boolean canContinueDown(Block block){
        block.cy++;
        if(isExitAction(block)){
            return true;
        }else{
            block.cy--;
            return false;
        }
    }

    public static Block Left(Block block){
        block.cx--;
        if(isExitAction(block)){
            return block;
        }else{
            block.cx++;
            return block;
        }
    }

    public static Block Right(Block block){
        block.cx++;
        if(isExitAction(block)){
            return block;
        }else{
            block.cx--;
            return block;
        }
    }

    public static Block Turn(Block block) {
        try {
            Block turnedBlock = new Block(block.block_x.clone(),block.block_y.clone());         //数组直接赋值也是直接赋引用，必须clone()一份
            turnedBlock.cx = block.cx;
            turnedBlock.cy = block.cy;
            //System.out.println(turnedBlock==block);
            getTurnedBlock(turnedBlock);
            if (isExitAction(turnedBlock)) {
                return turnedBlock;
            } else {
                return block;
            }
        } catch (Exception e) {
            System.out.println("ERROTURN");
            return block;
        }
    }
    //判断方块的状态是否存在
    static boolean isExitAction(Block block){
        for(int i=0; i<4; i++){
            if(block.cx+block.block_x[i]<0||block.cx+block.block_x[i]>11||block.cy+block.block_y[i]<0||block.cy+block.block_y[i]>20){
                return false;
            }
            if(GameData.data[block.cx+block.block_x[i]][block.cy+block.block_y[i]] == true){
                return false;
            }
        }
        return true;
    }

    public static Block getTurnedBlock(Block block) {
        int temp;
        for (int i = 0; i < 4; i++) {
            if (block.block_x[i] > 0 && block.block_y[i] >= 0) {
                temp = block.block_y[i];
                block.block_y[i] = block.block_x[i];
                block.block_x[i] = -temp;
            } else if (block.block_x[i]<=0 && block.block_y[i] >0) {
                temp = block.block_y[i];
                block.block_y[i] = block.block_x[i];
                block.block_x[i] = -temp;
            } else if (block.block_x[i] < 0 && block.block_y[i] <= 0) {
                temp = block.block_y[i];
                block.block_y[i] = block.block_x[i];
                block.block_x[i] = -temp;
            } else if(block.block_x[i] >= 0 && block.block_y[i] < 0){
                temp = block.block_y[i];
                block.block_y[i] = block.block_x[i];
                block.block_x[i] = -temp;
            }else if(block.block_x[i] == 0 && block.block_y[i] == 0){

            } else{
                System.out.println("ERRO_TURNBLOCK");
            }
        }
        return block;
    }
}

//C++是这样，但是JAVA是没有生成新对象的，除非用关键字new,
// 如果是已经存在的对象也不像C++那样拷贝一份，
// 而是直接指向该对象，对象自始至终只有一个
// //数组直接赋值也是直接赋引用，必须clone()一份