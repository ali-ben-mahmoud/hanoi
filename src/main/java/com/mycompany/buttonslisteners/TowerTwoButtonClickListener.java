package com.mycompany.buttonslisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mycompany.app.SwingControlDemo;

public class TowerTwoButtonClickListener implements ActionListener{
	
	private SwingControlDemo swingControlDemo;
	
	public TowerTwoButtonClickListener(SwingControlDemo swingControlDemo) {
		this.swingControlDemo = swingControlDemo;
	}
	
	public void actionPerformed(ActionEvent e) {
		String temp;
		String command = e.getActionCommand();  
	         
	  if( command.equals( "2" ) )  {
     	 if(swingControlDemo.getMoveFrom()) {
     		 swingControlDemo.setStatusLabel("2");  
      		swingControlDemo.setMoveFrom(false);
     	 }
     	 else {
     		 temp = swingControlDemo.getStatusLabel();
     		 swingControlDemo.setStatusLabel(temp + " ==> 2");  
       		swingControlDemo.setMoveFrom(true);
     	 }  	
	  }		
	}
}
