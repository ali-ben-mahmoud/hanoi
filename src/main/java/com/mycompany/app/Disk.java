package com.mycompany.app;

public class Disk {
	int Size;
	
	//Constructor
	Disk(int initSize){
		this.Size = initSize;
	}
	
	//Getters
	int getSize(){
		return Size;
	}
	
	//Setters
	void setSize(int newSize){
		this.Size = newSize;
	}

}
