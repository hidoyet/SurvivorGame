package hayattaKalmaOyunu;

public class Enemies {
	private int id;
	private String name;
	private int health;
	private int damage;
	public int award;
	public int originalHealth;
	
	

	public Enemies(int id, String name, int health, int damage,int award) {
		super();
		this.id = id;
		this.name = name;
		this.health = health;
		this.originalHealth=health;
		this.damage = damage;
		this.award=award;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health<0) {
			health=0;
		}
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}

	public int getOriginalHealth() {
		return originalHealth;
	}

	public void setOriginalHealth(int originalHealth) {
		this.originalHealth = originalHealth;
	}
}

