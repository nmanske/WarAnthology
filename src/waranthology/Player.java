package waranthology;

import java.util.List;

public final class Player {
	
	private String name;
	private List<Card> hand;
	private boolean turn = false;
			
	public Player(String name, List<Card> hand) {
		this.name = name;
		this.hand = hand;
	}
	
	public Card draw() {
		return hand.remove(0);
	}
	
	public boolean isOutOfCards() {
		return hand.size() == 0;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	public boolean isTurn() {
		return turn;
	}
	
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	@Override
	public String toString() {
		return name + " - " + hand;
	}
	
}
