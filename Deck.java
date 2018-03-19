
/**
 * The Class Deck.
 *
 * @author Hunter Mason, Jake McGhee, Mac Dousias, Pavlos Papadonikolakis
 * 
 */
import java.lang.Math;

public class Deck
{
   
   // The maximum amount of cards allowed in the deck (6 * 52)
   public final int MAX_CARDS = 312;
   
   // The valid card values for a deck.
   public final char[] VALID_CARDS = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
   
   // Private static member data.
   static Card[] masterPack;
   
   // Private member data.
   Card[] cards;
   int topCard;
   int numPacks;
   
   /* re-populate cards[] with the standard 52 × numPacks cards. 
    * We should not repopulate the static array, masterPack[], since that was done once, 
    * in the (first-invoked) constructor and never changes.
    */
   public Deck(int numPacks)
   {
      
      // Calculate the total number of cards in the deck based on the number of packs used.
      int totalCards = numPacks * 52;
      
      // Only allow a valid number of cards in the deck.
      if(totalCards > MAX_CARDS || totalCards < 1)
      {
         System.out.println("A deck cannot contain more than " + MAX_CARDS + "  or less than 1 cards.");
         return;
      }
      
      // Assign default values.
      this.numPacks = numPacks;
      this.topCard = 0;
      cards = new Card[numPacks * 52];
      
      // Initialize the card array with the total amount of cards.
      init(numPacks);
      
      System.out.println("A deck of " + totalCards + " cards has been created.");
      return;
   }

   public Deck()
   {
      Deck deck = new Deck(1);
      return;
   }
   /*
   public void init(int numPacks)
   {
      // Create a card of each suit and value combination per pack and add it to the deck.
      for(int i = 0; i < numPacks; i++)
      {
         for(int s = 0; s < Card.Suit.values().length; s++)
         {
            // Get the correct suit.
            Card.Suit suit = Card.Suit.values()[s];
            
            for(int v = 0; v < VALID_CARDS.length; v++)
            {
               // Get the correct value.
               char value = VALID_CARDS[v];
               cards[i + s + v] = new Card(value, suit);
            }
         }
      }
   }
   */
   
   // An init method that follows the assignment specs and doesn't use VALID_CARDS.
   public void init(int numPacks)
   {
      // Create a card of each suit and value combination per pack and add it to the deck.
      for(int i = 0; i < numPacks; i++)
      {
         for(int s = 0; s < Card.Suit.values().length; s++)
         {
            Card.Suit suit = Card.Suit.values()[s];
            
            // Add cards of each value to the deck.
            cards[i*52 + s*13    ] = new Card('A', suit);
            cards[i*52 + s*13 + 1] = new Card('2', suit);
            cards[i*52 + s*13 + 2] = new Card('3', suit);
            cards[i*52 + s*13 + 3] = new Card('4', suit);
            cards[i*52 + s*13 + 4] = new Card('5', suit);
            cards[i*52 + s*13 + 5] = new Card('6', suit);
            cards[i*52 + s*13 + 6] = new Card('7', suit);
            cards[i*52 + s*13 + 7] = new Card('8', suit);
            cards[i*52 + s*13 + 8] = new Card('9', suit);
            cards[i*52 + s*13 + 9] = new Card('T', suit);
            cards[i*52 + s*13 + 10] = new Card('J', suit);
            cards[i*52 + s*13 + 11] = new Card('Q', suit);
            cards[i*52 + s*13 + 12] = new Card('K', suit);
         }
      }

      for(Card c : cards)
      {
         System.out.println(c.toString());
      }
   }
   
   // Mixes up the cards with the help of the standard random number generator.
   public void shuffle()
   {
      for(int i = 0; i < cards.length; i++)
      {
         // Get a random index in the deck.
         int randomIndex = (int)(Math.random()*cards.length);
         
         // Make a copy of the current card.
         Card temp = cards[i];
         
         // Swap the current and the card at the random index.
         cards[i] = cards[randomIndex];
         cards[randomIndex] = temp;
      }
   }
   
   // Returns and removes the card in the top occupied position of cards[].
   public Card dealCard()
   {
      return null;
   }
   
   
   // Accessor for topCard.
   public int getTopCard()
   {
      return topCard;
   }
   
   // Accessor for an individual card. Returns a card with errorFlag = true if k is bad.
   public Card inspectCard(int k)
   {
      return null;
   }
   
   static void allocateMasterPack()
   {
      /*
       * this is a private method that will be called by the constructor. 
       * However, it has to be done with a very simple twist: 
       * even if many Deck objects are constructed in a given program, 
       * this static method will not allow itself to be executed more than once. 
       * Since masterPack[] is a static, unchanging, entity, 
       * it need not be built every time a new Deck is instantiated. 
       * So this method needs to be able to ask itself, "Have I been here before?", 
       * and if the answer is "yes", it will immediately return without doing anything; 
       * it has already built masterPack[] in a previous invocation.
       */
   }
   public static void main(String[] args) {
      Deck deck = new Deck(2);
   }
   
}

