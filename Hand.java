/**
 * The Class Hand
 * @author Hunter Mason, Jake McGhee, Mac Doussias, Pavlos Papadonikolakis
 * CLASS CST338
 * Assignment 3, Module 3
 */

public class Hand  
{

   /**
    * The main method.
    * @param args the arguments
    */
   public static void main(String[] args) 
   {
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
   public void resetHand()  //TODO Does this needs more?  Need delete cards from myCards array?
   {
      numCards = 0;
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
            System.out.println("\nHand Full\nAfter Deal");  
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
               returnVal += ",";
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
