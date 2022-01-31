package com.company.Modle;
import  com.company.View.*;
public class GameData {
    public static boolean [][]data;
    public static int score;
    //初始化构造函数
    public static void InitialData(){
        score = 0;
        data = new boolean[12][21];
        for(int x=0; x<12; x++){
            for(int y=0; y<21; y++){
                data[x][y] = false;
            }
        }
    }
    //将方块添加到记录数据
    public static void addBlack(Block block){
        for(int i=0; i<4; i++){
            data[block.cx + block.block_x[i]][block.cy + block.block_y[i]] = true;
        }
    }
}
