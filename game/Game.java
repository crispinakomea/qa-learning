package game;

import java.util.Scanner;

public class Game {

	private static final int GRID_SIZE;

	private Treasure treasure;
	private Map grid;
	private Compass compass;
	private Player player;

	private final Scanner scanner;

	static {
		GRID_SIZE = 11;
	}

	public Game() {
		treasure = new Treasure(new int[][] { { getRandomPosition() }, { getRandomPosition() }, });
		compass = new Compass(treasure.getPosition());
		grid = new Map(GRID_SIZE, treasure.getPosition());
		player = new Player(compass, new int[][] { { GRID_SIZE / 2 }, { GRID_SIZE / 2 }, });
		compass.setDistance(player.getPosition());
		grid.addItem(Player.SYMBOL, player.getPosition());
		scanner = new Scanner(System.in);
	}

	public void start() {
		PrintUtil.printNewLine("!!!THE ADVENTURE OF BARREN MOOR!!!");
		help();
		while (!(compass.getDistance() == 0.0)) {
			String input = scanner.nextLine().toLowerCase();
			switch (input) {
			case "m":
				grid.showMap();
				PrintUtil.print("Make a move");
				PrintUtil.print(">");
			case "c":
				player.checkCompass();
				PrintUtil.print("Make a move");
				PrintUtil.print(">");
				break;
			case "help":
				help();
				break;
			case "q":
				PrintUtil.newLinePrint("!!!THANKS FOR PLAYING, GOODBYE!!!");
				System.exit(0);
				break;
			default:
				grid.removeItem(Player.SYMBOL, player.getPosition());
				player.move(input);
				grid.addItem(Player.SYMBOL, player.getPosition());
				PrintUtil.print("Make a move");
				PrintUtil.print(">");
				break;
			}
		}
		PrintUtil.newLinePrint("!!!CONGRATULATIONS, YOU HAVE FOUND THE TREASURE!!!");
	}

	private void help() {
		PrintUtil.print("HELP");
		PrintUtil.print("[m]ap \t\t- to view the map if your in the mood for cheating");
		PrintUtil.print("[d]irection \t- will move your player in the specified \"direction\"");
		PrintUtil.print("\t\t- n for north, s for south, e for east, w for west");
		PrintUtil.print("[c]heck \t\t- this command will tell you how far you are distance from the treasure");
		PrintUtil.printNewLine("[q]uit \t\t- this command will end the game");
		PrintUtil.print("Make a move");
		PrintUtil.print(">");
	}

	private int getRandomPosition() {
		int random = (int) (Math.random() * GRID_SIZE);
		System.out.println(random);
		return random;
	}

}
