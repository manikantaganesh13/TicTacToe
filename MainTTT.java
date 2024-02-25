package com.mycompany.demo;

//HOME PAGE SHOWING START BUTTON

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class MainTTT implements ActionListener{
    
    JFrame frame = new JFrame("Home");
    JButton button = new JButton("Start");
    JLabel label = new JLabel();
    
    @Override
    public void actionPerformed(ActionEvent e ){
        if(e.getSource()==button){
            frame.dispose();
            TTT obj = new TTT();
        }
    }
    
    MainTTT(){
        
        label.setFont(new Font("Courier",Font.BOLD,60));
        label.setText("Tic-Tac-Toe");
        label.setBounds(110,80,500,50);
        label.setBackground(new Color(255,255,255));
        label.setForeground(new Color(255,25,25));
        frame.add(label);
        
        button.setBounds(180,230,180,40);
        button.setBackground(Color.LIGHT_GRAY);
        button.setFont(new Font("Courier",Font.BOLD,16));
        button.setForeground(Color.BLACK);
        button.addActionListener(this);
        frame.add(button);
        
        //frame.getContentPane().setBackground( Color.BLACK );
        frame.setSize(600,600);
        frame.setLayout(null);  
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}
