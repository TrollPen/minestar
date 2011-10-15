package net.minestar.client.crap;

public class worker {
	int lumberspeed;
	int miningspeed;
	int movementspeed;
	int energy;
	Boolean alive = true;
	//variable declaration, and here the workers will be having their base stats recognized, and 
	worker(int lumberspeed, int miningspeed, int movementspeed){
		this.lumberspeed = lumberspeed;
		this.miningspeed = miningspeed;
		this.movementspeed = movementspeed;
	}
	
	void chopwood(int x, int y){
		//worker's coordinates become tree's coordinates, tree becomes grass
	}
	
	void mine(int x, int y){
		//worker's coordinates become mine's coordinates, and after a few seconds, they return to a city and deposit materials
	}
}
