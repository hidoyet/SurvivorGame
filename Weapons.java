package hayattaKalmaOyunu;

public class Weapons {
	String name;
	int id,damage,price;

	public Weapons(String name,int id, int damage, int price) {
		super();
		this.id = id;
		this.damage = damage;
		this.price = price;
		this.name=name;
	}
	public static Weapons[] weapons(){
		Weapons[] weaponList=new Weapons[3];
		weaponList[0]=new Weapons("Tabanca", 1, 2, 5);
		weaponList[1]=new Weapons("Kýlýç", 2, 3, 35);
		weaponList[2]=new Weapons("Tüfek", 3, 7, 45);

		return weaponList;
	}
	
	public static Weapons getWeaponObjByID(int id) {
		for(Weapons w: Weapons.weapons()) {
			if(w.getId()==id)
				return w;
		}
		return null;
		
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
