import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MyTests {

    @Test
    public void testContainsPairSum11() {
        // Some basic tests
        String[] ranks = { "ace", "4", "5", "6", "7", "9", "10", "jack", "king" };
        int[] pointValues = { 1, 4, 5, 6, 7, 9, 10, 0, 0 };

        Card[] cards = new Card[9];
        for (int i = 0; i < 9; i++) {
            cards[i] = new Card(ranks[i], "spades", pointValues[i]);
        }

        ElevensBoard e = new ElevensBoard();
        e.cards = cards;

        assertEquals(true, e.containsPairSum11(e.getAllCardIndexes()), "Given the cards [A, 4, 5, 6, 7, 9, 10, J, K], the result of looking for an 11-pair should be: true");

        // remove 4 and 5
        e.cards[1] = null;
        e.cards[2] = null;
        assertEquals(true, e.containsPairSum11(e.getAllCardIndexes()), "Given the cards [A, 6, 7, 9, 10, J, K], the result of looking for an 11-pair should be: true");

        // remove 10
        e.cards[6] = null;
        assertEquals(false, e.containsPairSum11(e.getAllCardIndexes()), "Given the cards [A, 6, 7, 9, J, K], the result of looking for an 11-pair should be: false");

        // Testing cards that are farther away from each other
        String[] ranks2 = { "9", "8", "4", "6", "6", "9", "10", "3", "king" };
        int[] pointValues2 = { 9, 8, 4, 6, 6, 9, 10, 3, 0 };

        Card[] cards2 = new Card[9];
        for (int i = 0; i < 9; i++) {
            cards2[i] = new Card(ranks2[i], "spades", pointValues2[i]);
        }

        ElevensBoard e2 = new ElevensBoard();
        e2.cards = cards2;
        assertEquals(true, e2.containsPairSum11(e2.getAllCardIndexes()), "Given the cards [9, 8, 4, 6, 6, 9, 10, 3, K], the result of looking for an 11-pair should be: true");
        assertEquals(false, e2.containsPairSum11(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5))), "Given the card indexes [1, 2, 3, 4, 5] from the board [9, 8, 4, 6, 6, 9, 10, 3, K], the result of looking for an 11-pair should be: false");
        assertEquals(true, e2.containsPairSum11(new ArrayList<Integer>(Arrays.asList(1, 7))), "Given the card indexes [1, 7] from the board [9, 8, 4, 6, 6, 9, 10, 3, K], the result of looking for an 11-pair should be: true");
        assertEquals(false, e2.containsPairSum11(new ArrayList<Integer>(Arrays.asList(0, 2, 3, 4, 5, 6, 8))), "Given the card indexes [0, 2, 3, 4, 5, 6, 8] from the board [9, 8, 4, 6, 6, 9, 10, 3, K], the result of looking for an 11-pair should be: false");
        assertEquals(false, e2.containsPairSum11(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6))), "Given the card indexes [0, 1, 2, 3, 4, 5, 6] from the board [9, 8, 4, 6, 6, 9, 10, 3, K], the result of looking for an 11-pair should be: false");
        assertEquals(false, e2.containsPairSum11(new ArrayList<Integer>(Arrays.asList(3, 4, 5, 6, 7, 8))), "Given the card indexes [3, 4, 5, 6, 7, 8] from the board [9, 8, 4, 6, 6, 9, 10, 3, K], the result of looking for an 11-pair should be: false");
        assertEquals(false, e2.containsPairSum11(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7))), "Given the card indexes [2, 3, 4, 5, 6, 7] from the board [9, 8, 4, 6, 6, 9, 10, 3, K], the result of looking for an 11-pair should be: false");
    }

    @Test
    public void testContainsJQK() {
        String[] ranks = { "ace", "4", "5", "6", "7", "9", "10", "jack", "king" };
        int[] pointValues = { 1, 4, 5, 6, 7, 9, 10, 0, 0 };

        Card[] cards = new Card[9];
        for (int i = 0; i < 9; i++) {
            cards[i] = new Card(ranks[i], "spades", pointValues[i]);
        }

        ElevensBoard e = new ElevensBoard();
        e.cards = cards;
        assertEquals(false, e.containsJQK(e.getAllCardIndexes()), "Given the cards [A, 4, 5, 6, 7, 9, 10, J, K], the result of looking for a JQK should be: false");


        String[] ranks2 = { "9", "queen", "4", "6", "6", "jack", "10", "3", "king" };
        int[] pointValues2 = { 9, 0, 4, 6, 6, 0, 10, 3, 0 };

        Card[] cards2 = new Card[9];
        for (int i = 0; i < 9; i++) {
            cards2[i] = new Card(ranks2[i], "spades", pointValues2[i]);
        }

        ElevensBoard e2 = new ElevensBoard();
        e2.cards = cards2;
        assertEquals(true, e2.containsJQK(e2.getAllCardIndexes()), "Given the cards [9, Q, 4, 6, 6, J, 10, 3, K], the result of looking for a JQK should be: true");
        assertEquals(false, e2.containsJQK(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7, 8))), "Given the card indexes [2, 3, 4, 5, 6, 7, 8] from the board [9, Q, 4, 6, 6, J, 10, 3, K], the result of looking for a JQK should be: false");
        assertEquals(false, e2.containsJQK(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7))), "Given the card indexes [0, 1, 2, 3, 4, 5, 6, 7] from the board [9, Q, 4, 6, 6, J, 10, 3, K], the result of looking for a JQK should be: false");
        assertEquals(false, e2.containsJQK(new ArrayList<Integer>(Arrays.asList(0, 2, 3, 4, 5, 6, 7, 8))), "Given the card indexes [0, 2, 3, 4, 5, 6, 7, 8] from the board [9, Q, 4, 6, 6, J, 10, 3, K], the result of looking for a JQK should be: false");
        assertEquals(false, e2.containsJQK(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 6, 7, 8))), "Given the card indexes [0, 1, 2, 3, 4, 6, 7, 8] from the board [9, Q, 4, 6, 6, J, 10, 3, K], the result of looking for a JQK should be: false");
        assertEquals(true, e2.containsJQK(new ArrayList<Integer>(Arrays.asList(1, 5, 8))), "Given the card indexes [1, 5, 8] from the board [9, Q, 4, 6, 6, J, 10, 3, K], the result of looking for a JQK should be: true");
        assertEquals(true, e2.containsJQK(new ArrayList<Integer>(Arrays.asList(0, 1, 5, 6, 8))), "Given the card indexes [0, 1, 5, 6, 8] from the board [9, Q, 4, 6, 6, J, 10, 3, K], the result of looking for a JQK should be: true");
    }

    @Test
    public void testAnotherPlayIsPossible() {
        String[] ranks = { "ace", "4", "5", "6", "7", "9", "10", "jack", "king" };
        int[] pointValues = { 1, 4, 5, 6, 7, 9, 10, 0, 0 };

        Card[] cards = new Card[9];
        for (int i = 0; i < 9; i++) {
            cards[i] = new Card(ranks[i], "spades", pointValues[i]);
        }

        ElevensBoard e = new ElevensBoard();
        e.cards = cards;
        assertEquals(true, e.anotherPlayIsPossible(), "Given the cards [A, 4, 5, 6, 7, 9, 10, J, K], the result of checking for a possible play should be: true");

        String[] ranks2 = { "9", "queen", "4", "6", "6", "jack", "10", "3", "king" };
        int[] pointValues2 = { 9, 0, 4, 6, 6, 0, 10, 3, 0 };

        Card[] cards2 = new Card[9];
        for (int i = 0; i < 9; i++) {
            cards2[i] = new Card(ranks2[i], "spades", pointValues2[i]);
        }

        ElevensBoard e2 = new ElevensBoard();
        e2.cards = cards2;
        assertEquals(true, e2.anotherPlayIsPossible(), "Given the cards [9, Q, 4, 6, 6, J, 10, 3, K], the result of checking for a possible play should be: true");

        String[] ranks3 = { "9", "queen", "4", "6", "6", "queen", "10", "3", "king" };
        int[] pointValues3 = { 9, 0, 4, 6, 6, 0, 10, 3, 0 };

        Card[] cards3 = new Card[9];
        for (int i = 0; i < 9; i++) {
            cards3[i] = new Card(ranks3[i], "spades", pointValues3[i]);
        }

        ElevensBoard e3 = new ElevensBoard();
        e3.cards = cards3;
        assertEquals(false, e3.anotherPlayIsPossible(), "Given the cards [9, Q, 4, 6, 6, Q, 10, 3, K], the result of checking for a possible play should be: false");
    }

    @Test
    public void testIsLegal() {
        String[] ranks = { "queen", "4", "5", "6", "7", "9", "10", "jack", "king" };
        int[] pointValues = { 0, 4, 5, 6, 7, 9, 10, 0, 0 };

        Card[] cards = new Card[9];
        for (int i = 0; i < 9; i++) {
            cards[i] = new Card(ranks[i], "spades", pointValues[i]);
        }

        ElevensBoard e = new ElevensBoard();
        e.cards = cards;
        assertEquals(true, e.isLegal(new ArrayList<Integer>(Arrays.asList(1, 4))), "The legality of the cards with index [1, 4] from the board [Q, 4, 5, 6, 7, 9, 10, J, K] should be: true");
        assertEquals(true, e.isLegal(new ArrayList<Integer>(Arrays.asList(0, 7, 8))), "The legality of the cards with index [0, 7, 8] from the board [Q, 4, 5, 6, 7, 9, 10, J, K] should be: true");
        assertEquals(false, e.isLegal(new ArrayList<Integer>(Arrays.asList(0, 1))), "The legality of the cards with index [0, 1] from the board [Q, 4, 5, 6, 7, 9, 10, J, K] should be: false");
        assertEquals(false, e.isLegal(new ArrayList<Integer>(Arrays.asList(2, 4))), "The legality of the cards with index [2, 4] from the board [Q, 4, 5, 6, 7, 9, 10, J, K] should be: false");
        assertEquals(false, e.isLegal(new ArrayList<Integer>(Arrays.asList(0, 6, 7))), "The legality of the cards with index [0, 6, 7] from the board [Q, 4, 5, 6, 7, 9, 10, J, K] should be: false");
        assertEquals(false, e.isLegal(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5))), "The legality of the cards with index [1, 2, 3, 4, 5] from the board [Q, 4, 5, 6, 7, 9, 10, J, K] should be: false");
        assertEquals(false, e.isLegal(new ArrayList<Integer>(Arrays.asList(0, 6, 7, 8))), "The legality of the cards with index [0, 6, 7, 8] from the board [Q, 4, 5, 6, 7, 9, 10, J, K] should be: false");
    }
}
