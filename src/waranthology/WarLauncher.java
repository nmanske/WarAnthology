package waranthology;

import java.util.Scanner;

import waranthology.Card.Rank;
import waranthology.Card.Suit;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class WarLauncher {
	
	public static final int NUM_RANKS = 13;
	public static final int NUM_SUITS = 4;
	
	public enum WarGame {
		WAR("War");
		
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
		WarGame game = WarGame.WAR;
		List<Card> deck = WarLauncher.initDeck();
		//Player player1 = new Player("Nathan", deck.subList(0, deck.size()/2));
		//Player player2 = new Player("Catherine", deck.subList(deck.size()/2, deck.size());		
	}
	
	private static void displayMenu() {
		System.out.println("===================");
		System.out.println("|  WAR ANTHOLOGY  |");
		System.out.println("===================\n");
		System.out.println("1. Traditional War \n");
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
	
	private static List<Card> initDeck() {
		List<Card> deck = new LinkedList<>();
		for (int i = 0; i < NUM_RANKS; i++) {
			Rank rank = Rank.values()[i];
			for (int j = 0; j < NUM_SUITS; j++) {
				Suit suit = Suit.values()[j];
				deck.add(new Card(rank, suit));
			}
		}
		Collections.shuffle(deck);
		return deck;
	}

}
