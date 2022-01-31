package com.company.View;

import javax.sound.sampled.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import  com.company.Modle.Block;
import com.company.Modle.BlocksCreater;
import com.company.Control.*;
import com.company.Modle.GameData;


public class Window extends JFrame {
    private int sleepTime;

    Block downingBlock;
    BlocksCreater blocksCreater = new BlocksCreater();

    JPanel eastPanel;
    public static GamePanel gamePanel;
    InfPanel infPanel;
    MenuPanel menuPanel;
    ControlPanel controlPanel;

    public Window(){
        Initial();
    }
    void Initial(){
        sleepTime = 800;
        setTitle("俄罗斯方块");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500,100,635,876);
        //添加相关组件
        gamePanel = new GamePanel();
        eastPanel = new JPanel();
        infPanel = new InfPanel();
        menuPanel = new MenuPanel();
        controlPanel = new ControlPanel();

        setLayout(new BorderLayout());


        add(gamePanel,BorderLayout.WEST);
        add(eastPanel,BorderLayout.EAST);

        eastPanel.setPreferredSize(new Dimension(150,840));
        gamePanel.setPreferredSize(new Dimension(485,880));

        eastPanel.add(infPanel);
        eastPanel.add(menuPanel);
        eastPanel.add(controlPanel);

        infPanel.setPreferredSize(new Dimension(140,280));
        menuPanel.setPreferredSize(new Dimension(150,280));
        controlPanel.setPreferredSize(new Dimension(150,280));

        //添加监视器
        menuPanel.end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
        }
        });

        controlPanel.left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downingBlock = Move.Left(downingBlock);
                gamePanel.repaint();
            }
        });

        controlPanel.right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downingBlock = Move.Right(downingBlock);
                gamePanel.repaint();
            }
        });

        controlPanel.down.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                sleepTime = 100;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                sleepTime = 500;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //添加翻转监视器
        controlPanel.turn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downingBlock = Move.Turn(downingBlock);
                gamePanel.repaint();
                gamePanel.setBlock(downingBlock);
            }
        });
        //添加重开监视器
        menuPanel.reStar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downingBlock = blocksCreater.CreatBlock();
                gamePanel.setBlock(downingBlock);
                gamePanel.repaint();
            }
        });
    }
    //运行函数
    public void Play(){
        downingBlock = blocksCreater.CreatBlock();
        gamePanel.setBlock(downingBlock);
        infPanel.setNextBlock(blocksCreater.CreatBlock());

        while(true){
            gamePanel.repaint();
            infPanel.repaint();

            try{
                Thread.sleep(sleepTime);
            }catch (Exception e){}
            //判断，生成，储存
            if( !Move.canContinueDown(downingBlock)){
                GameData.addBlack(downingBlock);

                if(Rule.isEnd()){
                    //System.out.println("GAME OVER!");
                    String message = "SCORE:"+GameData.score;
                    JOptionPane.showMessageDialog(this,message,"GAME OVER!",JOptionPane.WARNING_MESSAGE);
                }
                Rule.Remove(downingBlock);

                downingBlock = infPanel.getNextBlock();
                infPanel.setNextBlock(blocksCreater.CreatBlock());
                infPanel.repaint();

                gamePanel.setBlock(downingBlock);
            }

        }
    }
    //设置睡眠时间
    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }
}

