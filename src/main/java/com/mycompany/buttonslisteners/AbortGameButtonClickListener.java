package com.mycompany.buttonslisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mycompany.app.SwingControlDemo;

public class AbortGameButtonClickListener implements ActionListener{
	
	private SwingControlDemo swingControlDemo;
	
	public AbortGameButtonClickListener(SwingControlDemo swingControlDemo) {
		this.swingControlDemo = swingControlDemo;
	}
	
	public void actionPerformed(ActionEvent e) {
	  String command = e.getActionCommand();  
	         
	  if( command.equals( "Abort" ))  {
		  swingControlDemo.setStatusLabel("Game aborted :(");
          
          //End game requested
		  swingControlDemo.setEndGameRequested(true);
	  }  	
  }		
}
