package hayattaKalmaOyunu;

public abstract class GameChars {
	
	String name,charName;	
	int id;	
	int damage,health,money;
	
	public GameChars(String name, int id, int damage, int health, int money) {
		super();
		this.name = name;
		this.id = id;
		this.damage = damage;
		this.health = health;
		this.money = money;
	}
	public GameChars() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	//protected abstract String getCharName();
}
