/**
 * @author Hunter Mason, Jake McGhee, Mac Doussias, Pavlos Papadonikolakis
 * CLASS CST 338
 * Assignment 3, Module 3
 */

package assig3;

import java.util.Scanner;

public class Assig3 {
	
	static Scanner sc;
	
	public static void main(String[] args) {
		deckAndHand();
	}
	
	
	// FOR TESTING ONLY
	// TODO TRANSFER THE CONTENTS OF THIS METHOD TO THE MAIN FUNCTION BEFORE SUBMITTING
	// TODO DELETE THIS METHOD
	private static void deckAndHand() {
		// Initialize the scanner
				sc = new Scanner(System.in);
				
				int numPlayers = 0;
				Deck deck = new Deck();
				
				// Get the number of players from the user
				while (numPlayers < 1 || numPlayers > 10) {
					System.out.println("Please select the number of players (from 1 to 10):");
					numPlayers = sc.nextInt();
				}
				
				// Create a new (empty) hand for each player
				Hand[] hands = new Hand[numPlayers];
				for (int i = 0; i < hands.length; i++) {
					hands[i] = new Hand();
				}
				
				// ---- UNSHUFFLED HAND ----
				
				// Deal the cards
				dealCards(deck, hands);
				
				System.out.println("\n---------- Here are your hands from an unshuffled deck ----------");
				
				// Display each hand
				displayHands(hands);
				
				// Reset each hand
				for (Hand hand : hands) {
					hand.resetHand();
				}
				
				// ---- SHUFFLED HAND ----
				
				// Reset the deck and shuffle it
				deck = new Deck();
				deck.shuffle();
				
				// Deal the cards
				dealCards(deck, hands);
				
				System.out.println("\n---------- Here are your hands from a shuffled deck ----------");
				
				// Display each hand
				displayHands(hands);
				
				
	}
	
	/**
	 * Deals cards to each hand, one card per hand at a time, until the deck is empty
	 * @parm deck - the deck that is being dealt from
	 * @param hands - the array of Hand objects that the deck is being dealt into
	 */
	private static void dealCards(Deck deck, Hand [] hands) {
		Card card;
		
		while (deck.getNumCards() != 0) {
			for (Hand hand : hands) {
				card = deck.dealCard();
				if (!card.getErrorFlag()) {
					hand.takeCard(card);
				}
			}
		}
		
	}
	
	/**
	 * Used to display an array of hands
	 * @param hands - the array of Hand objects that will be displayed
	 */
	private static void displayHands(Hand [] hands) {
		for (int i = 0; i < hands.length; i++) {
				System.out.printf("\n----- Hand %d -----"
					+ "\n%s\n", i+1, hands[i].toString());
		}	
	}
	
	private static void testCard() {
		 //Create card objects for testing
	      Card card1 = new Card('A', Card.Suit.SPADES);
	      Card card2 = new Card('s',  Card.Suit.SPADES);
	      Card card3 = new Card('J',  Card.Suit.CLUBS);
	      
	      //Check if valid by looking at console output
	      System.out.println(card1.toString());
	      System.out.println(card2.toString());
	      System.out.println(card3.toString());
	      
	      //Create a space on console
	      System.out.println();
	       
	      //Create card objects for testing
	      Card card4 = new Card('d',  Card.Suit.SPADES);
	      Card card5 = new Card('Q',  Card.Suit.SPADES);
	      Card card6 = new Card('J',  Card.Suit.CLUBS);

	      //Check if valid by looking at console output
	      System.out.println(card4.toString());
	      System.out.println(card5.toString());
	      System.out.println(card6.toString());
	}
	
