package waranthology;

import java.util.Scanner;

import waranthology.Card.Joker;
import waranthology.Card.Rank;
import waranthology.Card.Suit;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class WarLauncher {
	
	public static final int NUM_RANKS = 13;
	
	public enum WarGame {
		WAR("Traditional War"),
		INEVITABLE_WAR("Inevitable War"),
		SAVAGE_WAR("Savage War"),
		GALACTIC_WAR("Galactic War"),		/* Created by Lee Walker */
		CLONE_WAR("Clone War");				/* Created by Ken Scherer */
		
		public static final int CLONE_WAR_UNIQUE_FACE_COUNT = 16;
		private static final int size = WarGame.values().length;
		
		private String name;
		
		private WarGame(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public static int size() {
			return size;
		}
	}

	public static void main(String[] args) {	
		WarGame gameMode = WarLauncher.getInput();
		/*WarGame gameMode = WarGame.INEVITABLE_WAR; 
		List<Card> deck = initDeck(gameMode);
		Player player1 = new Player("Player 1", deck.subList(0, deck.size()/2));
		Player player2 = new Player("Player 2", deck.subList(deck.size()/2, deck.size()));
		WarHandler handler = new WarHandler(player1, player2, gameMode);
		handler.run();*/
	}
	
	private static void displayMenu() {
		System.out.println("=========================   ------------------------------\n" +
						   "|     WAR ANTHOLOGY     |   |        COMMAND LIST        |\n" +
						   "|-----------------------|   |----------------------------|\n" +
						   "| 1: Traditional War    |   |  #: Start game (replace #  |\n" +
						   "| 2: Inevitable War     |   |     w/ valid game number)  |\n" +
						   "| 3: Savage War         |   | i#: View game instructions |\n" +
						   "| 4: Galactic War       |   |  x: Quit                   |\n" +
						   "| 5: Clone War          |   ------------------------------\n" +
						   "=========================\n");
	}
	
	private static void displayGameInstructions(int gameNum) {
		switch (gameNum) {
			case 1:
				System.out.println();
				break;
			case 2:
				System.out.println();
				break;
			case 3:
				System.out.println();
				break;
			case 4:
				System.out.println();
				break;
			case 5:
				System.out.println();
				break;
		}
	}

	private static WarGame getInput() {
		WarGame game = null;
		Scanner sc = new Scanner(System.in);
		int gameNum = 0;
		do {
			displayMenu();
			System.out.print("Enter Command: ");
			if (sc.hasNextInt()) {
				gameNum = sc.nextInt();
				if (isValidGame(gameNum)) {
					game = WarGame.values()[gameNum-1];
				}
				else {
					System.out.println("\nInteger is not a valid game! Please try again.");
				}
			}
			else if (sc.hasNextLine()) {
				String command = sc.nextLine().substring(0,1);
				System.out.println(command);
				if (command.equalsIgnoreCase("i") || command.equalsIgnoreCase("x")) {
					
				}
				else {
					System.out.println("\nInvalid command! Please try again.");
				}
			}
			System.out.println();
		} while (!isValidGame(gameNum));
		sc.close();
		return game;
	}
	
	private static boolean isValidGame(int gameNum) {
		return gameNum <= WarGame.size() && gameNum > 0;
	}
	
	private static LinkedList<Card> initDeck(WarGame gameMode) {
		LinkedList<Card> deck = new LinkedList<>();
		switch (gameMode) {
			case CLONE_WAR:
				deck = initCloneDeck();
				break;
			default:
				deck = initStandardDeck();
				break;
		}
		if (gameMode.equals(WarGame.INEVITABLE_WAR)) {
			deck.add(new Card(Joker.JOKER));
			deck.add(new Card(Joker.JOKER));
		}
		Collections.shuffle(deck);
		return deck;
	}
	
	private static LinkedList<Card> initStandardDeck() {
		LinkedList<Card> standardDeck = new LinkedList<>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				standardDeck.add(new Card(rank, suit));
			}
		}
		return standardDeck;
	}
	
	private static LinkedList<Card> initCloneDeck() {
		LinkedList<Card> cloneDeck = new LinkedList<>();
		for (int i = Rank.JACK.ordinal(); i < NUM_RANKS; i++) {
			Rank rank = Rank.values()[i];
			for (Suit suit : Suit.values()) {
				for(int k = 0; k < WarGame.CLONE_WAR_UNIQUE_FACE_COUNT/4; k++) {
					cloneDeck.add(new Card(rank, suit));
				}
			}
		}
		return cloneDeck;
	}

}
