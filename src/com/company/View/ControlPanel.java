package com.company.View;

import javax.swing.*;

public class ControlPanel extends JPanel {
    JButton down,right,left,turn;

    public ControlPanel(){
        Initial();
    }
    void Initial(){
        setLayout(null);
        down = new JButton("下");
        right = new JButton("右");;
        left = new JButton("左");
        turn = new JButton("转");
        add(down);
        add(left);
        add(right);
        add(turn);

        turn.setBounds(37,65,76,50);
        left.setBounds(10,115,65,50);
        right.setBounds(75,115,65,50);
        down.setBounds(37,165,75,50);
        //turn.setBounds();
    }
}
