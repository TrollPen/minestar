
public class soldier {
	int damage;
	int movementspeed;
	int range;
	int health;
	int energy;
	Boolean alive = true;
	soldier(int damage, int movementspeed, int range, int health, int energy){
		this.damage = damage;
		this.movementspeed = movementspeed;
		this.range = range;
		this.health = health;
		this.energy = energy;
	}
	
	void fight(int damage, int health, Boolean alive){
		this.damage = damage;
		this.health = health;
		this.alive = alive;
	}
}
