package com.mycompany.app;

/**
 * Hello world!
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;

import com.mycompany.buttonslisteners.AbortGameButtonClickListener;
import com.mycompany.buttonslisteners.StartGameButtonClickListener;
import com.mycompany.buttonslisteners.TowerOneButtonClickListener;
import com.mycompany.buttonslisteners.TowerThreeButtonClickListener;
import com.mycompany.buttonslisteners.TowerTwoButtonClickListener;

public class SwingControlDemo extends JFrame{
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel headerLabel1;
   private JLabel statusLabel1;
   private JPanel controlPanel1;
   private	boolean startGameRequested;
   private	boolean endGameRequested;
   private	boolean moveFrom;

   public SwingControlDemo(){
	   //Initialize game variables
	   startGameRequested = false;
	   endGameRequested = false;
	   moveFrom = true;
	   

       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(350, 250);
       setVisible(true);
       
       this.setTitle("AAA");
       this.setSize(400,400);
       this.setLayout(new GridLayout(4, 1));

       headerLabel1 = new JLabel("",JLabel.CENTER );
       statusLabel1 = new JLabel("",JLabel.CENTER);        
       statusLabel1.setSize(350,100);
       
       this.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent windowEvent){
             System.exit(0);
          }        
       });    
       controlPanel1 = new JPanel();
       controlPanel1.setLayout(new FlowLayout());
       this.setVisible(true);
	   
	   prepareGUI();
   }
   
   //Getters
   public boolean getStartGameRequested() {
	   return startGameRequested;
   }
   
   public boolean getEndGameRequested() {
	   return endGameRequested;
   }
   
   public String getStatusLabel() {
	   return statusLabel.getText();
   }
   
   public boolean getMoveFrom() {
	   return moveFrom;
   }
   
   //Setters
   public void setStartGameRequested(boolean request) {
      startGameRequested = request;
   }
   
   public void setEndGameRequested(boolean request) {
	   endGameRequested = request;
   }
   
   public void setStatusLabel(String text) {
	   statusLabel.setText(text);
   }
   
   public void setMoveFrom(boolean request) {
	   moveFrom = request;
   }
   
   //prepareGUI
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(5, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);      
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
   }
   


   @Override
   public void paint(Graphics g) {

       super.paint(g);
       Graphics graphics = getContentPane().getGraphics();
       
       // drawing process

       this.add(headerLabel);
       this.add(controlPanel);      
       this.add(controlPanel1);
       this.add(statusLabel);
       
       graphics.drawLine(60, 300, 80, 200);

       int[] xPoints1 = { 80, 120, 160 };
       int[] yPoints1 = { 200, 100, 200 };
       graphics.drawString("drawPolyline", 80, 30);
       graphics.drawPolyline(xPoints1, yPoints1, xPoints1.length);

       int[] xPoints2 = { 180, 220, 260 };
       int[] yPoints2 = { 200, 100, 200 };
       graphics.drawString("drawPolygon", 180, 30);
       graphics.drawPolygon(xPoints2, yPoints2, xPoints2.length);

   }
   
   public void showEventDemo(){
      headerLabel.setText("Control in action: Button"); 

      JButton startGameButton = new JButton("Start");
      JButton towerOneButton = new JButton("1");
      JButton towerTwoButton = new JButton("2");
      JButton towerThreeButton = new JButton("3");
      JButton abortGameButton = new JButton("Abort");

      startGameButton.setActionCommand("Start");
      towerOneButton.setActionCommand("1");
      towerTwoButton.setActionCommand("2");
      towerThreeButton.setActionCommand("3");
      abortGameButton.setActionCommand("Abort");

      startGameButton.addActionListener(new StartGameButtonClickListener(this)); 
      towerOneButton.addActionListener(new TowerOneButtonClickListener(this));  
      towerTwoButton.addActionListener(new TowerTwoButtonClickListener(this)); 
      towerThreeButton.addActionListener(new TowerThreeButtonClickListener(this));
      abortGameButton.addActionListener(new AbortGameButtonClickListener(this)); 

      controlPanel.add(startGameButton);
      controlPanel.add(towerOneButton);
      controlPanel.add(towerTwoButton);
      controlPanel.add(towerThreeButton);
      controlPanel.add(abortGameButton);       

      mainFrame.setVisible(true);  
   }
}