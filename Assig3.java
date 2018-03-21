/**
 * @author Hunter Mason, Jake McGhee, Mac Doussias, Pavlos Papadonikolakis
 * CLASS CST 338
 * Assignment 3, Module 3
 */

import java.util.Scanner;

public class Assig3
{
   static Scanner sc;

   public static void main(String[] args)
   {
      System.out.println("-------------------Testing Card Class------------------------");

      testCard();
      System.out.println("------------------------End of  Test------------------------");

      System.out.println("\n-------------------Testing Hand  Class------------------------");

      testHand();
      System.out.println("-------------------End of Test------------------------");

      System.out.println("-------------------Testing Deck  Class------------------------");

      testDeck();
      System.out.println("-------------------End of Test------------------------");

      final int MAX_HANDS = 10;
      Hand[] hands = new Hand[MAX_HANDS];

      for (int i = 0; i < MAX_HANDS; i++)
      {
         hands[i] = new Hand();
      }

      int k = 0, numHands = 0;
      Deck deck = new Deck(1);
      Scanner scann = new Scanner(System.in);

      // Get user input.
      while (true)
      {

         System.out.print("How many hands? (1 - " + MAX_HANDS + ", please) or (-1 to exit): ");
         numHands = scann.nextInt();

         if (numHands < 1 || numHands > MAX_HANDS)
         {
            System.out.println("Program exiting");
            return;
         }

         System.out.println(numHands + " hands:");

         // Display the deck before shuffling.
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

         // Display the deck after shuffling.
         deck.init(1);
         deck.shuffle();

         // Clear the hand.
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

   private static void testCard()
   {
      // Create card objects for testing
      Card card1 = new Card('A', Card.Suit.SPADES);
      Card card2 = new Card('s', Card.Suit.SPADES);
      Card card3 = new Card('J', Card.Suit.CLUBS);

      // Check if valid by looking at console output
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());

      // Create a space on console
      System.out.println();

      // Create card objects for testing
      Card card4 = new Card('d', Card.Suit.SPADES);
      Card card5 = new Card('Q', Card.Suit.SPADES);
      Card card6 = new Card('J', Card.Suit.CLUBS);

      // Check if valid by looking at console output
      System.out.println(card4.toString());
      System.out.println(card5.toString());
      System.out.println(card6.toString());
   }

   private static void testHand()
   {
      // Create a hand object and 4 card objects
      Hand hand1 = new Hand();
      Card card1 = new Card('2', Card.Suit.DIAMONDS);
      Card card2 = new Card('4', Card.Suit.HEARTS);
      Card card3 = new Card('5', Card.Suit.SPADES);
      Card card4 = new Card('T', Card.Suit.CLUBS);

      // Populate the hand with legal and
      // Illegal values
      for (int i = 0; i < 10; i++)
      {
         hand1.takeCard(card1);
         hand1.takeCard(card2);
         hand1.takeCard(card3);
         card3.set('e', Card.Suit.DIAMONDS);
         hand1.takeCard(card3);
         card4.set('w', Card.Suit.DIAMONDS);
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

   private static void testDeck()
   {
      final int MAX_HANDS = 10;
      Hand[] hands = new Hand[MAX_HANDS];
      for (int i = 0; i < MAX_HANDS; i++)
      {
         hands[i] = new Hand();
      }

      int k = 0, numHands;
      Deck deck = new Deck(1);
      
      sc = new Scanner(System.in);

      System.out.print("How many hands? (1 - " + MAX_HANDS + ", please) ");

      numHands = sc.nextInt();
      System.out.println(numHands + " hands:");

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

// ------------------------ CARD CLASS ----------------------------------

class Card
{

   /** Constant array of valid card values acceptable for program */
   public static final char[] VALID_CARD_VALUES =
   { '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A' };

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

   /**
    * Error flag, keeps track of invalid entries. If true, card object does not
    * have valid data
    */
   private boolean errorFlag;

   /**
    * Default Constructor Instantiates a new card as Ace of Spades
    */
   public Card()
   {
      this.value = 'A';
      this.suit = Suit.SPADES;
   }

   /**
    * Constructor Instantiates a new card, by calling the set() method
    * 
    * @param value
    *           the value
    * @param suit
    *           the suit
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
      if (errorFlag == true) // Card does not contain valid data
      {
         return "** illegal **"; // Returns an error message
      } else
      {
         // Get char value, convert to string, and store in variable
         String returnValue = String.valueOf(getValue());

         // Concatenate returnValue with a string relating to suit
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
    * 
    * @param value
    *           the value
    * @param suit
    *           the suit
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
    * 
    * @return the error flag
    */
   public boolean getErrorFlag()
   {
      return errorFlag;
   }

   /**
    * Gets the suit
    * 
    * @return the suit
    */
   public Suit getSuit()
   {
      return this.suit;
   }

   /**
    * Gets the value
    * 
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

      if (obj == null || getClass() != obj.getClass() || this.value != other.value || this.errorFlag != other.errorFlag
            || this.suit != other.suit)
      {
         return false;
      }

      return true;
   }

   /**
    * Checks if is the values entered by the user are valid.
    * 
    * @param value
    *           the value
    * @param suit
    *           the suit
    * @return true, if all values are valid
    */
   private boolean isValid(char value, Suit suit)
   {
      for (char val : VALID_CARD_VALUES)
      {
         if (value == val)
         {
            return true; // The value argument found in VALID_CARD_VALUES array
         }
      }
      return false; // The value argument was not found
   }

}

// ------------------------ HAND CLASS ----------------------------------

class Hand
{
   /** The max cards in the hand */
   public static final int MAX_CARDS = 60;

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
    * 
    * @param card
    *           the card
    * @return true, if successful
    */
   public boolean takeCard(Card card)
   {
      if (numCards < MAX_CARDS)
      {
         // Makes a copy of new card and stores in index. Then increments numCards.
         myCards[numCards++] = new Card(card.getValue(), card.getSuit());

         if (numCards == MAX_CARDS) // The hand is full
         {
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
   Card playCard() // TODO is this deleting from the array for cards? Card values still left in
                   // array
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
      int counter = 0; // Keeps place of cards in the hand
      if (numCards == 0) // There are no cards in the hand
      {
         return "\nHand = (  )";
      } else // There are cards in the hand
      {
         String returnVal = "\nHand = ( ";

         for (int i = 0; i < numCards; i++)
         {
            returnVal += myCards[i].toString();
            if ((counter + 1) != numCards)
               returnVal += ", ";
            counter++;
            // Check if reached end of hand
            if (counter == numCards)
               returnVal += " )";

            // If more than sixth card, go to newline
            if (counter % 6 == 0)
               returnVal += "\n";
         }
         return returnVal;
      }
   }

   /**
    * Gets the number of cards.
    * 
    * @return the number of cards
    */
   public int getNumOfCards()
   {
      return numCards;
   }

   /**
    * Accessor for an individual card. Returns a card with errorFlag = true if k is
    * bad
    * 
    * @param k
    *           : the index of the card in the array
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

   /*
    * Creates a masterPack of 52 unique cards with all the valid possible unique
    * combinations of the card values and suits Checks to ensure that it has not
    * been called before by checking if the masterPack instance variable array was
    * already initialized. It does not execute if masterPack was already
    * initialized. note if masterPack[] contains only null values, it contains no
    * objects and therefore must not have been initialized.
    */
   private static void allocateMasterPack()
   {
      int masterPackIndex = 0;

      // Check if masterPack was already initialized, and return if it was
      if (masterPack[masterPackIndex] != null) // masterPack was initialized
      {
         return;
      } else
      {
         // masterPack was not initialized
         // Assign cards with all unique combos of suits & values to masterPack
         for (Card.Suit suit : Card.Suit.values())
         {
            for (char validCardValue : Card.VALID_CARD_VALUES)
            {
               masterPack[masterPackIndex] = new Card(validCardValue, suit);
               masterPackIndex++;
            }
         }
      }

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

/*
-------------------Testing Card Class------------------------
A of Spades
** illegal **
J of Clubs

** illegal **
Q of Spades
J of Clubs
------------------------End of  Test------------------------

-------------------Testing Hand  Class------------------------

Hand = ( 2 of Diamonds, 4 of Hearts, 5 of Spades, 5 of Spades, T of Clubs, 2 of Diamonds, 
4 of Hearts, 5 of Spades, 5 of Spades, T of Clubs, 2 of Diamonds, 4 of Hearts, 
5 of Spades, 5 of Spades, T of Clubs, 2 of Diamonds, 4 of Hearts, 5 of Spades, 
5 of Spades, T of Clubs, 2 of Diamonds, 4 of Hearts, 5 of Spades, 5 of Spades, 
T of Clubs, 2 of Diamonds, 4 of Hearts, 5 of Spades, 5 of Spades, T of Clubs, 
2 of Diamonds, 4 of Hearts, 5 of Spades, 5 of Spades, T of Clubs, 2 of Diamonds, 
4 of Hearts, 5 of Spades, 5 of Spades, T of Clubs, 2 of Diamonds, 4 of Hearts, 
5 of Spades, 5 of Spades, T of Clubs, 2 of Diamonds, 4 of Hearts, 5 of Spades, 
5 of Spades, T of Clubs )

Testing inspectCard()
2 of Diamonds
** illegal **
Playing T of Clubs
Playing 5 of Spades
Playing 5 of Spades
Playing 4 of Hearts
Playing 2 of Diamonds
Playing T of Clubs
Playing 5 of Spades
Playing 5 of Spades
Playing 4 of Hearts
Playing 2 of Diamonds
Playing T of Clubs
Playing 5 of Spades
Playing 5 of Spades
Playing 4 of Hearts
Playing 2 of Diamonds
Playing T of Clubs
Playing 5 of Spades
Playing 5 of Spades
Playing 4 of Hearts
Playing 2 of Diamonds
Playing T of Clubs
Playing 5 of Spades
Playing 5 of Spades
Playing 4 of Hearts
Playing 2 of Diamonds
Playing T of Clubs
Playing 5 of Spades
Playing 5 of Spades
Playing 4 of Hearts
Playing 2 of Diamonds
Playing T of Clubs
Playing 5 of Spades
Playing 5 of Spades
Playing 4 of Hearts
Playing 2 of Diamonds
Playing T of Clubs
Playing 5 of Spades
Playing 5 of Spades
Playing 4 of Hearts
Playing 2 of Diamonds
Playing T of Clubs
Playing 5 of Spades
Playing 5 of Spades
Playing 4 of Hearts
Playing 2 of Diamonds
Playing T of Clubs
Playing 5 of Spades
Playing 5 of Spades
Playing 4 of Hearts
Playing 2 of Diamonds

After playing all cards

Hand = (  )
-------------------End of Test------------------------
-------------------Testing Deck  Class------------------------
How many hands? (1 - 10, please) 8
8 hands:

Unshuffled deck:

Hand = ( A of Spades, 6 of Spades, J of Hearts, 3 of Hearts, 8 of Diamonds, K of Clubs, 
5 of Clubs )

Hand = ( K of Spades, 5 of Spades, T of Hearts, 2 of Hearts, 7 of Diamonds, Q of Clubs, 
4 of Clubs )

Hand = ( Q of Spades, 4 of Spades, 9 of Hearts, A of Diamonds, 6 of Diamonds, J of Clubs, 
3 of Clubs )

Hand = ( J of Spades, 3 of Spades, 8 of Hearts, K of Diamonds, 5 of Diamonds, T of Clubs, 
2 of Clubs )

Hand = ( T of Spades, 2 of Spades, 7 of Hearts, Q of Diamonds, 4 of Diamonds, 9 of Clubs )


Hand = ( 9 of Spades, A of Hearts, 6 of Hearts, J of Diamonds, 3 of Diamonds, 8 of Clubs )


Hand = ( 8 of Spades, K of Hearts, 5 of Hearts, T of Diamonds, 2 of Diamonds, 7 of Clubs )


Hand = ( 7 of Spades, Q of Hearts, 4 of Hearts, 9 of Diamonds, A of Clubs, 6 of Clubs )



 Shuffled deck:

Hand = ( 4 of Clubs, 8 of Spades, K of Spades, 5 of Spades, 2 of Clubs, Q of Hearts, 
T of Spades )

Hand = ( T of Hearts, K of Clubs, 9 of Diamonds, 6 of Clubs, 2 of Spades, 9 of Clubs, 
3 of Spades )

Hand = ( 9 of Spades, 8 of Hearts, 2 of Hearts, K of Hearts, A of Clubs, 8 of Clubs, 
A of Diamonds )

Hand = ( 3 of Clubs, J of Spades, T of Clubs, 3 of Hearts, K of Diamonds, Q of Clubs, 
6 of Spades )

Hand = ( J of Clubs, Q of Spades, 4 of Spades, J of Hearts, 8 of Diamonds, 7 of Diamonds )


Hand = ( 3 of Diamonds, 4 of Diamonds, J of Diamonds, Q of Diamonds, T of Diamonds, 9 of Hearts )


Hand = ( 7 of Clubs, A of Hearts, 4 of Hearts, 5 of Diamonds, 6 of Diamonds, 5 of Clubs )


Hand = ( 7 of Spades, 7 of Hearts, 5 of Hearts, 2 of Diamonds, 6 of Hearts, A of Spades )

-------------------End of Test------------------------
*/
