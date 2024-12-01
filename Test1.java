package com.itheima;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Test1 extends JFrame implements ActionListener{
    private double x=0;
    private double y=0;
    JTextField xval = new JTextField(10);
    JButton calcBtn = new JButton("计算");
    JTextArea result = new JTextArea(10,20);
    boolean isAngleRad = true;
    JButton angleUnitBtn = new JButton("设成弧度");
    void initFrame(){
        Container content = getContentPane();
        content.setLayout(new BorderLayout());

        JPanel calcPanel = new JPanel();
        calcPanel.setLayout(new FlowLayout());
        calcPanel.add(new JLabel("角的值"));
        calcPanel.add(xval);
        calcPanel.add(calcBtn);
        calcPanel.add(angleUnitBtn);
        content.add(calcPanel,"North");
        calcBtn.addActionListener(this);
        angleUnitBtn.addActionListener(this);

        content.add(result,"Center");
        result.setEditable(false);
    }

    public Test1(){
        super("计算余弦函数");
        setSize(500,200);
        initFrame();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calcBtn){
            String str;
            if(isAngleRad){
                x=Double.parseDouble(xval.getText());
                str="cos(" + x + ")=";
            } else {
                x=Double.parseDouble(xval.getText())/180*3.141592;
                str="cos(" + xval.getText() + "3.14159/180=";
            }
            y=Math.cos(x);
            result.append(str+y+'\n');
        } else if(e.getSource() == angleUnitBtn){
            if(isAngleRad){
                angleUnitBtn.setText("设成弧度");
            } else {
                angleUnitBtn.setText("设成角度");
            }
            isAngleRad = !isAngleRad;
        }
    }
    public static void main(String[] args) {
        new Test1();
    }
}
