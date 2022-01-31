package com.company.View;

import com.company.Modle.Block;
import com.company.Modle.GameData;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    static int SIZE = 40,BX = 200,BY = 0;
    Block block;

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);        //保留原组件


        //画已经存在的方块
        g.setColor(Color.GRAY);
        for(int x=0; x<12; x++){
            for(int y=0; y<21; y++){
                if(GameData.data[x][y] == true){
                    g.fill3DRect(x*SIZE,y*SIZE,SIZE,SIZE,true);
                }
            }
        }


        //画格子和边框
        g.setColor(Color.GRAY);
        for(int x=0; x<=480; x += 40){
            g.drawLine(x,0,x,840);
        }
        for(int y=0; y<=840; y += 40){
            g.drawLine(0,y,480,y);
        }

        //画加粗边框
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.BLACK);
        //g2.drawLine(483,0,483,840);
        //g2.drawLine(0,0,483,0);
        //g2.drawLine(0,0,0,840);
        //g2.drawLine(0,840,480,840);
        g2.drawLine(0,80,478,80);

        //画下落中的方块
        g.setColor(Color.GRAY);
        for(int i=0; i<4; i++){
            g.fill3DRect((block.cx + block.block_x[i]) * SIZE,(block.cy + block.block_y[i]) * SIZE,SIZE,SIZE,true);
        }
    }
}
