
/**
 * The Class Deck.
 *
 * @author Hunter Mason, Jake McGhee, Mac Dousias, Pavlos Papadonikolakis
 * 
 */
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
   
   public void init(int numPacks)
   {
      // Create a card of each suit and value combination per pack and add it to the deck.
      for(int i = 0; i < numPacks; i++)
      {
         for(int s = 0; s < Card.Suit.values().length; s++)
         {
            Card.Suit suit = Card.Suit.values()[s];
            
            for(int v = 0; v < VALID_CARDS.length; v++)
            {
               char value = VALID_CARDS[v];
               cards[i + s + v] = new Card(value, suit);
            }
         }
      }
   }
   
   // Mixes up the cards with the help of the standard random number generator.
   public void shuffle()
   {
      
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
      Deck deck = new Deck();
   }
   
}

