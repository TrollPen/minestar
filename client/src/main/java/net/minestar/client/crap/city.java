package net.minestar.client.crap;

public class city {
	int population;
	int size;
	String name;
	int tradelevel;
	int techlevel;
	double crowding;
	int moodlevel;
	city(int population, int size, String name, int tradelevel, int techlevel, double crowding, int moodlevel){
		this.population = population;
		this.size = size;
		this.tradelevel = tradelevel;
		this.techlevel = techlevel;
		this.crowding = crowding;
		this.moodlevel = moodlevel;
	}
}
