package waranthology;

public class Card {
	
	public enum Rank {
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		JACK(11,"J"),
		QUEEN(12,"Q"),
		KING(13,"K"),
		ACE(14,"A"),
		JOKER;
		
		private int value;
		private String name;
		
		private Rank() {
			this.value = 15;
			this.name= "";
		}
		
		private Rank(int value) {
			this.value = value;
			this.name = String.valueOf(value);
		}
		
		private Rank(int value, String name) {
			this.value = value;
			this.name= name;
		}
		
		public int getValue() {
			return value;
		}
		
		public String getName() {
			return name;
		}
	}
	
	public enum Suit {
		HEARTS("H"),
		SPADES("S"),
		CLUBS("C"),
		DIAMONDS("D"),
		JOKER("J");
		
		private String name;
		
		private Suit(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
	
	public static final int MIN_RANK = Rank.TWO.getValue();
	public static final int MAX_RANK = Rank.ACE.getValue();
	
	private Rank rank;
	private Suit suit;
	private boolean faceUp = true;
	
	public Card(Rank rank, Suit suit) {
		if (rank.getValue() < MIN_RANK || rank.getValue() > MAX_RANK) {
			throw new IllegalArgumentException("Card rank must be between 2 and 14 (Ace)");
		}
		this.rank = rank;
		this.suit = suit;
	}
	
	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
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
		return (suit.getName().equals(Suit.JOKER.getName())) ? 
				suit.getName() : 
				rank.getName() + suit.getName().charAt(0);
	}

}
