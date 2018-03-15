/**
 * The Class Hand
 * 
 * @author Hunter Mason, Jake McGhee, Mac Dousias, Pavlos Papadonikolakis
 * 
 */
public class Hand  {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 *            
	 */
	public static void main(String[] args) {

		// creating a hand object and 4 card objects
		Hand hand1 = new Hand();

		Card card1 = new Card('2',  Card.Suit.diamonds);
		Card card2 = new Card('4',  Card.Suit.hearts);
		Card card3 = new Card('5',  Card.Suit.spades);
		Card card4 = new Card('T',  Card.Suit.clubs);

		// populate the hand with legal and
		// illegal values
		for (int i = 0; i < 10; i++) {
			hand1.takeCard(card1);
			hand1.takeCard(card2);
			hand1.takeCard(card3);
			card3.set('e',  Card.Suit.diamonds);
			hand1.takeCard(card3);
			card4.set('w',  Card.Suit.diamonds);
			hand1.takeCard(card4);
			
		}
		System.out.println(hand1.toString());

		// inspect Card at last index (first inserted)
		System.out.println("\nTesting inspectCard()");
		System.out.println(hand1.inspectCard(0));
		// inspect illegal index 
		Card test = hand1.inspectCard(50);
		System.out.println(test);

		// print all individual cards
		while (hand1.getNumOfCards() != 0) {
			Card c = hand1.playCard();
				System.out.println("Playing " + c);
		}
		System.out.println("\nAfter playing all cards");
		System.out.println(hand1.toString());

	}

	/** The max cards in the hand */
	public int MAX_CARDS = 50;

	/** holds all the cards */
	Card[] myCards = new Card[MAX_CARDS];

	/** The number of card in the array. */
	int numCards;

	/**
	 * Default constructor
	 */
	public Hand() {
		this.numCards = 0;
	}

	/**
	 * Removes all cards from the hand
	 */
	public void resetHand() {
		numCards = 0;

	}

	/**
	 * Adds a card to the next available position in the myCards array
	 *
	 * @param card
	 *            the card
	 * @return true, if successful
	 */
	public boolean takeCard(Card card) {

		if (numCards < MAX_CARDS) {
			myCards[numCards++] = new Card(card.getValue(), card.getSuit());

			if (numCards == MAX_CARDS) {
				System.out.println("\nHand Full\nAfter Deal");
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns and removes the card in the top occupied position of the array
	 *
	 * @return a deep copy of the card
	 */
	Card playCard() {
		Card error = new Card('w', Card.Suit.spades);
		if (numCards == 0)
			return error;

		return myCards[--numCards];
	}

	/**
	 * prints the cards in the hand
	 */
	public String toString() {

		int counter = 0;

		if (numCards == 0) {
			return "\nHand = (  )";

		} else {
			String retVal = "\nHand = ( ";

			for (int i = 0; i < numCards; i++) {
				retVal += myCards[i].toString();
				if (counter + 1 != numCards)
					retVal += ",";

				counter++;

				if (counter == numCards)
					retVal += " )";
				if (counter % 6 == 0)
					retVal += "\n";
			}
			return retVal;
		}
	}

	/**
	 * Gets the number of cards.
	 *
	 * @return the number of cards
	 */
	public int getNumOfCards() {
		return numCards;
	}

	/**
	 * Accessor for an individual card. Returns a card with errorFlag = true if
	 * k is bad
	 *
	 * @param k
	 *            the index of the card in the array
	 * @return the card
	 */
	Card inspectCard(int k) {
		Card error = new Card('w', Card.Suit.spades);
		if (k < 0 || k >= numCards)
			return error;
		return myCards[k];

	}

}