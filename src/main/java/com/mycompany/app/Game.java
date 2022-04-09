package com.mycompany.app;

import java.util.ArrayList; // import the ArrayList class

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

    private int id;
    private String name;    
    private int disksCount;
    private int towersCount;
	ArrayList<Disk> disks;
	ArrayList<Tower> towers;
	
	//Getters
    @Id
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public int getDisksCount(){
		return disksCount;
	}
	
    public int getTowersCount(){
		return towersCount;
	}
	
	//Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setDisksCount(int newDisksCount){
		this.disksCount = newDisksCount;
	}
	
    public void setTowersCount(int newTowersCount){
		this.towersCount = newTowersCount;
	}
	
	//Constructor
	public Game(int id, String name, int initDisksCount, int initTowersCount){
		
		//Initializing
		this.id = id;
		this.name = name;
		this.disksCount = initDisksCount;
		this.towersCount = initTowersCount;		
		disks = new ArrayList<Disk>(); // Create an ArrayList object
		towers = new ArrayList<Tower>(); // Create an ArrayList object
		
		//Create the towers
		for(int i=0; i<towersCount; i++) {
			Tower towerTemp = new Tower(i, disksCount);
			
			if(i == 0) {
				for(int k=0; k<disksCount; k++) {
					Disk diskTemp = new Disk(disksCount-k);
					//disks.add(diskTemp);
					towerTemp.putDisk(diskTemp);
				}
			}
			
			towers.add(towerTemp);			
		}
		
	}
	
	//Initialize the game
	public void initGame(){		
		System.out.println("Game '" + name + "' at init");
		
		for (Disk disk : disks) {
			towers.get(0).putDisk(disk);
		}
	}
	
	//Displays all the towers with their respective hosted disks
	public void displayGame() {
		for (Tower tower : towers) {
			Disk disk = null;
			
			System.out.println("== Tower " + tower.getTowerId());
			
			for(int i=0; i<tower.getHostedDisks1().size(); i++) {
				disk = tower.getHostedDisks1().get(tower.getHostedDisks1().size()- 1 -i);
				System.out.println("========= Disk " + disk.getSize());
			}
		}
		
	}	
	
	public void saveGame() {
		
	}
	
	public void restoreGame() {
		
	}
	
	//Checks whether the current game is saved in the DB or not
	public boolean firstSave() {
		boolean firstSaveDone = false;

		return firstSaveDone;
	}

	//Moves disk from source tower to target tower
	public int moveDisk(int sourceTowerId, int targetTowerId){
		
			int status = 0; //0 ==> OK
							//1	==>	NOK
		
			//Verify the source and target
			if((sourceTowerId < 0) ||
					(sourceTowerId > towersCount) ||
					(targetTowerId < 0) ||
					(targetTowerId > towersCount)) {
				System.err.println("sourceTowerId or targetTowerId not in the range");
				return 1;
			}

			if(sourceTowerId == targetTowerId) {
				System.err.println("sourceTowerId and targetTowerId cannot be equal");
			}
			
			
			//towers.get(sourceTowerId).removeDisk(disks.get(disks.size()-1));
			//Check whether the target tower disk is larger than the source tower one
			if(towers.get(sourceTowerId).peekTopDiskSize() <= towers.get(targetTowerId).peekTopDiskSize()) {
				Disk temp = towers.get(sourceTowerId).getTop();
				towers.get(targetTowerId).putDisk(temp);
			}
			else {
				System.err.println("Move not authorized: sourceTower disk larger than targetTower one");
			}
			
			return 0;
	}
	
	//Checks whether the game is finished
	public boolean isGameFinished() {
		boolean status = false;

		if(this.towers.get(0).isTowerEmpty() &&
				this.towers.get(1).isTowerEmpty() &&
				this.towers.get(2).isTowerFull()) {
			status = true;
		}
		
		return status;
	}

}
