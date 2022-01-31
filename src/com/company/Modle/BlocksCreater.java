package com.company.Modle;

import com.company.View.GamePanel;

import java.util.Random;

public class BlocksCreater {
    //七种方块初始相对位置信息
    static Block []blocks = new Block[]{
            new Block(new int[]{-1,0,1,2},new int []{0,0,0,0}),
            new Block(new int[]{-1,0,0,1},new int []{0,0,1,0}),
            new Block(new int[]{0,1,0,1},new int []{0,0,1,1}),
            new Block(new int[]{-1,0,0,1},new int []{1,0,1,0}),
            new Block(new int[]{-1,0,0,1},new int []{0,0,1,1}),
            new Block(new int[]{-1,0,1,1},new int []{0,0,0,1}),
            new Block(new int[]{-1,-1,0,1},new int []{1,0,0,0}),
    };

    public Block CreatBlock(){
        Random intCtrater = new Random();
        int flag = intCtrater.nextInt(6);

        blocks[flag].InitialBlock();
        return blocks[flag];
    }
}
