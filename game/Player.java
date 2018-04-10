package game;

public class Player {

	private final String name;
	private int[][] position;

	public Player(String name, int[][] centrePosition) {
		this.name = name;
		position = centrePosition;
	}

	public String getName() {
		return name;
	}

	public int[][] getPosition() {
		return position;
	}

	public void move(String direction) {
		switch (direction) {
		case "north":
			position[1][0]++;
			break;
		case "east":
			position[0][0]++;
			break;
		case "south":
			position[1][0]--;
			break;
		case "west":
			position[0][0]--;
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
