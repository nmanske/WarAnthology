package waranthology;

public final class Card {
	
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
		ACE(14,"A");
		
		private int value;
		private String name;
		
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
		DIAMONDS("D");
		
		private String name;
		
		private Suit(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
	
	public enum Joker {
		LOW("J-L"),
		HIGH("J-H");
		
		private String name;
				
		private Joker(String name) {
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
	private Joker joker;
	private boolean faceUp = true;
	
	public Card(Rank rank, Suit suit) {
		assert rank 
		if (rank.getValue() < MIN_RANK || rank.getValue() > MAX_RANK) {
			throw new IllegalArgumentException("Card rank must be between 2 and 14 (Ace)");
		}
		this.rank = rank;
		this.suit = suit;
	}
	
	public Card(Joker joker) {
		this.joker = joker;
	}
	
	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
	
	public Joker getJoker() {
		return joker;
	}
	
	public boolean isJoker() {
		return joker != null;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}
	
	@Override
	public String toString() {
		return (isJoker()) ? joker.getName() : rank.getName() + '-' + suit.getName();
	}

}
