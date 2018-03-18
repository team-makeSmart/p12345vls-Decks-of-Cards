/**
 * The Class Card
 * @author Hunter Mason, Jake McGhee, Mac Doussias, Pavlos Papadonikolakis
 * CLASS CST338
 * Assignment 3, Module 3
 */
public class Card 
{
    
   /**
    * Enumerated Suit values
    */
   public enum Suit 
   {   
      clubs, diamonds, hearts, spades
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
    * The main method
    * @param args the arguments
    */
   public static void main(String[] args) 
   {
      //Create card objects for testing
      Card card1 = new Card('A', Suit.spades);
      Card card2 = new Card('s', Suit.spades);
      Card card3 = new Card('J', Suit.clubs);
      
      //Check if valid by looking at console output
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());
      
      //Create a space on console
      System.out.println();
       
      //Create card objects for testing
      Card card4 = new Card('d', Suit.spades);
      Card card5 = new Card('Q', Suit.spades);
      Card card6 = new Card('J', Suit.clubs);

      //Check if valid by looking at console output
      System.out.println(card4.toString());
      System.out.println(card5.toString());
      System.out.println(card6.toString());
   }
    
   /**
    * Default Constructor
    * Instantiates a new card as Ace of Spades
    */
   public Card() 
   {
      this.value = 'A';
      this.suit = Suit.spades;
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
         if (suit == Suit.spades)
            returnValue += " of Spades";
         else if (suit == Suit.hearts)
            returnValue += " of Hearts";
         else if (suit == Suit.diamonds)
            returnValue += " of Diamonds";
         else if (suit == Suit.clubs)
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
    * @return true, if is valid
    */
   private boolean isValid(char value, Suit suit) 
   {
      return (value == 'A' || value == 'K' || value == 'Q' || value == 'J' || 
         value == 'T' || (value >= '2' && value <= '9')) && (suit == 
         Suit.clubs || suit == Suit.diamonds || suit == Suit.hearts || 
         suit == Suit.spades);
   }
   
}
