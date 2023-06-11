
public class flashCard implements leitnerSystem {
	private String front;
	private String back;

	flashCard(String front, String back) {
		this.setFront(front);
		this.setBack(back);
	}

	boolean flag = true;

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	/**
	 * This is used for essentially taking passed argument of flag and assigning it to the flag, which is then used in the display method
	 * for determining which side to display
	 *
	 * @param flag
	 * @return flag
	 */
	public boolean flipCard(boolean flag) {
		return (this.flag = flag);
	}

	/**
	 * Overrides display from interface leitnerSystem, this method basically checks the flag which is affected by flipCard, if the flag is false,
	 * then it will display the back as if it has been flipped from the front, but if the flag is true then it retrieves the front.
	 */
	public void display() {
		if (flag == false) {
			System.out.println(this.getBack());
		} else {
			System.out.println(this.getFront());
		}
	}
}
