package game;

public class Player {

	public static final String SYMBOL;
	private Compass compass;
	private int[][] position;

	static {
		SYMBOL = "| P |";
	}

	public Player() {

	}

	public Player(Compass compass, int[][] position) {
		this.compass = compass;
		compass.setDistance(position);
		this.position = position;
	}

	public Compass getCompass() {
		return compass;
	}

	public void setCompass(Compass compass) {
		this.compass = compass;
	}

	public int[][] getPosition() {
		return position;
	}

	public void setPosition(int[][] position) {
		this.position = position;
	}

	public void checkCompass() {
		System.out.printf("The dial reads '%.3fm'", compass.getDistance());
		PrintUtil.newLine();
	}

	public void move(String direction) {
		switch (direction) {
		case "n":
			position[0][0]--;
			compass.setDistance(position);
			break;
		case "e":
			position[1][0]++;
			compass.setDistance(position);
			break;
		case "s":
			position[0][0]++;
			compass.setDistance(position);
			break;
		case "w":
			position[1][0]--;
			compass.setDistance(position);
			break;
		default:
			PrintUtil.print("Invalid direction.");
			PrintUtil.print("\ttry - n for north, s for south, e for east, w for west");
			break;
		}
	}

	@Override
	public String toString() {
		return "Player [position=[" + position[0][0] + "," + position[1][0] + "]]";
	}

}
