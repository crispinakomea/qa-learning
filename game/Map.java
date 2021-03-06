package game;

public class Map {

	private static final String EMPTY_CELL;

	private final String[][] grid;

	static {
		EMPTY_CELL = "|   |";
	}

	public Map(int size, int[][] treasurePosition) {
		grid = new String[size][size];
		initialize();
		addItem(Treasure.SYMBOL, treasurePosition);
	}

	private void initialize() {
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid.length; column++) {
				grid[row][column] = EMPTY_CELL;
			}
		}
	}

	public void addItem(String item, int[][] position) {
		grid[position[0][0]][position[1][0]] = item;
	}

	public void removeItem(String item, int[][] position) {
		grid[position[0][0]][position[1][0]] = EMPTY_CELL;
	}

	public void showMap() {
		for (String[] row : grid) {
			for (String value : row) {
				System.out.print(value + "\t");
			}
			System.out.println("\n");
		}
	}

}
