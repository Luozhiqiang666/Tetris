package com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    JButton reStar,end,report,about;
    public MenuPanel(){
        Initial();
    }
    void Initial(){
        reStar = new JButton("暂停");
        end = new JButton("结束");
        report = new JButton("战绩");
        about = new JButton("设置");
        add(reStar);
        add(end);
        add(report);
        add(about);
        reStar.setPreferredSize(new Dimension(120,60));
        end.setPreferredSize(new Dimension(120,60));
        report.setPreferredSize(new Dimension(120,60));
        about.setPreferredSize(new Dimension(120,60));
        //添加监视器





    }
}
