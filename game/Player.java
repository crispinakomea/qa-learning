package game;

public class Player {

	private final String name;
	private final Compass compass;
	private int[][] position;

	public Player(String name, Compass compass, int[][] position) {
		this.name = name;
		this.compass = compass;
		compass.setDistance(position);
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void checkCompass() {
		System.out.printf("The dial reads '%.3fm'", compass.getDistance());
		System.out.println("\n");
	}

	public int[][] getPosition() {
		return position;
	}

	public void move(String direction) {
		switch (direction) {
		case "north":
			position[1][0]++;
			compass.setDistance(position);
			checkCompass();
			break;
		case "east":
			position[0][0]++;
			compass.setDistance(position);
			checkCompass();
			break;
		case "south":
			position[1][0]--;
			compass.setDistance(position);
			checkCompass();
			break;
		case "west":
			position[0][0]--;
			compass.setDistance(position);
			checkCompass();
			break;
		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", position=[" + position[0][0] + "," + position[1][0] + "]]";
	}

}
