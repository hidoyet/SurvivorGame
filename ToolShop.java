package hayattaKalmaOyunu;

public class ToolShop extends NormalLoc{

	public ToolShop(GamePlayer gamePlayer) {
		super(gamePlayer,"Malzeme D�kkan�");
		
	}
	
	@Override
	boolean onLocation() {
		System.out.println("----------------");
		System.out.println("D�kkana ho�geldiniz");
		System.out.println("Ne vereyim abime.");
		System.out.println("1- Silahlar");
		System.out.println("2- Z�rhlar");
		System.out.println("3- ��k��");
		System.out.print("Se�iminiz:");
		int selectCase=scanner.nextInt();
		while(selectCase<1||selectCase>3)
			System.out.println("1 ile 3 aras� bir de�er giriniz");
		switch(selectCase) {
		case 1:
			showWeaponMenu();
			buyWeaponMenu();
			break;
		case 2:
			showArmourMenu();
			break;
		case 3:
			System.out.println("Bir daha bekleriz");
			return true;
		}	
		
		return true;
	}
	
	public void showWeaponMenu() {
		System.out.println("Silahlar:");		
		for(Weapons w: Weapons.weapons()) {
			System.out.println(w.getId()+" "+w.getName()+" "+w.getDamage()+" "+w.getPrice());
		}
		System.out.println("0- ��k��");
		
	}	
	public void buyWeaponMenu() {
		System.out.println("L�tfen bir silah se�iniz:");
		int selectWeapon=scanner.nextInt();
	
		while(selectWeapon<1||selectWeapon>Weapons.weapons().length) {
			
			System.out.println("L�tfen ge�erli bir de�er giriniz");
			break;
		}
		
		Weapons selectedWeapons=Weapons.getWeaponObjByID(selectWeapon);
		if(selectedWeapons!=null) {
			if(selectedWeapons.getPrice()>gamePlayer.getMoney()) {
				System.out.println("Bakiye yetersiz.");
			}else {
				System.out.println(selectedWeapons.getName()+" silah�n� ald�n�z");
				int balance=gamePlayer.getMoney()-selectedWeapons.getPrice();
				System.out.print("Kalan paran�z: "+ balance+"\n");
				System.out.println("�nceki silah�n�z: "+gamePlayer.getInventory().getWeapons().getName());
				gamePlayer.getInventory().setWeapons(selectedWeapons);
				System.out.println("Yeni silah�n�z: "+ gamePlayer.getInventory().getWeapons().getName());
			}
		}
	}
	public void showArmourMenu() {
		System.out.println("Z�rhlar:");
		for(Armor a: Armor.armor()) {
			System.out.println(a.getId()+"- "+ a.getName()+" Engelleme "+a.getBlock()+" Fiyat: "+a.getPrice());
		}
		System.out.println("0_ ��k��");
		System.out.println("L�tfen bir z�rh se�iniz:");
		int selectArmor=scanner.nextInt();
		
		Armor selectedArmor=Armor.getArmorObjByID(selectArmor);
		
		if(selectedArmor!=null) {
			if(selectedArmor.getPrice()>gamePlayer.getMoney()) {
			System.out.println("Bakiye yetersiz");
			}
			else {
				System.out.println("�nceki z�rh�n�z: "+gamePlayer.getInventory().getArmor().getName());
				int balance=gamePlayer.getMoney()-selectedArmor.getPrice();
				System.out.println("Kalan paran�z: "+balance);
				gamePlayer.getInventory().setArmor(selectedArmor);
				System.out.println("Yeni z�rh�n�z: "+gamePlayer.getInventory().getArmor().getName());
				
			}
		}
		
		
	}
	
}
