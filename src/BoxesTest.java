import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoxesTest {
	//instantiating box and card for testing
	Boxes newBox = new Boxes("Boxy");
	flashCard newCard = new flashCard("testy","besty");
	
	/**
	 * Testing the functionality of addCard method, this is pretty important for whether or not cards can be moved around to other boxes
	 * as well as creating new cards to be added inside of box1. What this test is doing is retrieving the array list of cards inside
	 * of a box object. If addCard works, then the new card that is added in will be stored within the array list of cards, so it can be
	 * checked using contains after getting the cards using a getter method for the array list inside of the box object.
	 */
	@Test
	void testAddCard() {
		newBox.addCard(newCard);
		assertTrue(newBox.getCards().contains(newCard));
	}
	/**
	 * This test will be specifically about the delCard method, which does about what should be expected, it removes a card inside the box
	 * given an index. We can check to see if this method works by adding a card, then removing it, and asserting that the size of the 
	 * array list of cards in the box must be 0.
	 */
	@Test
	void testdelCard() {
		newBox.addCard(newCard);
		//0 is the index of the first card in the box, so in this case newCard.
		newBox.delCard(0);
		assertTrue(newBox.getCards().size() == 0);
	}
}
