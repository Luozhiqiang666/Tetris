package com.company.View;

import com.company.Modle.Block;
import com.company.Modle.BlocksCreater;
import com.company.Modle.GameData;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class InfPanel extends JPanel {
    private Block nextBlock;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //g.drawLine(0,0,0,280);
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(Color.BLACK);
        g.setFont(new Font("宋体",Font.BOLD,25));
        g.drawString("分数",10,25);
        g.setFont(new Font("华文琥珀",Font.BOLD,25));
        g.drawString(GameData.score+"分",10,60);
        g2.setStroke(new BasicStroke(5));
        //g.drawLine(0,75,150,75);

        //画下一个方块
        g.setFont(new Font("宋体",Font.BOLD,25));
        g.drawString("下一个方块",10,100);
        paintNextBlock(g,nextBlock);

        //重画边框

    }

    protected void paintNextBlock(Graphics g, Block block){
        int SIZE = 30;
        int ox=40, oy=150;
        g.setColor(Color.GRAY);
        for(int i=0; i<4; i++){
            g.fill3DRect(ox+block.block_x[i]*SIZE,oy+block.block_y[i]*SIZE,SIZE,SIZE,true);
        }
    }

    public void setNextBlock(Block nextBlock) {
        this.nextBlock = nextBlock;
    }

    public Block getNextBlock() {
        return nextBlock;
    }
}
