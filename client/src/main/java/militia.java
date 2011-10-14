
public class militia {
	int health;
	int movementspeed;
	int damage;
	int energy;
	int range;
	Boolean alive = true;
	militia(int health, int movementspeed, int damage, int energy, int range, Boolean alive){
		this.health = health;
		this.damage = damage;
		this.movementspeed = movementspeed;
		this.energy = energy;
		this.range = range;
		this.alive = alive;
	}
}
