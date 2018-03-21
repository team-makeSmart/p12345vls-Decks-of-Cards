import java.util.Scanner;

public class Assig3 {
    
    public static void main(String[] args) {
        
        System.out.println("-------------------Testing Card Class------------------------");
        
        Card.testCard();
        System.out.println("------------------------End of  Test------------------------");
        
        System.out.println("\n-------------------Testing Hand  Class------------------------");
        
        Hand.testHand();
        System.out.println("-------------------End of Test------------------------");
        
        System.out.println("-------------------Testing Deck  Class------------------------");
        
        Deck.testDeck();
        System.out.println("-------------------End of Test------------------------");
        
        final int MAX_HANDS = 10;
        Hand[] hands = new Hand[MAX_HANDS];
        for (int i = 0; i < MAX_HANDS; i++) {
            hands[i] = new Hand();
        }
        
        int k = 0, numHands = 0;
        Deck deck = new Deck(1);
        Scanner scann = new Scanner(System.in);
        
        // input
        while (true) {
            
            System.out.print("How many hands? (1 - " + MAX_HANDS + ", please) or (-1 to exit): ");
            numHands = scann.nextInt();
            
            if (numHands < 1 || numHands > MAX_HANDS) {
                System.out.println("Program exiting");
                
                return;
            }
            
            System.out.println(numHands + " hands:");
            
            // unshuffled
            while (deck.getNumCards() > 0) {
                for (k = 0; k < numHands; k++) {
                    if (deck.getNumCards() == 0)
                        break;
                    
                    hands[k].takeCard(deck.dealCard());
                }
            }
            
            System.out.println("\nUnshuffled deck:");
            for (k = 0; k < numHands; k++) {
                
                System.out.println(hands[k]);
                
            }
            
            // shuffled
            deck.init(1);
            deck.shuffle();
            
            // clear hands
            for (k = 0; k < numHands; k++)
                
                hands[k].resetHand();
            
            while (deck.getNumCards() > 0) {
                for (k = 0; k < numHands; k++) {
                    if (deck.getNumCards() == 0)
                        break;
                    
                    hands[k].takeCard(deck.dealCard());
                }
            }
            
            System.out.println("\n\n Shuffled deck:");
            for (k = 0; k < numHands; k++) {
                
                System.out.println(hands[k].toString());
                
            }
            
        }
        
    }
    
}

