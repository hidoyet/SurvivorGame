package hayattaKalmaOyunu;

public class ToolShop extends NormalLoc{

	public ToolShop(GamePlayer gamePlayer) {
		super(gamePlayer,"Malzeme Dükkaný");
		
	}
	
	@Override
	boolean onLocation() {
		System.out.println("----------------");
		System.out.println("Dükkana hoþgeldiniz");
		System.out.println("Ne vereyim abime.");
		System.out.println("1- Silahlar");
		System.out.println("2- Zýrhlar");
		System.out.println("3- Çýkýþ");
		System.out.print("Seçiminiz:");
		int selectCase=scanner.nextInt();
		while(selectCase<1||selectCase>3)
			System.out.println("1 ile 3 arasý bir deðer giriniz");
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
		System.out.println("0- Çýkýþ");
		
	}	
	public void buyWeaponMenu() {
		System.out.println("Lütfen bir silah seçiniz:");
		int selectWeapon=scanner.nextInt();
	
		while(selectWeapon<1||selectWeapon>Weapons.weapons().length) {
			
			System.out.println("Lütfen geçerli bir deðer giriniz");
			break;
		}
		
		Weapons selectedWeapons=Weapons.getWeaponObjByID(selectWeapon);
		if(selectedWeapons!=null) {
			if(selectedWeapons.getPrice()>gamePlayer.getMoney()) {
				System.out.println("Bakiye yetersiz.");
			}else {
				System.out.println(selectedWeapons.getName()+" silahýný aldýnýz");
				int balance=gamePlayer.getMoney()-selectedWeapons.getPrice();
				System.out.print("Kalan paranýz: "+ balance+"\n");
				System.out.println("Önceki silahýnýz: "+gamePlayer.getInventory().getWeapons().getName());
				gamePlayer.getInventory().setWeapons(selectedWeapons);
				System.out.println("Yeni silahýnýz: "+ gamePlayer.getInventory().getWeapons().getName());
			}
		}
	}
	public void showArmourMenu() {
		System.out.println("Zýrhlar:");
		for(Armor a: Armor.armor()) {
			System.out.println(a.getId()+"- "+ a.getName()+" Engelleme "+a.getBlock()+" Fiyat: "+a.getPrice());
		}
		System.out.println("0_ Çýkýþ");
		System.out.println("Lütfen bir zýrh seçiniz:");
		int selectArmor=scanner.nextInt();
		
		Armor selectedArmor=Armor.getArmorObjByID(selectArmor);
		
		if(selectedArmor!=null) {
			if(selectedArmor.getPrice()>gamePlayer.getMoney()) {
			System.out.println("Bakiye yetersiz");
			}
			else {
				System.out.println("Önceki zýrhýnýz: "+gamePlayer.getInventory().getArmor().getName());
				int balance=gamePlayer.getMoney()-selectedArmor.getPrice();
				System.out.println("Kalan paranýz: "+balance);
				gamePlayer.getInventory().setArmor(selectedArmor);
				System.out.println("Yeni zýrhýnýz: "+gamePlayer.getInventory().getArmor().getName());
				
			}
		}
		
		
	}
	
}
