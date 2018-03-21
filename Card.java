
/**
 * The Class Card CLASS CST338 Assignment 3, Module 3
 *
 * @author Hunter Mason, Jake McGhee, Mac Doussias, Pavlos Papadonikolakis
 */
public class Card {
    
    /** Constant array of valid card values acceptable for program */
    public static final char[] VALID_CARD_VALUES = { '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A' };
    
    /**
     * Enumerated Suit values
     */
    public enum Suit {
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
    public Card() {
        this.value = 'A';
        this.suit = Suit.SPADES;
    }
    
    /**
     * Constructor Instantiates a new card, by calling the set() method
     *
     * @param value
     *            the value
     * @param suit
     *            the suit
     */
    public Card(char value, Suit suit) {
        set(value, suit);
    }
    
    /**
     * Returns a string based on the value and suit instance variables
     */
    public String toString() {
        if (errorFlag == true) // Card does not contain valid data
        {
            return "** illegal **"; // Returns an error message
        } else {
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
     *            the value
     * @param suit
     *            the suit
     * @return true, if successful
     */
    public boolean set(char value, Suit suit) {
        if (!isValid(value, suit)) {
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
    public boolean getErrorFlag() {
        return errorFlag;
    }
    
    /**
     * Gets the suit
     *
     * @return the suit
     */
    public Suit getSuit() {
        return this.suit;
    }
    
    /**
     * Gets the value
     *
     * @return the value
     */
    public char getValue() {
        return value;
    }
    
    /**
     * Checks for equal values
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
    
    /**
     * Checks if is the values entered by the user are valid.
     *
     * @param value
     *            the value
     * @param suit
     *            the suit
     * @return true, if all values are valid
     */
    private boolean isValid(char value, Suit suit) {
        for (char val : VALID_CARD_VALUES) {
            if (value == val) {
                return true; // The value argument found in VALID_CARD_VALUES
                // array
            }
        }
        return false; // The value argument was not found
    }
    
    // Test method
    public static void testCard() {
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
    
}