	private static void testHand() {
		  // Create a hand object and 4 card objects
	      Hand hand1 = new Hand();
	      Card card1 = new Card('2',  Card.Suit.DIAMONDS);
	      Card card2 = new Card('4',  Card.Suit.HEARTS);
	      Card card3 = new Card('5',  Card.Suit.SPADES);
	      Card card4 = new Card('T',  Card.Suit.CLUBS);

	      // Populate the hand with legal and
	      // Illegal values
	      for (int i = 0; i < 10; i++) 
	      {
	         hand1.takeCard(card1);
	         hand1.takeCard(card2);
	         hand1.takeCard(card3);
	         card3.set('e',  Card.Suit.DIAMONDS);
	         hand1.takeCard(card3);
	         card4.set('w',  Card.Suit.DIAMONDS);
	         hand1.takeCard(card4);   
	      }
	      
	      // Print to console
	      System.out.println(hand1.toString());

	      // Inspect Card at last index (first inserted)
	      System.out.println("\nTesting inspectCard()");
	      System.out.println(hand1.inspectCard(0));
	      
	      // Inspect illegal index 
	      Card test = hand1.inspectCard(50);
	      System.out.println(test);

	      // Print all individual cards
	      while (hand1.getNumOfCards() != 0) 
	      {
	         Card c = hand1.playCard();
	         System.out.println("Playing " + c);
	      }
	      
	      System.out.println("\nAfter playing all cards");
	      System.out.println(hand1.toString());
	}
	
	private static void testDeck() {
		  final int MAX_HANDS = 10;
	      Hand[] hands = new Hand[MAX_HANDS];
	      for (int i = 0; i < MAX_HANDS; i++)
	      {
	         hands[i] = new Hand();
	      }

	      int k = 0, numHands;
	      Deck deck = new Deck(1);

	      sc = new Scanner(System.in);

	      // Input
	      // do {
	      System.out.print("How many hands? (1 - " + MAX_HANDS + ", please) ");

	      numHands = sc.nextInt();
	      System.out.println(numHands + " hands:");
	      // } while (numHands < 1 || numHands > MAX_HANDS);

	      // Unshuffled
	      while (deck.getNumCards() > 0)
	      {
	         for (k = 0; k < numHands; k++)
	         {
	            if (deck.getNumCards() == 0)
	               break;
	            hands[k].takeCard(deck.dealCard());
	         }

	      }

	      System.out.println("\nUnshuffled deck:");
	      for (k = 0; k < numHands; k++)
	      {
	         System.out.println(hands[k]);
	      }

	      // shuffled
	      deck.init(1);
	      deck.shuffle();

	      // clear hands
	      for (k = 0; k < numHands; k++)
	         hands[k].resetHand();
	      
	      while (deck.getNumCards() > 0)
	      {
	         for (k = 0; k < numHands; k++)
	         {
	            if (deck.getNumCards() == 0)
	               break;

	            hands[k].takeCard(deck.dealCard());
	         }
	      }

	      System.out.println("\n\n Shuffled deck:");
	      for (k = 0; k < numHands; k++)
	      {
	         System.out.println(hands[k].toString());
	      }
	}
}


//------------------------ CARD CLASS ----------------------------------


class Card {
	
