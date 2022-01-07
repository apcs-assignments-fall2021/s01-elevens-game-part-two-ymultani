import java.util.ArrayList;
import java.util.Objects;

// The Deck class represents a shuffled deck of cards.
// It provides several operations including
// initialize, shuffle, deal, and check if empty.
public class Deck {

	// cards is an ArrayList of all the Card objects in our deck
	private ArrayList<Card> cards;

	// size is the number of not-yet-dealt cards.
	// Cards are dealt from the top (highest index) down.
	// The next card to be dealt is at size - 1.
	private int size;


	// Creates a new Deck instance given arrays of ranks, suits, and values
	// Remember, in a constructor you need to first create the ArrayList for the instance variable
	// You will also need to initialize the size variable
	// You should go through and make all possible pairs of suits and ranks
	public Deck(String[] ranks, String[] suits, int[] values) {
		cards = new ArrayList<Card>();
		size = suits.length * ranks.length;

		for (int i = 0; i < suits.length; i++) {
			String suit = suits[i];
			for (int j = 0; j < ranks.length; j++) {
				String rank = ranks[j];
				int point = values[j];

				cards.add(new Card(rank, suit, point));
			}
		}
	}

	// Determines if this deck is empty (there are no undealt cards).
	// returns true if this deck is empty, false otherwise.
	public boolean isEmpty() {
		// YOUR CODE HERE
		return size == 0;
	}

	// Returns the size (number of undealt cards) in this deck.
	public int getSize() {
		// YOUR CODE HERE
		return size;
	}

	// Deals a card from this deck.
	// return the card just dealt, or null if all the cards have been dealt already
	// Updates the size as well
	public Card deal() {
		// YOUR CODE HERE
		if (size != 0) {
			size--;
			return cards.get(size);
		}
		else {
			return null;
		}
	}

	// Shuffles the deck by repeatedly randomly swapping pairs of cards
	public void shuffle() {
		// YOUR CODE HERE
		for (int i = 0; i < cards.size(); i++) {
			int rand = (int) (Math.random() * cards.size());
			Card temp = cards.get(rand);
			cards.set(rand, cards.get(i));
			cards.set(i, temp);
		}

		this.size = cards.size();
	}

	// OPTIONAL: Write code that carries out a "perfect" shuffle
	// that perfectly interweaves the two halves of the deck
	public void perfectShuffle() {
		// YOUR CODE HERE
		ArrayList<Card> firstHalf = new ArrayList<Card>();
		ArrayList<Card> secondHalf = new ArrayList<Card>();

		for (int i = 0; i < cards.size()/2; i++) {
			firstHalf.add(cards.get(i));
		}

		for (int i = cards.size()/2; i < cards.size(); i++) {
			secondHalf.add(cards.get(i));
		}

		int j = 0;
		for (int i = 0; i < cards.size(); i += 2) {
			firstHalf.add(i+1, secondHalf.get(j));
			j++;
		}

		cards = firstHalf;
	}

	// CODE BELOW HERE IS ALREADY WRITTEN:

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		if (cards == null) {
			return "";
		}

		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}

	// Returns the card at the given index of the deck
	// This method should only be used in testing code
	public Card getCardAtIndex(int idx) {
		return cards.get(idx);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		else if (o == null || getClass() != o.getClass()) {
			return false;
		}
		else {
			return cards.equals(((Deck) o).cards);
		}
	}
}
