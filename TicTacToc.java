package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToc implements ActionListener {
        Random random = new Random();
        JFrame frame = new JFrame();
        JPanel title_Panel = new JPanel();
        JPanel button_Panel = new JPanel();
        JLabel textFiled = new JLabel();
        JButton [] button = new JButton[9];
        JButton return_Button = new JButton("Play Again");
        boolean Player1_turn;

    TicTacToc(){
frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
frame.setSize( 800,800 );
frame.getContentPane().setBackground( new Color( 50,50,50 ) );
frame.setLayout( new BorderLayout() );
frame.setVisible( true );

textFiled.setBackground( new Color( 224, 206, 206 ) );
textFiled.setForeground( new Color( 89,89,89 ) );
textFiled.setFont( new Font( "San Serif", Font.BOLD,75) );
textFiled.setHorizontalAlignment( JLabel.CENTER );
textFiled.setText( " Tic-Tac-Toc" );
textFiled.setOpaque( true );

    title_Panel.setLayout( new BorderLayout() );
    title_Panel.setBounds( 0,0,800,100 );

button_Panel.setLayout( new GridLayout(3,3) );
button_Panel.setBackground( new Color( 150, 150, 206 ) );
for(int i = 0 ; i < 9 ; i ++){
    button[i] = new JButton();
    button_Panel.add( button[i] );
     button[i].setFont( new Font( "MV Boli",Font.BOLD,120 ) );
     button[i].setFocusable( false );
     button[i].addActionListener( this );
        }

return_Button.setBounds( 0,0,800,100 );

    title_Panel.add( textFiled );
    frame.add( title_Panel,BorderLayout.NORTH );
    frame.add( button_Panel );
    frame.add( return_Button,BorderLayout.SOUTH );

    return_Button.addActionListener( this );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == return_Button){
           new TicTacToc();
        }

for (int i = 0 ; i < 9 ; i ++){
    if(e.getSource() == button[i]){
        if(Player1_turn){
            if(button[i].getText()==""){
                button[i].setForeground( new Color( 80,49,66 ) );
                button[i].setText( "X" );
                Player1_turn=false;
                textFiled.setText( " O turn" );
                check();
            }
        }
        else {
            if (button[i].getText() == "") {
                button[i].setForeground( new Color( 74, 149, 124 ) );
                button[i].setText( "O" );
                Player1_turn = true;
                textFiled.setText( " X turn" );
                check();
            }
        }
    }
}
    }
    public void firstTurn (){
        try{
Thread.sleep( 2000 );
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        if(random.nextInt(2) == 0 ){
            Player1_turn = true;
            textFiled.setText("X turn" );
        }else{
            Player1_turn = true;
            textFiled.setText("O turn" );
        }

    } public void  check(){
        ///x
        if(
                (button[0].getText() == "X") &&
                (button[1].getText() == "X") &&
                (button[2].getText() == "X")
        ){
            XWins( 0,1,2 );
        }
        if(
                (button[3].getText() == "X") &&
                        (button[4].getText() == "X") &&
                        (button[5].getText() == "X")
        ){
            XWins( 3,4,5 );
        }
        if(
                (button[6].getText() == "X") &&
                        (button[7].getText() == "X") &&
                        (button[8].getText() == "X")
        ){
            XWins( 6,7,8 );
        }
        if(
                (button[0].getText() == "X") &&
                        (button[3].getText() == "X") &&
                        (button[6].getText() == "X")
        ){
            XWins( 0,3,6 );
        }
        if(
                (button[1].getText() == "X") &&
                        (button[4].getText() == "X") &&
                        (button[7].getText() == "X")
        ){
            XWins( 1,4,7 );
        }if(
                (button[2].getText() == "X") &&
                        (button[5].getText() == "X") &&
                        (button[8].getText() == "X")
        ){
            XWins( 2,5,8 );
        }
        if(
                (button[2].getText() == "X") &&
                        (button[4].getText() == "X") &&
                        (button[6].getText() == "X")
        ){
            XWins( 2,4,6 );
        }

        ///o
        if(
                (button[0].getText() == "O") &&
                        (button[1].getText() == "O") &&
                        (button[2].getText() == "O")
        ){
            OWins( 0,1,2 );
        }
        if(
                (button[3].getText() == "O") &&
                        (button[4].getText() == "O") &&
                        (button[5].getText() == "O")
        ){
            OWins( 3,4,5 );
        }
        if(
                (button[6].getText() == "O") &&
                        (button[7].getText() == "O") &&
                        (button[8].getText() == "O")
        ){
            OWins( 6,7,8 );
        }
        if(
                (button[0].getText() == "O") &&
                        (button[3].getText() == "O") &&
                        (button[6].getText() == "O")
        ){
            OWins( 0,3,6 );
        }
        if(
                (button[1].getText() == "O") &&
                        (button[4].getText() == "O") &&
                        (button[7].getText() == "O")
        ){
            OWins( 1,4,7 );
        }if(
                (button[2].getText() == "O") &&
                        (button[5].getText() == "O") &&
                        (button[8].getText() == "O")
        ){
            OWins( 2,5,8 );
        }
        if(
                (button[2].getText() == "O") &&
                        (button[4].getText() == "O") &&
                        (button[6].getText() == "O")
        ){
            OWins( 2,4,6 );
        }

    }public void XWins (int a, int b ,int c){
        button[a].setBackground( Color.green );
        button[b].setBackground( Color.green );
        button[c].setBackground( Color.green );
        for ( int i = 0 ; i < 9 ; i++ ){
            button[i].setEnabled( false );
        }
        textFiled.setText( "X wins" );
    }public void OWins (int a, int b ,int c){
        button[a].setBackground( Color.green );
        button[b].setBackground( Color.green );
        button[c].setBackground( Color.green );
        for ( int i = 0 ; i < 9 ; i++ ){
            button[i].setEnabled( false );
        }
        textFiled.setText( "O wins" );
      }
}

