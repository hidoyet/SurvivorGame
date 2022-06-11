package hayattaKalmaOyunu;



public class SafeHouse extends NormalLoc{

	public SafeHouse(GamePlayer gamePlayer) {
		super(gamePlayer,"Güvenli ev");
		// TODO Auto-generated constructor stub
	}	

	@Override
	boolean onLocation() {
		System.out.println("Evine Hoþgeldin!");
		System.out.println("Burada istediðin kadar dinlenip savaþa hazýr hale gelebilirsin.");
		this.getGamePlayer().setHealth(getGamePlayer().getOriginalHealth());
		return true;
	}
	
	
	
	
}
