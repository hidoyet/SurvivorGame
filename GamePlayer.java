package hayattaKalmaOyunu;

import java.util.Scanner;



public class GamePlayer {
	Scanner scanner=new Scanner(System.in);
	GameChars gameChars=null;
	String name;
	String charName;	
	int id;
	int damage,health,money,originalHealth;
	public int getOriginalHealth() {
		return originalHealth;
	}

	public void setOriginalHealth(int originalHealth) {
		this.originalHealth = originalHealth;
	}

	Inventory inventory;
	
	public GamePlayer(String name) {
		this.name=name;
		this.inventory=new Inventory();
	}
	
	public void selectChars() {
		GameChars[] chars= {new Samurai(),new Archer(),new Knight()};
		System.out.println("Karakterler");
		for(GameChars character:chars) {
			System.out.println("ID: "+character.getId()+"\tKarakter: "+ character.getName()+"\t\tHasar: "+ character.getDamage()
			+"\t Sa�l�k: "+character.getHealth()
			+"\t Para: "+character.getMoney());
		}
			System.out.print("\nHangi karakter ile sava�acaks�n: ");
			int choise=scanner.nextInt();
			
			
			switch(choise) {
			case 1:
				initPlayer(new Samurai());
				break;
			case 2:
				initPlayer(new Archer());
				break;
			case 3:
				initPlayer(new Knight());
				break;
			default:
				initPlayer(new Samurai());
				break;			
			}
		
		System.out.println("Se�ilen karaker:"+this.getName());
		
		
	}
	
	public void initPlayer (GameChars gameChars) {
		this.setDamage(gameChars.getDamage());
		this.setName(gameChars.getName());
		this.setMoney(gameChars.getMoney());
		this.setHealth(gameChars.getHealth());
		this.setOriginalHealth(gameChars.getHealth());
		//this.setCharName(gameChars.getCharName());
	}
	
	public void printInfo() {
		System.out.println(
				"Silah�n�z: "+this.getInventory().getWeapons().getName()+
				" Sa�l���n�z: "+this.getHealth()+
				" Hasar�n�z: "+ this.getTotalDamage()+
				" Paran�z: "+this.getMoney());
	}
	
		

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getTotalDamage() {
		return damage+this.getInventory().getWeapons().getDamage();
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
		if(health<0) {
			health=0;
		}
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}



	public GameChars getGameChars() {
		return gameChars;
	}



	public void setGameChars(GameChars gameChars) {
		this.gameChars = gameChars;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	
	
}
