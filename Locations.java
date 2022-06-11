package hayattaKalmaOyunu;

import java.util.Scanner;

public  abstract class  Locations {
	GamePlayer gamePlayer;
	public GamePlayer getGamePlayer() {
		return gamePlayer;
	}

	public void setGamePlayer(GamePlayer gamePlayer) {
		this.gamePlayer = gamePlayer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;	
	public static Scanner scanner=new Scanner(System.in);
	public Locations(GamePlayer gamePlayer, String name) {
		super();
		this.gamePlayer = gamePlayer;
		this.name = name;
	}

	abstract boolean onLocation();	
}
