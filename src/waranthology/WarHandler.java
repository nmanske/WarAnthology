package waranthology;

import java.lang.Math;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import waranthology.Card.Joker;
import waranthology.Card.Rank;
import waranthology.Card.Suit;
import waranthology.WarGui.WarGame;

public class WarHandler {
	
	public static final int NUM_RANKS = 13;

	private Player player1;
	private Player player2;
	private WarGame gameMode;
	
	public WarHandler(WarGame gameMode) {
		List<Card> deck = initDeck(gameMode);
		this.player1 = new Player("Player 1", deck.subList(0, deck.size()/2));
		this.player2 = new Player("Player 2", deck.subList(deck.size()/2, deck.size()));
		this.gameMode = gameMode;
	}
	
	public void run() {
		assignFirstPlayer();
		while (!isGameOver()) {
			printGameState();
		}
		System.out.println(getGameWinner() + " won a game of " + gameMode.getName() + "! Congrats.\n");
	}
	
	private void printGameState() {
			
	}
	
	private boolean isGameOver() {
		return player1.isOutOfCards() || player2.isOutOfCards();
	}
	
	private String getGameWinner() {
		if (player1.isOutOfCards()) return player1.getName();
		else if (player2.isOutOfCards()) return player2.getName();
		else return "Draw!";
	}
	
	private void assignFirstPlayer() {
		Random rand = new Random();
		int firstPlayer = rand.nextInt(2) + 1;			// returns a 1 (HEADS) or 2 (TAILS)
		if (firstPlayer == 1) player1.setTurn(true);
		else player2.setTurn(true);
	}
	
	private LinkedList<Card> initDeck(WarGame gameMode) {
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
	
	private LinkedList<Card> initStandardDeck() {
		LinkedList<Card> standardDeck = new LinkedList<>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				standardDeck.add(new Card(rank, suit));
			}
		}
		return standardDeck;
	}
	
	private LinkedList<Card> initCloneDeck() {
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