   /** Constant array of valid card values acceptable for program */ 
   public static final char[] VALID_CARD_VALUES = {'2', '3', '4', 
      '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};      
      
   /**
    * Enumerated Suit values
    */
   public enum Suit 
   {   
      CLUBS, DIAMONDS, HEARTS, SPADES
   } 

   /** Card value (e.g. 1,2,3,..., 9, T, J, K Q, A) */
   private char value;
   
   /** Card suit */
   private Suit suit;
   
   /** Error flag, keeps track of invalid entries.   
    *  If true, card object does not have valid data
    * */
   private boolean errorFlag;

    
   /**
    * Default Constructor
    * Instantiates a new card as Ace of Spades
    */
   public Card() 
   {
      this.value = 'A';
      this.suit = Suit.SPADES;
   }
    
   /**
    * Constructor
    * Instantiates a new card, by calling the set() method
    * @param value  the value
    * @param suit the suit
    */
   public Card(char value, Suit suit) 
   {
      set(value, suit);
   }
   
   /**
    * Returns a string based on the value and suit instance variables
    */
   public String toString() 
   {
      if(errorFlag == true) //Card does not contain valid data
      {
         return "** illegal **"; //Returns an error message
      } 
      else 
      {
         //Get char value, convert to string, and store in variable
         String returnValue = String.valueOf(getValue());
        
         //Concatenate returnValue with a string relating to suit
         if (suit == Suit.SPADES)
            returnValue += " of Spades";
         else if (suit == Suit.HEARTS)
            returnValue += " of Hearts";
         else if (suit == Suit.DIAMONDS)
            returnValue += " of Diamonds";
         else if (suit == Suit.CLUBS)
            returnValue += " of Clubs";
         
         return returnValue;
      }
   }
    
   /**
    * Sets the value and the suit
    * @param value the value
    * @param suit the suit
    * @return true, if successful     
    */
   public boolean set(char value, Suit suit) 
   {
      if (!isValid(value, suit)) 
      {
         errorFlag = true;
            return false;
      }
      this.suit = suit;
      this.value = value;
      errorFlag = false;
      return true;     
   }
    
   /**
    * Gets the errorFlag 
    * @return the error flag
    */
   public boolean getErrorFlag() 
   {
      return errorFlag;
   }
    
   /**
    * Gets the suit
    * @return the suit
    */
   public Suit getSuit() 
   {
      return this.suit;
   }
    
   /**
    * Gets the value
    * @return the value
    */
   public char getValue() 
   {
      return value;
   }
    
   /**
    * Checks for equal values
    */
   @Override
   public boolean equals(Object obj) 
   {
      final Card other = (Card) obj;
      
      if (this == obj) 
      {
         return true;
      }        
      
      if (obj == null || getClass() != obj.getClass() || this.value != 
      other.value || this.errorFlag != other.errorFlag || this.suit != 
      other.suit) 
      {
         return false;
      }
      
      return true;
    }
   
   /**
    * Checks if is the values entered by the user are valid.
    * @param value the value
    * @param suit the suit
    * @return true, if all values are valid
    */
   private boolean isValid(char value, Suit suit) 
   {
     for(char val : VALID_CARD_VALUES) 
     {
        if(value == val) 
        {
           return true; //The value argument found in VALID_CARD_VALUES array
        }        
     }
     return false; // The value argument was not found  
   }
   
}

//------------------------ HAND CLASS ----------------------------------

class Hand  
{
   /** The max cards in the hand */
   public static final int MAX_CARDS = 50; 

   /** holds all the cards */
   private Card[] myCards = new Card[MAX_CARDS]; 

   /** The number of card in the array. */
   private int numCards;

   /**
    * Default constructor
    */
   public Hand() 
   {
      this.numCards = 0;
   }

   /**
    * Removes all cards from the hand
    */
   public void resetHand()
   {
      numCards = 0;
      myCards = new Card[MAX_CARDS]; 
   }

   /**
    * Adds a card to the next available position in the myCards array
    * @param card the card
    * @return true, if successful
    */
   public boolean takeCard(Card card) 
   {
      if (numCards < MAX_CARDS) 
      {
         // Makes a copy of new card and stores in index.  Then increments numCards.
         myCards[numCards++] = new Card(card.getValue(), card.getSuit());

         if (numCards == MAX_CARDS) // The hand is full  
         {
          //TODO takeCard should not print to screen.  It should just return true/false 
          //TODO printing to the screen should be handled in the main() part of the program  
          //TODO Changes here will affect main() as well and will need changes in main() too
          //  System.out.println("\nHand Full\nAfter Deal");  
            return false;
         }
      }
      return true;
   }

   /**
    * Returns and removes the card in the top occupied position of the array
    * @return a deep copy of the card
    */
   Card playCard() //TODO is this deleting from the array for cards?  Card values still left in array
   {
      Card errorCard = new Card('w', Card.Suit.SPADES);
      if (numCards == 0)
         return errorCard;
      return myCards[--numCards];
   }

