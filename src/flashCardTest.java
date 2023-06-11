import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class flashCardTest {
	//creating a default card to test
	flashCard card1 = new flashCard("front1", "back1");
	/*
	 * this testFlipCard method is meant to check whether or not flipCard is properly working, essentially what it does is it takes the flag that
	 * is passed into it, then returns that flag value, so if card1.flipcard is the same as the flag is true, then it it passes.
	 * If it didn't pass this test, then this would really mess with how display works for deciding on which card face to show.
	 */
	@Test
	public void testFlipCard() {
		boolean flag = false;
		card1.flipCard(flag);
		assertTrue(card1.flipCard(flag)==flag);
	}
	
}
