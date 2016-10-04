package waranthology;

import java.util.List;
import java.util.LinkedList;

public final class Player {
	
	private String name;
	private List<Card> hand;
			
	public Player(String name, LinkedList<Card> hand) {
		this.name = name;
		this.hand = hand;
	}
	
	public Card draw() {
		return hand.remove(0);
	}
	
	public boolean isOutOfCards() {
		return hand.size() == 0;
	}
	
}
