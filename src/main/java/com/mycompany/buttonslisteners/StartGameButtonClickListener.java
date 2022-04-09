package com.mycompany.buttonslisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mycompany.app.Game;
import com.mycompany.app.SwingControlDemo;

public class StartGameButtonClickListener implements ActionListener{
	
	private SwingControlDemo swingControlDemo;
	
	public StartGameButtonClickListener(SwingControlDemo swingControlDemo) {
		this.swingControlDemo = swingControlDemo;
	}
	
	public void actionPerformed(ActionEvent e) {
	  String command = e.getActionCommand();  
	         
	  if( command.equals( "Start" ))  {
		  swingControlDemo.setStatusLabel("Starting the game...");
	            
		  //Start game requested
		  swingControlDemo.setStartGameRequested(true);
		  
	       
	        
		Game game = new Game(1, "Game2", 3, 3);
			
		game.initGame();
	  }  	
  }		
}
