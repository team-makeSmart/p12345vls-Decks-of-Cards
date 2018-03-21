
/**
 * The Class Deck
 * @author Hunter Mason, Jake McGhee, Mac Doussias, Pavlos Papadonikolakis
 * CLASS CST338
 * Assignment 3, Module 3
 */

import java.util.Scanner;

public class Deck {
    
    public final static int MAX_CARDS = 52;
    private static Card[] masterPack = new Card[MAX_CARDS];
    
    private Card[] cards = new Card[MAX_CARDS];
    private int topCard;
    private int numPacks;
    
    public Deck(int numPacks) {
        allocateMasterPack();
        init(numPacks);
    }
    
    public Deck() {
        allocateMasterPack();
        init(1);
    }
    
    public static void allocateMasterPack() {
        // Check if the master pack has been created already.
        boolean firstTime = true;
        if (!firstTime)
            return;
        firstTime = false;
        
        Card.Suit suit;
        char value;
        
        // Add a cards with a defined value and suit to the master pack.
        for (int k = 0; k < Card.Suit.values().length; k++) {
            suit = Card.Suit.values()[k];
            
            for (int v = 0; v < Card.VALID_CARD_VALUES.length; v++) {
                value = Card.VALID_CARD_VALUES[v];
                masterPack[13 * k + v] = new Card(value, suit);
            }
        }
    }
    
    public void init(int numPacks) {
        // Allocate card array with the total amount of cards
        cards = new Card[numPacks * 52];
        
        int k = 0, pack = 0;
        
        // Only allow a valid number of cards in the deck
        if (numPacks < 1 || numPacks > 6)
            numPacks = 1;
        
        // Add cards to the array by making copies from the master pack
        for (pack = 0; pack < numPacks; pack++) {
            for (k = 0; k < 52; k++)
                cards[(pack * 52 + k)] = masterPack[k];
        }
        this.numPacks = numPacks;
        topCard = numPacks * 52;
    }
    
    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            // Get a random index in the deck
            int randomIndex = (int) (Math.random() * cards.length);
            
            // Make a copy of the current card
            Card temp = cards[i];
            
            // Swap the current and the card at the random index
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }
    
    public Card dealCard() {
        Card error = new Card('s', Card.Suit.DIAMONDS);
        
        if (topCard == 0)
            return error;
        else
            return cards[--topCard];
    }
    
    public Card inspectCard(int k) {
        Card error = new Card('s', Card.Suit.DIAMONDS);
        
        if (k < 0 || k >= topCard)
            return error;
        else
            return cards[k];
    }
    
    public int getNumCards() {
        return topCard;
    }
    
    public static void testDeck() {
        
        Deck deck = new Deck(2);
        
        System.out.println("----------Test two packs of cards. Do not shuffle------------");
        
        while (deck.topCard != 0) {
            System.out.println(deck.dealCard());
        }
        
        System.out.println("--------Test two packs of cards. Shuffled--------------");
        
        deck = new Deck(2);
        deck.shuffle();
        
        while (deck.topCard != 0) {
            System.out.println(deck.dealCard());
        }
        
    }
}



