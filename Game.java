package hayattaKalmaOyunu;



import java.util.Scanner;



public class Game {
	public void run() {
		Scanner scanner=new Scanner(System.in);
		
		
		//System.out.print("Evet sava���,ad�n� s�yle bana: ");
		//String nameString="Hidayet";
		GamePlayer gamePlayer=new GamePlayer("Hidayet"); //oyun bitince kullan�c�dan isim al�nacak
		System.out.println(gamePlayer.getName()+" bu zorlu d�nyada hayatta kalabilecek misin");
		System.out.println("Yoksa kadim zamanlar�n ac�mas�z yarat�klar�na yem mi olacaks�n. Devam etmek istiyorsan evet,istemiyorsan hay�r diyebilirsin.");
		
		//GameChars gameChars=new GameChars();
		/*String courage=scanner.next();
		while(courage.toLowerCase().equals("hay�r")) {
			System.out.println("Senin tam bir korkak oldu�unu anlam��t�m.");
			break;
		} */
		gamePlayer.selectChars();
		
	
		while(true) {
			gamePlayer.printInfo();
			Locations locations=null;
			System.out.println("--------------------");
			System.out.println("Nereye gitmek istersiniz?");
			System.out.println("1-G�venli ev");
			System.out.println("2-Ma�aza");
			System.out.println("3-Ma�ara! Kazan�rsan yemek yiyebilirsin,kazanamazsan onlar�n yeme�i olursun. Burada sava� ba�layacak.");
			System.out.println("4-Orman! Kazan�rsan odun sahibi olursun,kazanamzsan odun olursun. Burada sava� ba�layacak.");
			System.out.println("5-Nehir! Kazan�rsan su i�ebilirsin,kazanamazsan senin kan�n� i�erler. Burada sava� ba�layacak.");
			System.out.println("6-Maden! Kazan�rsan su i�ebilirsin,kazanamazsan senin kan�n� i�erler. Burada sava� ba�layacak.");
			System.out.print("Gitmek istedi�iniz b�lgeyi se�iniz: ");
			System.out.println();
			
			
			int loc=0;			
			while(!scanner.hasNextInt()) {
				System.out.println("L�tfen gitmek istedi�iniz b�lgeyi say� ile giriniz");
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
					System.out.println("Bu b�lgedeki t�m d��manlar� yendiniz.");
					continue;
				}
				locations=new Cave(gamePlayer);
				
				break;
			case 4:
				locations=new Forest(gamePlayer);
				if(gamePlayer.getInventory().isFireWood()) {
					System.out.println("Bu b�lgedeki t�m d��manlar� yendiniz.");
					continue;
				}
				break;
			case 5:
				locations=new River(gamePlayer);
				if(gamePlayer.getInventory().isWater()) {
					System.out.println("Bu b�lgedeki t�m d��manlar� yendiniz.");
					continue;
				}
				break;
			case 6:
				locations=new Quarry(gamePlayer);
				if(gamePlayer.getInventory().isQuarryAward()) {
					System.out.println("Bu b�lgedeki t�m d��manlar� yendiniz.");
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
				System.out.println("T�m d��manlar� yenip oyunu kazand�n�z.Sen bir kahramans�n");
				break;
				
				}
			}*/
			if(locations.onLocation()) {
				System.out.println("�ld�n�z,allah rahmet eylesin!!");
				break;
			}
			
				
			
		}
		
	scanner.close();
	}
	
}
