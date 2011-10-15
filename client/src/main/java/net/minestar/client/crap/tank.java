package net.minestar.client.crap;

public class tank {
	int movementspeed;
	int damage;
	int health;
	Boolean alive = true;
	tank(int movementspeed, int damage, int health, Boolean alive){
		this.movementspeed = movementspeed;
		this.damage = damage;
		this.health = health;
		this.alive = alive;
	}
	
	void fight(int damage, int health, Boolean alive){
		this.damage = damage;
		this.health = health;
		this.alive = alive;
	}
}
