/**
 * The Class Card.
 * @author Hunter Mason, Jake McGhee, Mac Dousias, Pavlos Papadonikolakis
 */
public class Card implements Cloneable {

	/**
	 *  Enumerated Suit values
	 */
	public enum Suit {
		clubs, diamonds, hearts, spades
	}

	/** card value. */
	private char value;

	/** card suit. */
	private Suit suit;

	/** error flag, keeps track of invalid entries */
	private boolean errorFlag;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 *            
	 */
	public static void main(String[] args) {
		
		//testing three cards two valid and one invalid
		Card c1 = new Card('A', Suit.spades);
		Card c2 = new Card('s', Suit.spades);
		Card c3 = new Card('J', Suit.clubs);

		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());

		System.out.println();
		
		//testing three more cards two valid and one invalid
		Card c4 = new Card('d', Suit.spades);
		Card c5 = new Card('Q', Suit.spades);
		Card c6 = new Card('J', Suit.clubs);

		System.out.println(c4.toString());
		System.out.println(c5.toString());
		System.out.println(c6.toString());

	}

	/**
	 * Instantiates a new card.
	 */
	public Card() {
		this.value = 'A';
		this.suit = Suit.spades;
	}

	/**
	 * Instantiates a new card, by calling the set() method
	 *
	 * @param value  the value
	 *           
	 * @param suit the suit
	 *            
	 */
	public Card(char value, Suit suit) {
		set(value, suit);
	}

	/**
	 * returns a cloned object
	 */
	public Object clone() {

		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Sets the value and the suit
	 *
	 * @param value the value
	 *            
	 * @param suit the suit
	 *            
	 * @return true, if successful
	 */
	public boolean set(char value, Suit suit) {

		if (isValid(value, suit)) {
			this.suit = suit;
			this.value = value;
			errorFlag = false;
			return true;
		}
		errorFlag = true;
		return false;

	}

	/**
	 * Checks if is the values entered by the user are valid.
	 *
	 * @param value the value
	 *            
	 * @param suit the suit
	 *            
	 * @return true, if is valid
	 */
	public boolean isValid(char value, Suit suit) {
		return (value == 'A' || value == 'K' || value == 'Q' || value == 'J' || value == 'T'
				|| (value >= '2' && value <= '9'))
				&& (suit == Suit.clubs || suit == Suit.diamonds || suit == Suit.hearts || suit == Suit.spades);
	}

	/**
	 * prints the cards
	 */
	public String toString() {
		if (errorFlag == true) {
			return "** illegal **";
		} else {

			String retVal = String.valueOf(getValue());

			if (suit == Suit.spades)
				retVal += " of Spades";
			else if (suit == Suit.hearts)
				retVal += " of Hearts";
			else if (suit == Suit.diamonds)
				retVal += " of Diamonds";
			else if (suit == Suit.clubs)
				retVal += " of Clubs";
			return retVal;
		}
	}

	/**
	 * Gets the error flag.
	 *
	 * @return the error flag
	 */
	public boolean getErrorFlag() {
		return errorFlag;
	}

	/**
	 * Gets the suit.
	 *
	 * @return the suit
	 */
	public Suit getSuit() {
		return this.suit;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public char getValue() {
		return value;
	}

	/**
	 * checks for equal values
	 */
	@Override
	public boolean equals(Object obj) {
		final Card other = (Card) obj;
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass() || this.value != other.value
				|| this.errorFlag != other.errorFlag || this.suit != other.suit) {
			return false;
		}

		return true;
	}

}
