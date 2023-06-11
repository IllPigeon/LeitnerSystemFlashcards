import java.util.ArrayList;

public class Boxes implements leitnerSystem {
	private String boxName;
	ArrayList<flashCard> cards = new ArrayList<>();

	Boxes(String boxName) {
		this.boxName = boxName;
	}

	public String getBoxName() {
		return boxName;
	}

	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}

	/**
	 * Retrieves cards arrayList, basically allowing access of cards inside a box
	 *
	 * @return cards
	 */
	public ArrayList<flashCard> getCards() {
		return cards;
	}

	/**
	 * Adds a new card to the ArrayList cards of flash card objects
	 * 
	 * @param newCard
	 */
	public void addCard(flashCard newCard) {
		cards.add(newCard);
	}

	/**
	 * Removes a card object at the Array List of cards given the index
	 * 
	 * @param i
	 */
	public void delCard(int i) {
		cards.remove(i);
	}

	/**
	 * Overrides display method from leitnerSystem interface, essentially uses
	 * display method from flashCard class for each card stored inside array
	 * list of cards which is associated with the box
	 */
	public void display() {
		for (flashCard c : cards) {
			c.display();
		}
	}
}
