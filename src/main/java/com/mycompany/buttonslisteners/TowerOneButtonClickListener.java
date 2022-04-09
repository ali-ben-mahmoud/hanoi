package com.mycompany.buttonslisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mycompany.app.SwingControlDemo;


public class TowerOneButtonClickListener implements ActionListener{
	
	private SwingControlDemo swingControlDemo;
	
	public TowerOneButtonClickListener(SwingControlDemo swingControlDemo) {
		this.swingControlDemo = swingControlDemo;
	}
	
	public void actionPerformed(ActionEvent e) {
		String temp;
		String command = e.getActionCommand();  
	         
	  if( command.equals( "1" ) )  {
     	 if(swingControlDemo.getMoveFrom()) {
     		swingControlDemo.setStatusLabel("1"); 
     		swingControlDemo.setMoveFrom(false);
     	 }
     	 else {
     		 temp = swingControlDemo.getStatusLabel();
     		 swingControlDemo.setStatusLabel(temp + " ==> 1");  
      		swingControlDemo.setMoveFrom(true);
     	 }
      } 	
  }		
}
