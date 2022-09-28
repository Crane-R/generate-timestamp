package org.example.frame;

import org.example.function.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description ：
 * @Author ：ZhouXingxue
 * @Date ：2022/9/23 20:48
 */
public class MainFrame extends JFrame {

    public static JTextField formatText;

    public static JLabel resultLabel;

    public MainFrame() {

        this.setTitle("Generate Timestamp v1.0");
        this.setSize(400, 200);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setUndecorated(true);
//        this.setOpacity(0.55f);

        //关闭按钮
        JButton closeButton = new JButton("Exit");
        closeButton.setBounds(300, 0, 100, 30);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.white);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(e -> System.exit(0));
        this.add(closeButton);


        //格式输入框
        formatText = new JTextField("yyMMdd_HHmm_ssSSS");
        formatText.setBounds(20, 20, 200, 30);
        formatText.setBorder(null);
        formatText.setHorizontalAlignment(JTextField.CENTER);
        formatText.setFont(new Font("宋体", Font.ITALIC, 14));
        this.add(formatText);

        //结果标签
        resultLabel = new JLabel("Sure");
        resultLabel.setBounds(300, 100, 200, 30);
        resultLabel.setForeground(Color.red);
        resultLabel.setVisible(false);
        this.add(resultLabel);

        //主要功能按钮
        JButton mainButton = new JButton("Get timestamp string");
        mainButton.setBackground(Color.white);
        mainButton.setFocusPainted(false);
        mainButton.setBorderPainted(false);
        mainButton.setBounds(20, 100, 200, 30);
        mainButton.addActionListener(e -> {
            Util.stick(Util.generateTime(formatText.getText()));
            resultLabel.setVisible(true);
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    resultLabel.setVisible(false);
                }
            }, 2000);
        });
        this.add(mainButton);


        //添加快捷键
///n


//        //给一个按钮切换透明度
//        JButton transparentSwitchButton = new JButton("象牙板");
//        transparentSwitchButton.setBounds(300,30,100,30);
//        transparentSwitchButton.setFocusPainted(false);
//        transparentSwitchButton.setBackground(Color.white);
//        transparentSwitchButton.setBorderPainted(false);
//        transparentSwitchButton.setFont(new Font("微软雅黑",Font.BOLD,11));
//        transparentSwitchButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        this.add(transparentSwitchButton);
    }

}
