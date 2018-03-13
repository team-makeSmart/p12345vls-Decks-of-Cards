/**
 * The Class Hand 
 * @author Hunter Mason, Jake McGhee, Mac Dousias, Pavlos Papadonikolakis
 *  
 */
public class Hand extends Card {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		// creating a hand object and 4 card objects
		Hand hand1 = new Hand();

		Card card1 = new Card('2', Suit.diamonds);
		Card card2 = new Card('4', Suit.hearts);
		Card card3 = new Card('5', Suit.spades);
		Card card4 = new Card('T', Suit.clubs);

		// populate the hand with legal and
		// illegal values
		for (int i = 0; i < 10; i++) {
			hand1.takeCard(card1);
			hand1.takeCard(card2);
			hand1.takeCard(card3);
			card3.set('e', Suit.diamonds);
			hand1.takeCard(card3);
			hand1.takeCard(card4);
			card4.set('w', Suit.diamonds);
		}
		System.out.println(hand1.toString());

		// inspect Card at last index (first inserted)
		System.out.println("\nTesting inspectCard()");
		System.out.println(hand1.inspectCard(0));
		//change the last card to illegal
		hand1.myCards[49]=new Card('s', Suit.diamonds);
		Card test = hand1.inspectCard(49);
		System.out.println(test);

		//print all individual cards
		while (hand1.getNumOfCards() != 0) {
			Card c = hand1.playCard();
			if (c != null) {
				System.out.println("Playing " + c);
			}
		}
		 System.out.println("\nAfter playing all cards");
		 System.out.println(hand1.toString());

	}

	/** The max cards in the hand */
	public int MAX_CARDS = 52;
	
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
	 * @param card the card
	 * @return true, if successful
	 */
	public boolean takeCard(Card card) {
		
		Card copyCard = card;
		char value = copyCard.getValue();
		Suit suit = copyCard.getSuit();

		if (numCards < MAX_CARDS) {
			myCards[numCards++] = new Card(value, suit);

			if (numCards == MAX_CARDS) {
				System.out.println("\nHand Full\nAfter Deal");
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns and removes the card in the
	 * top occupied position of the array
	 *
	 * @return a deep copy of the card
	 */
	Card playCard() {

		Card[] copy = new Card[MAX_CARDS];
		if (!myCards[numCards - 1].getErrorFlag()) {
			copy[numCards - 1] = (Card) myCards[numCards - 1].clone();
		}

		return copy[--numCards];
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
				if (!getErrorFlag())
					retVal += myCards[i].getValue();

				if (myCards[i].getSuit().equals(Suit.spades))
					retVal += " of Spades";
				else if (myCards[i].getSuit().equals(Suit.hearts))
					retVal += " of Hearts";
				else if (myCards[i].getSuit().equals(Suit.diamonds))
					retVal += " of Diamonds";
				else if (myCards[i].getSuit().equals(Suit.clubs))
					retVal += " of Clubs";

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
	 * Accessor for an individual card.
	 * Returns a card with errorFlag = true if k is bad
	 *
	 * @param k the index of the card in the array
	 * @return the card
	 */
	Card inspectCard(int k) {
		assert (k >= 0 && k < numCards && numCards > 0);
		return myCards[k];

	}

}
