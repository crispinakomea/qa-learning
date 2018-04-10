package game;

public class Grid {

	private static final String EMPTY_CELL;
	String[][] grid;

	static {
		EMPTY_CELL = "'";
	}

	public Grid(int size) {
		grid = new String[size][size];
		initialize();
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

	public void moveItem(String item, int[][] oldPosition, int[][] newPosition) {
		grid[oldPosition[0][0]][oldPosition[1][0]] = EMPTY_CELL;
		grid[newPosition[0][0]][newPosition[1][0]] = item;
	}

	public void showGrid() {
		for (String[] row : grid) {
			for (String value : row) {
				System.out.print(value + "\t");
			}
			System.out.println("\n");
		}
	}

}
