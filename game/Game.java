package game;

import java.util.Scanner;

public class Game {

	private static final int GRID_SIZE;
	private static final String TREASURE;

	private final int[][] treasurePosition;
	private Grid grid;
	private Compass compass;
	private Player player;

	private final Scanner scanner;

	static {
		GRID_SIZE = 5;
		TREASURE = "@";
	}

	public Game() {
		grid = new Grid(GRID_SIZE);
		treasurePosition = new int[][] { { getRandomPosition() }, { getRandomPosition() }, };
		grid.addItem(TREASURE, treasurePosition);
		compass = new Compass(treasurePosition);
		player = new Player("Ruphus", compass, new int[][] { { 0 }, { 0 }, });
		compass.setDistance(player.getPosition());
		scanner = new Scanner(System.in);
	}

	public void start() {
		startGame();
		while (!(compass.getDistance() == 0.0)) {
			switch (scanner.nextLine().toLowerCase()) {
			case "move":
				printMessage("Enter the direction you want to move");
				player.move(scanner.nextLine());
				break;
			case "check":
				player.checkCompass();
				break;
			case "help":
				help();
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				printMessage("Invalid input");
				break;
			}
		}
		System.out.println("CONGRATULATIONS, " + player.getName().toUpperCase() + " YOU HAVE FOUND THE TREASURE");
	}

	private void startGame() {
		System.out.println("THE ADVENTURE OF BARREN MOOR\n");
		printMessage("Grey foggy clouds float oppressively close to you, reflected in the murky grey water.");
		printMessage("Some black plants barely poke out of the shallow water.\n");
		makePlayerDoSomething("look");
		printMessage("\nIs there anyone else out here. Maybe you could find out?");
		makePlayerDoSomething("help");
		help();
	}

	private void help() {
		printMessage("\nmove - will move yout player in the specified direction");
		printMessage("check - this command will tell you how far you are distance from the treasure");
		printMessage("exit - this command will end the game");
		printMessage("\nMake a move");
	}

	private void makePlayerDoSomething(String action) {
		do {
			printMessage("Try \"" + action + "\"");
		} while (!scanner.nextLine().toLowerCase().equals(action.toLowerCase()));
	}

	private void printMessage(String message) {
		System.out.println(message);
	}

	private int getRandomPosition() {
		return (int) (Math.random() * GRID_SIZE);
	}

}
