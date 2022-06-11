package hayattaKalmaOyunu;

public class Inventory {
	private Weapons weapons;
	private Armor armor;
	boolean fireWood,water,food,quarryAward;
	
	
	public Inventory() {
		super();
		this.weapons = new Weapons("Yumruk", -1, 0, 0);
		this.armor = new Armor(-1,0, 0, "Yumurta kartonu");
	}

	public Weapons getWeapons() {
		return weapons;
	}

	public void setWeapons(Weapons weapons) {
		this.weapons = weapons;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public boolean isFireWood() {
		return fireWood;
	}

	public void setFireWood(boolean fireWood) {
		this.fireWood = fireWood;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isQuarryAward() {
		return quarryAward;
	}

	public void setQuarryAward(boolean quarryAward) {
		this.quarryAward = quarryAward;
	}
	
}
