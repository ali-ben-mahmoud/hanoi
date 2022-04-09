package com.mycompany.app;

import java.util.ArrayList;
import java.util.Stack;

public class Tower {

    private int towerId;
    private Stack<Disk> hostedDisks;
    private int towerSize;
	
	//Constructor
	Tower(int initTowerId, int towerSize){
		this.towerId = initTowerId;
		hostedDisks = new Stack<Disk>(); // Create an ArrayList object
		this.towerSize = towerSize;
	}
	
	//Getters
	int getTowerId(){
		return towerId;
	}
	
	Stack<Disk> getHostedDisks1(){
		return hostedDisks;
	}
	
	//Setters
	void setTowerId(int newTowerId){
		this.towerId = newTowerId;
	}
	

	//Get top
	Disk getTop() {
		Disk temp = new Disk(0);
		
		//Check whether the tower is not empty
		if(hostedDisks.size() > 0) {
			//Check whether the disk is already existant in the tower
			temp = hostedDisks.pop();
		}
		else {
			System.out.println("The tower is empty ==> Impossible to remove any disk!");
		}
		
		return temp;
	}
	
	//Peek top
	int peekTopDiskSize() {
		if(! hostedDisks.isEmpty()) {
			return hostedDisks.peek().getSize();
		}
		else {
			return 1000;
		}			
	}
	
	//Put a new disk on the tower top
	void putDisk(Disk disk){
		
		//Check whether the tower is empty
		if(hostedDisks.size() == 0) {
			hostedDisks.push(disk);
		}
		else {
			//The tower is not empty, check the size of the top disk
			if(disk.getSize() <= hostedDisks.peek().getSize()) {
				hostedDisks.push(disk);
			}
			else {
				System.out.println("The new disk is bigger than the top disk ==> Impossible to add!");
			}
		}
	}
	
	//Removes a disk
	void removeDisk(Disk disk){
		
		//Check whether the tower is not empty
		if(hostedDisks.size() > 0) {
			//Check whether the disk is already existant in the tower
			if(hostedDisks.contains(disk)) {
				hostedDisks.pop();
			}
			else{
				System.out.println("The disk is not existant in the tower ==> Impossible to remove it!");
			}
		}
		else {
			System.out.println("The tower is empty ==> Impossible to remove any disk!");
		}
	}
	
	boolean isTowerEmpty(){
		if(hostedDisks.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	

	
	boolean isTowerFull(){
		if(hostedDisks.size() == towerSize) {
			return true;
		}
		else {
			return false;
		}
	}

}
