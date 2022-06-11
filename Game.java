package hayattaKalmaOyunu;



import java.util.Scanner;



public class Game {
	public void run() {
		Scanner scanner=new Scanner(System.in);
		
		
		//System.out.print("Evet savaþçý,adýný söyle bana: ");
		//String nameString="Hidayet";
		GamePlayer gamePlayer=new GamePlayer("Hidayet"); //oyun bitince kullanýcýdan isim alýnacak
		System.out.println(gamePlayer.getName()+" bu zorlu dünyada hayatta kalabilecek misin");
		System.out.println("Yoksa kadim zamanlarýn acýmasýz yaratýklarýna yem mi olacaksýn. Devam etmek istiyorsan evet,istemiyorsan hayýr diyebilirsin.");
		
		//GameChars gameChars=new GameChars();
		/*String courage=scanner.next();
		while(courage.toLowerCase().equals("hayýr")) {
			System.out.println("Senin tam bir korkak olduðunu anlamýþtým.");
			break;
		} */
		gamePlayer.selectChars();
		
	
		while(true) {
			gamePlayer.printInfo();
			Locations locations=null;
			System.out.println("--------------------");
			System.out.println("Nereye gitmek istersiniz?");
			System.out.println("1-Güvenli ev");
			System.out.println("2-Maðaza");
			System.out.println("3-Maðara! Kazanýrsan yemek yiyebilirsin,kazanamazsan onlarýn yemeði olursun. Burada savaþ baþlayacak.");
			System.out.println("4-Orman! Kazanýrsan odun sahibi olursun,kazanamzsan odun olursun. Burada savaþ baþlayacak.");
			System.out.println("5-Nehir! Kazanýrsan su içebilirsin,kazanamazsan senin kanýný içerler. Burada savaþ baþlayacak.");
			System.out.println("6-Maden! Kazanýrsan su içebilirsin,kazanamazsan senin kanýný içerler. Burada savaþ baþlayacak.");
			System.out.print("Gitmek istediðiniz bölgeyi seçiniz: ");
			System.out.println();
			
			
			int loc=0;			
			while(!scanner.hasNextInt()) {
				System.out.println("Lütfen gitmek istediðiniz bölgeyi sayý ile giriniz");
				scanner.next();
			}
			loc=scanner.nextInt();
			
			
			switch(loc) {
			case 1:
				locations=new SafeHouse(gamePlayer);
				break;
			case 2:	
				locations=new ToolShop(gamePlayer);
				break;
			case 3:
				if(gamePlayer.getInventory().isFood()) {
					System.out.println("Bu bölgedeki tüm düþmanlarý yendiniz.");
					continue;
				}
				locations=new Cave(gamePlayer);
				
				break;
			case 4:
				locations=new Forest(gamePlayer);
				if(gamePlayer.getInventory().isFireWood()) {
					System.out.println("Bu bölgedeki tüm düþmanlarý yendiniz.");
					continue;
				}
				break;
			case 5:
				locations=new River(gamePlayer);
				if(gamePlayer.getInventory().isWater()) {
					System.out.println("Bu bölgedeki tüm düþmanlarý yendiniz.");
					continue;
				}
				break;
			case 6:
				locations=new Quarry(gamePlayer);
				if(gamePlayer.getInventory().isQuarryAward()) {
					System.out.println("Bu bölgedeki tüm düþmanlarý yendiniz.");
					continue;
				}
				
				break;
			default:
				locations=new SafeHouse(gamePlayer);
				break;
			}
			/*if(locations.onLocation()) {
				if(gamePlayer.getInventory().isQuarryAward()&&
					gamePlayer.getInventory().isWater()&&
					gamePlayer.getInventory().isFireWood()&&
					gamePlayer.getInventory().isFood()) {
				System.out.println("Tüm düþmanlarý yenip oyunu kazandýnýz.Sen bir kahramansýn");
				break;
				
				}
			}*/
			if(locations.onLocation()) {
				System.out.println("Öldünüz,allah rahmet eylesin!!");
				break;
			}
			
				
			
		}
		
	scanner.close();
	}
	
}
