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
		GUERILLA_JOKER("Guerilla Joker"), 	/* Created by Ryan Hill */
		GALACTIC_WAR("Galactic War"),		/* Created by Lee Walker */
		CLONE_WAR("Clone War");				/* Created by Ken Scherer */
		
		public static final int CLONE_WAR_FACE_CARD_COUNT = 16;
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
		WarLauncher.displayMenu();
		//WarGame game = WarLauncher.getWarGame();
		WarGame gameMode = WarGame.GUERILLA_JOKER;
		List<Card> deck;
		switch (gameMode) {
			case CLONE_WAR:
				deck = initCloneDeck();
				break;
			default:
				deck = initStandardDeck();
				break;
		}
		if (gameMode.equals(WarGame.GUERILLA_JOKER)) {
			deck.add(new Card(Joker.LOW));
			deck.add(new Card(Joker.HIGH));
		}
		//Collections.shuffle(deck);
		for (Card c : deck) {
			System.out.println(c.toString());
		}
		System.out.println(deck.size());
		Player player1 = new Player("Nathan", deck.subList(0, deck.size()/2));
		Player player2 = new Player("Catherine", deck.subList(deck.size()/2, deck.size()));
		
	}
	
	private static void displayMenu() {
		System.out.println("=========================");
		System.out.println("|     WAR ANTHOLOGY     |");
		System.out.println("|-----------------------|");
		System.out.println("| 1. Traditional War    |");
		System.out.println("| 2. Guerilla Joker     |");
		System.out.println("| 3. Galactic War       |");
		System.out.println("| 4. Clone War          |");
		System.out.println("=========================\n");
	}
	

	private static WarGame getWarGame() {
		WarGame game = null;
		Scanner sc = new Scanner(System.in);
		int gameNum = 0;
		do {
			System.out.print("Enter game number to begin: ");
			if (sc.hasNextInt()) {
				gameNum = sc.nextInt();
				if (isValidGame(gameNum)) {
					game = WarGame.values()[gameNum-1];
				}
				else {
					System.out.println("\nInput is not a valid game! Please try again.");
				}
			}
			else {
				System.out.println("\nInvalid input! Please enter an integer.");
			}
			System.out.println();
		} while (!isValidGame(gameNum));
		sc.close();
		return game;
	}
	
	private static boolean isValidGame(int gameNum) {
		return gameNum <= WarGame.size() && gameNum > 0;
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
				for(int k = 0; k < WarGame.CLONE_WAR_FACE_CARD_COUNT/4; k++) {
					cloneDeck.add(new Card(rank, suit));
				}
			}
		}
		return cloneDeck;
	}

}
