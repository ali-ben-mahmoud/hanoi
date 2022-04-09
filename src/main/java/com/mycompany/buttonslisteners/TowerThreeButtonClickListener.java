package com.mycompany.buttonslisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mycompany.app.SwingControlDemo;

public class TowerThreeButtonClickListener implements ActionListener{
	
	private SwingControlDemo swingControlDemo;
	
	public TowerThreeButtonClickListener(SwingControlDemo swingControlDemo) {
		this.swingControlDemo = swingControlDemo;
	}
	
	public void actionPerformed(ActionEvent e) {
	  String temp;
		String command = e.getActionCommand();  
	         
	  if( command.equals( "3" ) )  {
     	 if(swingControlDemo.getMoveFrom()) {
     		 swingControlDemo.setStatusLabel("3"); 
      		swingControlDemo.setMoveFrom(false);
     	 }
     	 else {
     		 temp = swingControlDemo.getStatusLabel();
     		 swingControlDemo.setStatusLabel(temp + " ==> 3");   
       		swingControlDemo.setMoveFrom(true);
     	 }	
	  }		
	}
}