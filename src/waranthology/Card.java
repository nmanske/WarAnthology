package waranthology;

public class Card {
	
	public static final int RANK_JACK = 11;
	public static final int RANK_QUEEN = 12;
	public static final int RANK_KING = 13;
	public static final int RANK_ACE = 14;
	
	public static final int MIN_RANK = 2;
	public static final int MAX_RANK = RANK_ACE;
	
	private static final String ranks[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	
	private int rank;
	private String suit;
	private boolean faceUp = true;
	
	public Card(int rank, String suit) {
		if (rank > MAX_RANK || rank < MIN_RANK) {
			throw new IllegalArgumentException("Card rank must be between 2 and 14 (Ace)");
		}
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}
	
	@Override
	public String toString() {
		String faceDownText = (faceUp) ? "" : " (facedown)";
		int RANKS_OFFSET = 2;
		if (suit.equals("JOKER")) return "Joker";
		return ranks[rank-RANKS_OFFSET] + " of " + suit + faceDownText;
	}

}
