// This is a class that tests the Card and Deck classes.
public class CardClient {

	public static void main(String[] args) {
		// ***********************
		// Card class testing code
		// ***********************
		// Make a card
		Card c1 = new Card("ace", "hearts", 1);

		// Print out the card's rank
		System.out.println(c1.getRank());
		// ace

		// ** You might want to test the other getters here as well **

		// Print out the card (toString method)
		System.out.println(c1);
		// ace of hearts (point value = 1)

		// ***********************
		// Deck class testing code
		// ***********************
		// Make a small deck of cards (of 8 cards)
		String[] ranks = {"jack", "queen", "king", "ace"};
		String[] suits = {"spades", "hearts"};
		int[] values = {11, 12, 13, 14};
		Deck d1 = new Deck(ranks, suits, values);

		// Print out the deck
		System.out.println();
		System.out.println(d1);
		// size = 8
		// Undealt cards:
		// ace of hearts (point value = 14), king of hearts (point value = 13),
		// queen of hearts (point value = 12), jack of hearts (point value = 11),
		// ace of spades (point value = 14), king of spades (point value = 13),
		// queen of spades (point value = 12), jack of spades (point value = 11)
		//
		// Dealt cards:

		// Deal out the top card
		Card c = d1.deal();
		System.out.println(c);
		// ace of hearts (point value = 14)

		// Print out the remaining cards
		System.out.println();
		System.out.println(d1);
		// size = 7
		// Undealt cards:
		// king of hearts (point value = 13), queen of hearts (point value = 12),
		// jack of hearts (point value = 11), ace of spades (point value = 14),
		// king of spades (point value = 13), queen of spades (point value = 12),
		// jack of spades (point value = 11)
		// Dealt cards:
		// ace of hearts (point value = 14)

		// Shuffle the deck
		Deck d2 = new Deck(ranks, suits, values);
		d2.shuffle();
		System.out.println(d2);
		// The output will be some random ordering of the cards in the deck
	}
}
