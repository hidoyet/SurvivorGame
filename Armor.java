package hayattaKalmaOyunu;



public class Armor {

		int id;
		int block;
		int price;
		String name;
		
		public Armor(int id, int block, int price, String name) {
			super();
			this.id = id;
			this.block = block;
			this.price = price;
			this.name = name;
		}
		
		public static Armor[] armor() {
			Armor[] armorList= new Armor[3];
			armorList[0]=new Armor(1, 1, 15	,"Hafif Zýrh");
			armorList[1]=new Armor(2, 3,25,"Orta Zýrh");
			armorList[2]=new Armor(3 ,5,40,"Aðýr Zýrh");
			return armorList; 
			
		}
		public static Armor getArmorObjByID(int id) {
			for(Armor a: Armor.armor()) {
				if(a.getId()==id)
					return a;
			}
			return null;
			
		}
	 

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getBlock() {
			return block;
		}

		public void setBlock(int block) {
			this.block = block;
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