   /**
    * Prints value and suit for all the cards in the hand
    */
   public String toString() 
   {
      int counter = 0;   //Keeps place of cards in the hand
      if (numCards == 0) //There are no cards in the hand
      {
         return "\nHand = (  )";
      } 
      else //There are cards in the hand
      {
         String returnVal = "\nHand = ( ";
          
         for (int i = 0; i < numCards; i++) 
         {
            returnVal += myCards[i].toString();
            if ((counter + 1) != numCards)
               returnVal += ", ";
            	counter++;
            //Check if reached end of hand
            if (counter == numCards)
               returnVal += " )";
            
            //If more than sixth card, go to newline         
            if (counter % 6 == 0)
               returnVal += "\n";
         }
         return returnVal;
      }
   }

   /**
    * Gets the number of cards.
    * @return the number of cards
    */
   public int getNumOfCards() 
   {
      return numCards;
   }

   /**
    * Accessor for an individual card. Returns a card with errorFlag = true if
    * k is bad
    * @param k : the index of the card in the array
    * @return the card
    */
   Card inspectCard(int k) 
   {
      Card errorCard = new Card('w', Card.Suit.SPADES);
      if (k < 0 || k >= numCards)
         return errorCard;
      return myCards[k];
   }

}


// ------------------------ DECK CLASS ----------------------------------

class Deck
{
   
   public final static int MAX_CARDS = 52;
   private static Card[] masterPack = new Card[MAX_CARDS];

   private Card[] cards = new Card[MAX_CARDS];
   private int topCard;
   private int numPacks;

   public Deck(int numPacks)
   {
      allocateMasterPack();
      init(numPacks);
   }

   public Deck()
   {
      allocateMasterPack();
      init(1);
   }

   public static void allocateMasterPack()
   {
      int k = 0, j = 0;
      Card.Suit suit;
      char value;

      boolean firstTime = true;
      if (!firstTime)
         return;
      firstTime = false;
      
      for (k = 0; k < Card.Suit.values().length; k++)
      {
         suit = Card.Suit.values()[k];

         masterPack[13 * k] = new Card('A', suit);
         for (value = '2', j = 1; value <= '9'; value++, j++)
         {
            masterPack[13 * k + j] = new Card(value, suit);
            masterPack[13 * k + 9] = new Card('T', suit);
            masterPack[13 * k + 10] = new Card('J', suit);
            masterPack[13 * k + 11] = new Card('Q', suit);
            masterPack[13 * k + 12] = new Card('K', suit);
         }
      }
      // System.out.println("\n----------------masterpack-------------");
      // for (Card c : masterPack) {
      // System.out.println(c);
      // }

   }

   public void init(int numPacks)
   {
      // Allocate card array with the total amount of cards
      cards = new Card[numPacks * 52];

      int k = 0, pack = 0;

      // Only allow a valid number of cards in the deck
      if (numPacks < 1 || numPacks > 6)
         numPacks = 1;

      // Add cards to the array by making copies from the master pack
      for (pack = 0; pack < numPacks; pack++)
      {
         for (k = 0; k < 52; k++)
            cards[(pack * 52 + k)] = masterPack[k];
      }
      this.numPacks = numPacks;
      topCard = numPacks * 52;

      // System.out.println("-----init---------------------" + topCard);
      // for (Card c : cards) {
      // System.out.println(c);
      // }
   }

   public void shuffle()
   {
      for (int i = 0; i < cards.length; i++)
      {
         // Get a random index in the deck
         int randomIndex = (int) (Math.random() * cards.length);

         // Make a copy of the current card
         Card temp = cards[i];

         // Swap the current and the card at the random index
         cards[i] = cards[randomIndex];
         cards[randomIndex] = temp;
      }
   }

   public Card dealCard()
   {
      Card error = new Card('s', Card.Suit.DIAMONDS);

      if (topCard == 0)
         return error;
      else
         return cards[--topCard];
   }

   public Card inspectCard(int k)
   {

      Card error = new Card('s', Card.Suit.DIAMONDS);

      if (k < 0 || k >= topCard)
         return error;
      else
         return cards[k];
   }

   public int getNumCards()
   {
      return topCard;
   }
   
}


