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
		System.out.println("�u an buradas�n�z: "+this.getName());
		System.out.println("Dikkatli ol! Kar��na "+enemieNumber+" tane "+getEnemies().getName()+" ��kabilir.");
		System.out.print("Sava�acak kadar cesaretin var ise <e>vet,yoksa <h>ay�r de: ");
		String fightCase=scanner.next().toUpperCase();
		if(fightCase.equals("E")) {
			// sava�ma i�lemi
			if(fight(enemieNumber)) {
				System.out.println(gamePlayer.getName()+" t�m d��manlar� yendiniz ve �d�l olarak "+this.getAward()+" kazand�n�z.");
				
				if(this.getName().equals("Nehir")) {
					gamePlayer.getInventory().setWater(true);
				}else if(this.getName().equals("Ma�ara")) {
					gamePlayer.getInventory().setFood(true);
				}else if(this.getName().equals("Orman")) {
					gamePlayer.getInventory().setFireWood(true);
				}else if(this.getName().equals("Maden")) {
					gamePlayer.getInventory().setQuarryAward(true);
				}
				return true;
			}
			System.out.println("Hadi sava� ba�las�n");
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
				System.out.print("Vur veya Ka�,karar�n� ver: ");
				String selectFightOrRun=scanner.next().toUpperCase();
				
				if(selectFightOrRun.equals("V")){
					int enemiesDamage=getEnemies().getDamage()-getGamePlayer().getInventory().getArmor().getBlock();
					if(whoHitFirst<1) {
					System.out.println();
					System.out.println("�lk Sen vurdun.");
					
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
						System.out.println("�lk "+getEnemies().getName()+" size vurdu");
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
				if(getEnemies().getName().equals("Y�lan")) {
					awardForSnake();
					
				}else {
				getGamePlayer().setMoney(getGamePlayer().getMoney()+getEnemies().getAward());
				System.out.println(getEnemies().getAward()+" lira kazand�n�z");
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
		System.out.println("tahmin numaras�"+num);
		if(num<16) {
			int numGun=(int)(Math.random()*101);
			if(numGun<=20) {
				System.out.println("Bu y�landan "+getGamePlayer().getInventory().getWeapons().getName()+"kazand�n�z");
				getGamePlayer().getInventory().setWeapons(new Weapons("T�fek", 3, 7, 45));
			}
			if(numGun>20&&numGun<51) {
				getGamePlayer().getInventory().setWeapons(new Weapons("K�l��", 2, 3, 35));
			}
			if(numGun>50&&numGun<101) {
				getGamePlayer().getInventory().setWeapons(new Weapons("Tabanca", 1, 2, 5));
			}
		}else if(num>15&&num<31) {
			int numArmor=(int)(Math.random()*101);
			if(numArmor<21) {
				System.out.println("Bu y�landan "+getGamePlayer().getInventory().getArmor().getName()+" kazand�n�z");
				getGamePlayer().getInventory().setArmor(new Armor(3 ,5,40,"A��r Z�rh"));
			}
			if(numArmor>20&&numArmor<51) {
				System.out.println("Bu y�landan "+getGamePlayer().getInventory().getArmor().getName()+" kazand�n�z");
				getGamePlayer().getInventory().setArmor(new Armor(2, 3,25,"Orta Z�rh"));
			}
			if(numArmor>50) {
				System.out.println("Bu y�landan "+getGamePlayer().getInventory().getArmor().getName()+" kazand�n�z");
				getGamePlayer().getInventory().setArmor(new Armor(1, 1, 15	,"Hafif Z�rh"));
			}
		}else if(num>30&&num<56) {
			int numMoney=(int)(Math.random()*101);
			if(numMoney<21) {
				System.out.println("Bu y�landan 10 para kazand�n");
				getGamePlayer().setMoney(getGamePlayer().getMoney()+10);
			}
			if(numMoney>20&&numMoney<51) {
				System.out.println("Bu y�landan 5 para kazand�n");
				getGamePlayer().setMoney(getGamePlayer().getMoney()+5);
				
			}
			if(numMoney<101) {
				System.out.println("Bu y�landan 1 para kazand�n");
				getGamePlayer().setMoney(getGamePlayer().getMoney()+10);
			}
			
		}else {
			System.out.println("�ans�na k�s hi�bir �ey kazanamad�n!");
		}
		
	}

	private void afterHit() {
		System.out.println("Can�n�z: "+gamePlayer.getHealth());
		System.out.println(enemies.getName()+" can� "+ enemies.getHealth());
		
	}

	private void enemieStatus(int i) {
		System.out.println();
		System.out.println(i+1+". "+enemies.getName()+" De�erleri");
		System.out.println("�d�l: "+enemies.getAward());
		System.out.println("D��man sa�l���: "+enemies.getHealth());
		System.out.println("D��man hasar�: "+enemies.getDamage());
		
		
	}

	private void playerStatus() {
		System.out.println("Oyuncu de�erleri:");
		System.out.println("--------------");
		System.out.println("Sa�l�k: "+gamePlayer.getHealth());
		System.out.println("Hasar: "+gamePlayer.getTotalDamage());
		System.out.println("Z�rh: "+gamePlayer.getInventory().getArmor().getName());
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
