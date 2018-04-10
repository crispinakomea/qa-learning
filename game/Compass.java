package game;

public class Compass {

	private final int[][] treasurePosition;
	private double distance;

	public Compass(int[][] treasurePosition) {
		this.treasurePosition = treasurePosition;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(int[][] playerPosition) {
		double dx = treasurePosition[0][0] - playerPosition[0][0];
		double dy = treasurePosition[1][0] - playerPosition[1][0];
		distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}

}
