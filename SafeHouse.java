package hayattaKalmaOyunu;



public class SafeHouse extends NormalLoc{

	public SafeHouse(GamePlayer gamePlayer) {
		super(gamePlayer,"G�venli ev");
		// TODO Auto-generated constructor stub
	}	

	@Override
	boolean onLocation() {
		System.out.println("Evine Ho�geldin!");
		System.out.println("Burada istedi�in kadar dinlenip sava�a haz�r hale gelebilirsin.");
		this.getGamePlayer().setHealth(getGamePlayer().getOriginalHealth());
		return true;
	}
	
	
	
	
}
