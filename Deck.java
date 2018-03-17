
/**
 * The Class Deck.
 *
 * @author Hunter Mason, Jake McGhee, Mac Dousias, Pavlos Papadonikolakis
 * 
 */
public class Deck
{
   
   // Public static class constants.
   public final int MAX_CARDS;
   
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
      return null;
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
   
}
