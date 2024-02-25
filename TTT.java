package com.mycompany.demo;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//MAIN GAME PAGE
public class TTT implements ActionListener {
    Random random = new Random();
    static JFrame frame; 
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel label = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TTT(){
        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        label.setBackground(new Color(25,25,25));
        label.setForeground(new Color(25,255,25));
        label.setFont(new Font("Courier",Font.BOLD,75));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic-Tac-Toe");
        label.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,80);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(255,255,255));//white

        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(label);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    public void actionPerformed(ActionEvent e){

        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn==true){
                    if(buttons[i].getText()=="") {
			buttons[i].setForeground(new Color(255,0,0));
			buttons[i].setText("X");
			player1_turn=false;
			label.setText("O turn");
			check();
                    }
                }
                else {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        label.setText("X turn");
                        check();
                    }
                }
            }
        }
        
    }
    
    public void firstTurn(){
        
        try {   
            Thread.sleep(500);
	} 
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}

        if(random.nextInt(2)==0){
            player1_turn = true;
            label.setText("X Turn");
        }
        else{
            player1_turn = false;
            label.setText("O Turn");
        }
    }

    public void check(){
        //If X Wins
        if(buttons[0].getText()=="X" && buttons[1].getText()=="X" && buttons[2].getText()=="X")
            xWins(0,1,2);

        if(buttons[3].getText()=="X" && buttons[4].getText()=="X" && buttons[5].getText()=="X")
            xWins(3,4,5);

        if(buttons[6].getText()=="X" && buttons[7].getText()=="X" && buttons[8].getText()=="X")
            xWins(6,7,8);
            
        if(buttons[0].getText()=="X" && buttons[3].getText()=="X" && buttons[6].getText()=="X")
            xWins(0,3,6);

        if(buttons[1].getText()=="X" && buttons[4].getText()=="X" && buttons[7].getText()=="X")
            xWins(1,4,7);

        if(buttons[2].getText()=="X" && buttons[5].getText()=="X" && buttons[8].getText()=="X")
            xWins(2,5,8);

        if(buttons[0].getText()=="X" && buttons[4].getText()=="X" && buttons[8].getText()=="X")
            xWins(0,4,8);

        if(buttons[2].getText()=="X" && buttons[4].getText()=="X" && buttons[6].getText()=="X")
            xWins(2,4,6);

        //If O Wins
        if(buttons[0].getText()=="O" && buttons[1].getText()=="O" && buttons[2].getText()=="O")
            oWins(0,1,2);

        if(buttons[3].getText()=="O" && buttons[4].getText()=="O" && buttons[5].getText()=="O")
            oWins(3,4,5);

        if(buttons[6].getText()=="O" && buttons[7].getText()=="O" && buttons[8].getText()=="O")
            oWins(6,7,8);

        if(buttons[0].getText()=="O" && buttons[3].getText()=="O" && buttons[6].getText()=="O")
            oWins(0,3,6);

        if(buttons[1].getText()=="O" && buttons[4].getText()=="O" && buttons[7].getText()=="O")
            oWins(1,4,7);

        if(buttons[2].getText()=="O" && buttons[5].getText()=="O" && buttons[8].getText()=="O")
            oWins(2,5,8);

        if(buttons[0].getText()=="O" && buttons[4].getText()=="O" && buttons[8].getText()=="O")
            oWins(0,4,8);

        if(buttons[2].getText()=="O" && buttons[4].getText()=="O" && buttons[6].getText()=="O")
            oWins(2,4,6);
    }

    public void xWins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
	}
	label.setText("X wins");
        
        tryagain();
//        try {
//            Thread.sleep(2000);
//        } 
//        catch (InterruptedException ex) {
//            System.out.println(ex);
//        }
//        Tryagain ta = new Tryagain();
        
    }

    public void oWins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
	}
	label.setText("O wins");
        
        tryagain();  //HERE IT STOPED
//        try {
//            Thread.sleep(2000);
//        } 
//        catch (InterruptedException ex) {
//            System.out.println(ex);
//        }
//        Tryagain ta = new Tryagain();
    }
    
    public void tryagain(){
        
        try {
            Thread.sleep(2000);
            Tryagain ta = new Tryagain();
        } 
        catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
    }
}