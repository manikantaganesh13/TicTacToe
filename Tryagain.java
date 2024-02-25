package com.mycompany.demo;

//LAST PAGE
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Tryagain implements ActionListener {
    
    JFrame f=new JFrame();  
    JButton b=new JButton("Try Again");  
    JButton b1 = new JButton("Exit");
    
    Tryagain(){
                       
        b.setBounds(90,30,100,30);  
        b.addActionListener(this);
        b1.setBounds(110,80,60,30);
        b1.addActionListener(this);
        
        f.add(b);  
        f.add(b1);
        f.setSize(300,200);
        f.setLayout(null); 
        f.setLocationRelativeTo(TTT.frame);
        f.setVisible(true);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b){
           TTT.frame.dispose();
           TTT obj = new TTT();
           f.dispose();
        }
        
        if(e.getSource()==b1)
            System.exit(0);
    }
}
