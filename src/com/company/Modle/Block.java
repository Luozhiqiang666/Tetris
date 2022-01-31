package com.company.Modle;
import  com.company.View.*;

public class Block implements Cloneable {
    public int cx,cy;
    public int block_x[],block_y[];
    public Block(int []xs, int []ys){
        if(xs.length != ys.length || ys.length!= 4){
            System.out.println("BLOCKINFERRO");
        }
        block_x = xs;
        block_y = ys;
        InitialBlock();
    }
    public void InitialBlock(){
        cx = 5;
        cy = 0;
    }
}
