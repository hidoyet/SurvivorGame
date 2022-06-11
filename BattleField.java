package hayattaKalmaOyunu;


import java.util.Random;

public class BattleField extends Locations{
	private Enemies enemies;
	public String award;
	private int maxEnemies;
	

	public BattleField(GamePlayer gamePlayer, String name,Enemies enemies,String award,int maxEnemies) {
		super(gamePlayer, name);
		this.enemies=enemies;
		this.award=award;
		this.maxEnemies=maxEnemies;
	}
	
	public int randomEnemiesNumber() {
		Random random=new Random();
		return random.nextInt(this.getMaxEnemies())+1;
	}

	@Override
	public boolean onLocation() {
	    int enemieNumber=this.randomEnemiesNumber();
	    
	    if(this.getName().equals("Maden")) {
	    	enemieNumber=this.randomSnakeNumber();
	    }
		System.out.println("Þu an buradasýnýz: "+this.getName());
		System.out.println("Dikkatli ol! Karþýna "+enemieNumber+" tane "+getEnemies().getName()+" çýkabilir.");
		System.out.print("Savaþacak kadar cesaretin var ise <e>vet,yoksa <h>ayýr de: ");
		String fightCase=scanner.next().toUpperCase();
		if(fightCase.equals("E")) {
			// savaþma iþlemi
			if(fight(enemieNumber)) {
				System.out.println(gamePlayer.getName()+" tüm düþmanlarý yendiniz ve ödül olarak "+this.getAward()+" kazandýnýz.");
				
				if(this.getName().equals("Nehir")) {
					gamePlayer.getInventory().setWater(true);
				}else if(this.getName().equals("Maðara")) {
					gamePlayer.getInventory().setFood(true);
				}else if(this.getName().equals("Orman")) {
					gamePlayer.getInventory().setFireWood(true);
				}else if(this.getName().equals("Maden")) {
					gamePlayer.getInventory().setQuarryAward(true);
				}
				return true;
			}
			System.out.println("Hadi savaþ baþlasýn");
			fight(enemieNumber);
		}
		
		
	    
		return true;
	}
	
	public boolean fight(int enemieNumber) {
		int whoHitFirst=(int)(Math.random()*2);
		for(int i=0;i<enemieNumber;i++) {
			this.getEnemies().setHealth(this.getEnemies().getOriginalHealth());
			playerStatus();
			enemieStatus(i);
			while(getGamePlayer().getHealth()>0 &&getEnemies().getHealth()>0) {
				System.out.print("Vur veya Kaç,kararýný ver: ");
				String selectFightOrRun=scanner.next().toUpperCase();
				
				if(selectFightOrRun.equals("V")){
					int enemiesDamage=getEnemies().getDamage()-getGamePlayer().getInventory().getArmor().getBlock();
					if(whoHitFirst<1) {
					System.out.println();
					System.out.println("Ýlk Sen vurdun.");
					
					getEnemies().setHealth(getEnemies().getHealth()-getGamePlayer().getTotalDamage());
					afterHit();
						if(this.getEnemies().getHealth()>0) {
						System.out.println();
						System.out.println(this.getEnemies().getName()+" size vurdu: ");
						
						
							if(enemiesDamage<0) {
							enemiesDamage=0;
							
							}
						this.getGamePlayer().setHealth(this.getGamePlayer().getHealth()-enemiesDamage);
						afterHit();
						}
					}else {
						System.out.println();
						System.out.println("Ýlk "+getEnemies().getName()+" size vurdu");
						getGamePlayer().setHealth(getGamePlayer().getHealth()-enemiesDamage);
						afterHit();
						
						if(getGamePlayer().getHealth()>0) {
							System.out.println();
							System.out.println("Sen vurdun.");
							getEnemies().setHealth(getEnemies().getHealth()-getGamePlayer().getTotalDamage());
							afterHit();
							
						}
						
					}
					
				
				}else {
					return false;
				}
				
			}
			if(getEnemies().getHealth()<getGamePlayer().getHealth()) {
				if(getEnemies().getName().equals("Yýlan")) {
					awardForSnake();
					
				}else {
				getGamePlayer().setMoney(getGamePlayer().getMoney()+getEnemies().getAward());
				System.out.println(getEnemies().getAward()+" lira kazandýnýz");
				System.out.println("Yeni bakiye: "+getGamePlayer().getMoney());
				}
			}
			if(getGamePlayer().getHealth()<=0) {				
				return false;			
			}
	
		}
		return true;
	}

