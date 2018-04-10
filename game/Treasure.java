package game;

public class Treasure {

	public static final String SYMBOL;
	private final int[][] position;

	static {
		SYMBOL = "| T |";
	}

	public Treasure(int[][] position) {
		this.position = position;
	}

	public int[][] getPosition() {
		return position;
	}

}