	private void awardForSnake() {
		System.out.println();
		int num=(int)(Math.random()*101);
		System.out.println("tahmin numarasý"+num);
		if(num<16) {
			int numGun=(int)(Math.random()*101);
			if(numGun<=20) {
				System.out.println("Bu yýlandan "+getGamePlayer().getInventory().getWeapons().getName()+"kazandýnýz");
				getGamePlayer().getInventory().setWeapons(new Weapons("Tüfek", 3, 7, 45));
			}
			if(numGun>20&&numGun<51) {
				getGamePlayer().getInventory().setWeapons(new Weapons("Kýlýç", 2, 3, 35));
			}
			if(numGun>50&&numGun<101) {
				getGamePlayer().getInventory().setWeapons(new Weapons("Tabanca", 1, 2, 5));
			}
		}else if(num>15&&num<31) {
			int numArmor=(int)(Math.random()*101);
			if(numArmor<21) {
				System.out.println("Bu yýlandan "+getGamePlayer().getInventory().getArmor().getName()+" kazandýnýz");
				getGamePlayer().getInventory().setArmor(new Armor(3 ,5,40,"Aðýr Zýrh"));
			}
			if(numArmor>20&&numArmor<51) {
				System.out.println("Bu yýlandan "+getGamePlayer().getInventory().getArmor().getName()+" kazandýnýz");
				getGamePlayer().getInventory().setArmor(new Armor(2, 3,25,"Orta Zýrh"));
			}
			if(numArmor>50) {
				System.out.println("Bu yýlandan "+getGamePlayer().getInventory().getArmor().getName()+" kazandýnýz");
				getGamePlayer().getInventory().setArmor(new Armor(1, 1, 15	,"Hafif Zýrh"));
			}
		}else if(num>30&&num<56) {
			int numMoney=(int)(Math.random()*101);
			if(numMoney<21) {
				System.out.println("Bu yýlandan 10 para kazandýn");
				getGamePlayer().setMoney(getGamePlayer().getMoney()+10);
			}
			if(numMoney>20&&numMoney<51) {
				System.out.println("Bu yýlandan 5 para kazandýn");
				getGamePlayer().setMoney(getGamePlayer().getMoney()+5);
				
			}
			if(numMoney<101) {
				System.out.println("Bu yýlandan 1 para kazandýn");
				getGamePlayer().setMoney(getGamePlayer().getMoney()+10);
			}
			
		}else {
			System.out.println("Þansýna küs hiçbir þey kazanamadýn!");
		}
		
	}

	private void afterHit() {
		System.out.println("Canýnýz: "+gamePlayer.getHealth());
		System.out.println(enemies.getName()+" caný "+ enemies.getHealth());
		
	}

	private void enemieStatus(int i) {
		System.out.println();
		System.out.println(i+1+". "+enemies.getName()+" Deðerleri");
		System.out.println("Ödül: "+enemies.getAward());
		System.out.println("Düþman saðlýðý: "+enemies.getHealth());
		System.out.println("Düþman hasarý: "+enemies.getDamage());
		
		
	}

	private void playerStatus() {
		System.out.println("Oyuncu deðerleri:");
		System.out.println("--------------");
		System.out.println("Saðlýk: "+gamePlayer.getHealth());
		System.out.println("Hasar: "+gamePlayer.getTotalDamage());
		System.out.println("Zýrh: "+gamePlayer.getInventory().getArmor().getName());
		System.out.println("Bloklama: "+gamePlayer.getInventory().getArmor().getBlock());
		System.out.println("Kalan para: "+gamePlayer.getMoney());
		System.out.println();		
	}

	public int randomSnakeNumber() {
		Random r=new Random();
		return  r.nextInt(this.maxEnemies)+3;
	}
	public Enemies getEnemies() {
		return enemies;
	}

	public void setEnemies(Enemies enemies) {
		this.enemies = enemies;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public int getMaxEnemies() {
		return maxEnemies;
	}

	public void setMaxEnemies(int maxEnemies) {
		this.maxEnemies = maxEnemies;
	}

}
