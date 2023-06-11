import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class flashyMain {

	public static void main(String[] args) {

		boolean firstFlag = false;
		boolean cardFlag = false;
		int boxNum = 0;
		int cardIndex = 0;

		Boxes box1 = new Boxes("Box 1");
		flashCard card1 = new flashCard("Front1", "Back1");
		box1.addCard(card1);

		Boxes box2 = new Boxes("Box 2");
		flashCard card2 = new flashCard("Front2", "Back2");
		box2.addCard(card2);

		Boxes box3 = new Boxes("Box 3");
		flashCard card3 = new flashCard("Front3", "Back3");
		box3.addCard(card3);

		Boxes box4 = new Boxes("Box 4");
		flashCard card4 = new flashCard("Front4", "Back4");
		box4.addCard(card4);

		Boxes box5 = new Boxes("Box 5");
		flashCard card5 = new flashCard("Front5", "Back5");
		box5.addCard(card5);

		System.out.println("Leitner System Flashcards");
		System.out.println("========================================");
		System.out.println("What would you like to do?" + "\n1.)Pick a random card from a random box"
				+ "\n2.)Add a new card to box 1" + "\n3.)Display cards in a box" + "\n4.)Delete a card"
				+ "\n5.)Modify a card" + "\n6.)Exit");
		try (Scanner sc = new Scanner(System.in)) {
			while (firstFlag == false) {
				String userInp = sc.nextLine();

				if (userInp.equals("1")) {
					Random randy = new Random();
					flashCard realCard = new flashCard("", "");
					int num = randy.nextInt(32);
					if ((num == 31) && (box5.getCards().size() > 0)) {
						boxNum = 5;
						int randCard = randy.nextInt(0, box5.getCards().size());
						cardIndex = randCard;
						ArrayList<flashCard> copyCards = box5.getCards();
						int faceOrBack = randy.nextInt(2);
						flashCard copyOfCard = copyCards.get(randCard);
						if (faceOrBack == 0) {
							cardFlag = true;
						} else if (faceOrBack == 1) {
							cardFlag = false;
						}
						copyOfCard.flipCard(cardFlag);
						copyOfCard.display();
						realCard = copyOfCard;

					} else if (num < 31) {
						num = randy.nextInt((30 - 29) + 29);
						if ((num == 30 || num == 29) && box4.getCards().size() > 0) {
							boxNum = 4;
							int randCard = randy.nextInt(0, box4.getCards().size());
							cardIndex = randCard;
							ArrayList<flashCard> copyCards = box4.getCards();
							int faceOrBack = randy.nextInt(2);
							flashCard copyOfCard = copyCards.get(randCard);
							if (faceOrBack == 0) {
								cardFlag = true;
							} else if (faceOrBack == 1) {
								cardFlag = false;
							}
							copyOfCard.flipCard(cardFlag);
							copyOfCard.display();
							realCard = copyOfCard;

						} else if (num < 29) {
							num = randy.nextInt((28 - 25) + 25);
							if ((num >= 25 && num <= 28) && box3.getCards().size() > 0) {
								boxNum = 3;
								int randCard = randy.nextInt(0, box3.getCards().size());
								cardIndex = randCard;
								ArrayList<flashCard> copyCards = box3.getCards();
								int faceOrBack = randy.nextInt(2);
								flashCard copyOfCard = copyCards.get(randCard);
								if (faceOrBack == 0) {
									cardFlag = true;
								} else if (faceOrBack == 1) {
									cardFlag = false;
								}
								copyOfCard.flipCard(cardFlag);
								copyOfCard.display();
								realCard = copyOfCard;

							} else if (num < 25) {
								num = randy.nextInt((24 - 17) + 17);
								if ((num >= 17 && num <= 24) && box2.getCards().size() > 0) {
									boxNum = 2;
									int randCard = randy.nextInt(0, box2.getCards().size());
									cardIndex = randCard;
									ArrayList<flashCard> copyCards = box2.getCards();
									int faceOrBack = randy.nextInt(2);
									flashCard copyOfCard = copyCards.get(randCard);
									if (faceOrBack == 0) {
										cardFlag = true;
									} else if (faceOrBack == 1) {
										cardFlag = false;
									}
									copyOfCard.flipCard(cardFlag);
									copyOfCard.display();
									realCard = copyOfCard;

								} else if (num < 17) {
									num = randy.nextInt((16 - 1) + 1);
									if ((num >= 1 && num <= 16) && box1.getCards().size() > 0) {
										boxNum = 1;
										int randCard = randy.nextInt(0, box1.getCards().size());
										cardIndex = randCard;
										ArrayList<flashCard> copyCards = box1.getCards();
										int faceOrBack = randy.nextInt(2);
										flashCard copyOfCard = copyCards.get(randCard);
										if (faceOrBack == 0) {
											cardFlag = true;
										} else if (faceOrBack == 1) {
											cardFlag = false;
										}
										copyOfCard.flipCard(cardFlag);
										copyOfCard.display();
										realCard = copyOfCard;
									}
								}
								else {
									System.out.println("Cannot draw a card");
								}
							}
						}
					}
					System.out.println("========================================");
					boolean secondFlag = false;
					while (secondFlag == false) {
						System.out.println("a.) Flip Card" + "\nb.)Know the answer" + "\nc.)Don't know answer"
								+ "\nd.)Exit session");
						String subUserInp = sc.nextLine();
						if (subUserInp.equals("a")) {
							if (cardFlag == true) {
								cardFlag = false;
								realCard.flipCard(cardFlag);
								realCard.display();
							} else {
								cardFlag = true;
								realCard.flipCard(cardFlag);
								realCard.display();
							}
						} else if (subUserInp.equals("b")) {
							switch (boxNum) {
							case 1:
								box1.delCard(cardIndex);
								box2.addCard(realCard);
								System.out.println("Card moved to box 2");
								break;
							case 2:
								box2.delCard(cardIndex);
								box3.addCard(realCard);
								System.out.println("Card moved to box 3");
								break;
							case 3:
								box3.delCard(cardIndex);
								box4.addCard(realCard);
								System.out.println("Card moved to box 4");
								break;
							case 4:
								box4.delCard(cardIndex);
								box5.addCard(realCard);
								System.out.println("Card moved to box 5");
								break;
							case 5:
								System.out.println("No other boxes to move card!");
								break;
							}
							break;
						} else if (subUserInp.equals("c")) {
							switch (boxNum) {
							case 2:
								box2.delCard(cardIndex);
								box1.addCard(realCard);
								break;
							case 3:
								box3.delCard(cardIndex);
								box1.addCard(realCard);
								break;
							case 4:
								box4.delCard(cardIndex);
								box1.addCard(realCard);
								break;
							case 5:
								box5.delCard(cardIndex);
								box1.addCard(realCard);
								break;
							}
							System.out.println("Card moved to box 1");
							break;
						} else if (subUserInp.equals("d")) {
							secondFlag = true;
							System.out.println("Study Session Closed");
						} else {
							System.out.print("Invalid card operation");
						}
					}
					System.out.println("\nCard is gone, draw a new card or do the following:");
					System.out.println("\n1.)Pick a random card from a random box" + "\n2.)Add a new card to box 1"
							+ "\n3.)Display cards in a box" + "\n4.)Delete a card" + "\n5.)Modify a card");
				}
				if (userInp.equals("2")) {
					flashCard newCard = new flashCard("FrontNEW", "BackNEW");
					box1.addCard(newCard);
					System.out.println("New card added to box 1");
					System.out.println("What would you like to do?" + "\n1.)Pick a random card from a random box"
							+ "\n2.)Add a new card to box 1" + "\n3.)Display cards in a box" + "\n4.)Delete a card"
							+ "\n5.)Modify a card" + "\n6.)Exit");
				}
				if (userInp.equals("3")) {
					boolean boxChoiceFlag = false;
					System.out.println("Which box would you like to see the cards of? Choose corresponding number"
							+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4" + "\n5.)Box 5"
							+ "\n6.)Stop looking at cards");
					while (boxChoiceFlag == false) {
						String subUserInput = sc.nextLine();
						if (subUserInput.equals("1")) {
							box1.display();
						} else if (subUserInput.equals("2")) {
							box2.display();
						} else if (subUserInput.equals("3")) {
							box3.display();
						} else if (subUserInput.equals("4")) {
							box4.display();
						} else if (subUserInput.equals("5")) {
							box5.display();
						} else if (subUserInput.equals("6")) {
							boxChoiceFlag = true;
							System.out.println("Exiting card display");
							System.out
									.println("What would you like to do?" + "\n1.)Pick a random card from a random box"
											+ "\n2.)Add a new card to box 1" + "\n3.)Display cards in a box"
											+ "\n4.)Delete a card" + "\n5.)Modify a card" + "\n6.)Exit");
						} else {
							System.out.println("Invalid input");
						}
					}
				}
				if (userInp.equals("4")) {
					boolean boxChoiceFlag = false;
					System.out.println("Which box would you like to delete a card from? Choose corresponding number"
							+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4" + "\n5.)Box 5"
							+ "\n6.)Stop looking at cards");
					while (boxChoiceFlag == false) {
						String subUserInput = sc.nextLine();
						if (subUserInput.equals("1")) {
							if (box1.getCards().size() > 0) {
								System.out.println("Input number to remove respective card");
								boolean cardChoiceFlag = false;
								for (flashCard card : box1.getCards()) {
									System.out.println(box1.getCards().indexOf(card) + 1 + ".)" + card.getFront() + ", "
											+ card.getBack());
								}
								while (cardChoiceFlag == false) {
									String subDubInput = sc.nextLine();
									cardIndex = Integer.parseInt(subDubInput) - 1;
									box1.delCard(cardIndex);
									cardChoiceFlag = true;
								}
								System.out.println("Card removed");
								System.out.println(
										"Which box would you like to delete a card from? Choose corresponding number"
												+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4"
												+ "\n5.)Box 5" + "\n6.)Stop looking at cards");
							} else {
								System.out.println("There are no cards to remove!");
							}
						} else if (subUserInput.equals("2")) {
							if (box2.getCards().size() > 0) {
								boolean cardChoiceFlag = false;
								System.out.println("Input number to remove respective card");
								for (flashCard card : box2.getCards()) {
									System.out.println(box2.getCards().indexOf(card) + 1 + ".)" + card.getFront() + ", "
											+ card.getBack());
								}
								while (cardChoiceFlag == false) {
									String subDubInput = sc.nextLine();
									cardIndex = Integer.parseInt(subDubInput) - 1;
									box2.delCard(cardIndex);
									cardChoiceFlag = true;
								}
								System.out.println("Card removed");
								System.out.println(
										"Which box would you like to delete a card from? Choose corresponding number"
												+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4"
												+ "\n5.)Box 5" + "\n6.)Stop looking at cards");
							} else {
								System.out.println("There are no cards to remove!");
							}
						} else if (subUserInput.equals("3")) {
							if (box3.getCards().size() > 0) {
								boolean cardChoiceFlag = false;
								System.out.println("Input number to remove respective card");
								for (flashCard card : box3.getCards()) {
									System.out.println(box3.getCards().indexOf(card) + 1 + ".)" + card.getFront() + ", "
											+ card.getBack());
								}
								while (cardChoiceFlag == false) {
									String subDubInput = sc.nextLine();
									cardIndex = Integer.parseInt(subDubInput) - 1;
									box3.delCard(cardIndex);
									cardChoiceFlag = true;
								}
								System.out.println("Card removed");
								System.out.println(
										"Which box would you like to delete a card from? Choose corresponding number"
												+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4"
												+ "\n5.)Box 5" + "\n6.)Stop looking at cards");
							} else {
								System.out.println("There are no cards to remove!");
							}
						} else if (subUserInput.equals("4")) {
							if (box4.getCards().size() > 0) {
								System.out.println("Input number to remove respective card");
								boolean cardChoiceFlag = false;
								for (flashCard card : box4.getCards()) {
									System.out.println(box4.getCards().indexOf(card) + 1 + ".)" + card.getFront() + ", "
											+ card.getBack());
								}
								while (cardChoiceFlag == false) {
									String subDubInput = sc.nextLine();
									cardIndex = Integer.parseInt(subDubInput) - 1;
									box4.delCard(cardIndex);
									cardChoiceFlag = true;
								}
								System.out.println("Card removed");
								System.out.println(
										"Which box would you like to delete a card from? Choose corresponding number"
												+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4"
												+ "\n5.)Box 5" + "\n6.)Stop looking at cards");
							} else {
								System.out.println("There are no cards to remove!");
							}
						} else if (subUserInput.equals("5")) {
							if (box5.getCards().size() > 0) {
								System.out.println("Input number to remove respective card");
								boolean cardChoiceFlag = false;
								for (flashCard card : box5.getCards()) {
									System.out.println(box5.getCards().indexOf(card) + 1 + ".)" + card.getFront() + ", "
											+ card.getBack());
								}
								while (cardChoiceFlag == false) {
									String subDubInput = sc.nextLine();
									cardIndex = Integer.parseInt(subDubInput) - 1;
									box5.delCard(cardIndex);
									cardChoiceFlag = true;
								}
								System.out.println("Card removed");
								System.out.println(
										"Which box would you like to delete a card from? Choose corresponding number"
												+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4"
												+ "\n5.)Box 5" + "\n6.)Stop looking at cards");
							} else {
								System.out.println("There are no cards to remove");
							}
						} else if (subUserInput.equals("6")) {
							boxChoiceFlag = true;
							System.out.println("Exiting card removal");
							System.out
									.println("What would you like to do?" + "\n1.)Pick a random card from a random box"
											+ "\n2.)Add a new card to box 1" + "\n3.)Display cards in a box"
											+ "\n4.)Delete a card" + "\n5.)Modify a card" + "\n6.)Exit");

						} else {
							System.out.println("Invalid input");
						}
					}
				}

				if (userInp.equals("5")) {
					boolean boxChoiceFlag = false;
					boolean cardModFlag = false;
					System.out.println("Which box would you like to modify a card from? Choose corresponding number"
							+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4" + "\n5.)Box 5"
							+ "\n6.)Stop looking at cards");
					while (boxChoiceFlag == false) {
						String subUserInput = sc.nextLine();
						if (subUserInput.equals("1")) {
							if (box1.getCards().size() > 0) {
								System.out.println("Input number to modify respective card");
								for (flashCard card : box1.getCards()) {
									System.out.println(box1.getCards().indexOf(card) + 1 + ".)" + card.getFront() + ", "
											+ card.getBack());
								}
								while (cardModFlag == false) {
									String subDubInput = sc.nextLine();
									cardIndex = Integer.parseInt(subDubInput) - 1;
									box1.getCards().get(cardIndex);
									System.out.println("Input a front");
									String subDubBubInput = sc.nextLine();
									box1.getCards().get(cardIndex).setFront(subDubBubInput);
									System.out.println("Input a back");
									String subBubDubInput = sc.nextLine();
									box1.getCards().get(cardIndex).setBack(subBubDubInput);
									cardModFlag = true;
								}
								System.out.println("Card modified");
								System.out.println(
										"Which box would you like to modify a card from? Choose corresponding number"
												+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4"
												+ "\n5.)Box 5" + "\n6.)Stop looking at cards");
							} else {
								System.out.println("No cards to modify!");
							}
						} else if (subUserInput.equals("2")) {
							System.out.println("Input number to modify respective card");
							if (box2.getCards().size() > 0) {
								for (flashCard card : box2.getCards()) {
									System.out.println(box2.getCards().indexOf(card) + 1 + ".)" + card.getFront() + ", "
											+ card.getBack());
								}
								while (cardModFlag == false) {
									String subDubInput = sc.nextLine();
									cardIndex = Integer.parseInt(subDubInput) - 1;
									box2.getCards().get(cardIndex);
									System.out.println("Input a front");
									String subDubBubInput = sc.nextLine();
									box2.getCards().get(cardIndex).setFront(subDubBubInput);
									System.out.println("Input a back");
									String subBubDubInput = sc.nextLine();
									box2.getCards().get(cardIndex).setBack(subBubDubInput);
									break;
								}
								System.out.println("Card modified");
								System.out.println(
										"Which box would you like to modify a card from? Choose corresponding number"
												+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4"
												+ "\n5.)Box 5" + "\n6.)Stop looking at cards");

							} else {
								System.out.println("No cards to modify!");
							}
						} else if (subUserInput.equals("3")) {
							if (box3.getCards().size() > 0) {
								System.out.println("Input number to modify respective card");
								for (flashCard card : box3.getCards()) {
									System.out.println(box3.getCards().indexOf(card) + 1 + ".)" + card.getFront() + ", "
											+ card.getBack());
								}
								while (cardModFlag == false) {
									String subDubInput = sc.nextLine();
									cardIndex = Integer.parseInt(subDubInput) - 1;
									box3.getCards().get(cardIndex);
									System.out.println("Input a front");
									String subDubBubInput = sc.nextLine();
									box3.getCards().get(cardIndex).setFront(subDubBubInput);
									System.out.println("Input a back");
									String subBubDubInput = sc.nextLine();
									box3.getCards().get(cardIndex).setBack(subBubDubInput);
									break;
								}
								System.out.println("Card modified");
								System.out.println(
										"Which box would you like to modify a card from? Choose corresponding number"
												+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4"
												+ "\n5.)Box 5" + "\n6.)Stop looking at cards");
							} else {
								System.out.println("No cards to modify!");
							}
						} else if (subUserInput.equals("4")) {
							if (box4.getCards().size() > 0) {
								System.out.println("Input number to modify respective card");
								for (flashCard card : box4.getCards()) {
									System.out.println(box4.getCards().indexOf(card) + 1 + ".)" + card.getFront() + ", "
											+ card.getBack());
								}
								while (cardModFlag == false) {
									String subDubInput = sc.nextLine();
									cardIndex = Integer.parseInt(subDubInput) - 1;
									box4.getCards().get(cardIndex);
									System.out.println("Input a front");
									String subDubBubInput = sc.nextLine();
									box4.getCards().get(cardIndex).setFront(subDubBubInput);
									System.out.println("Input a back");
									String subBubDubInput = sc.nextLine();
									box4.getCards().get(cardIndex).setBack(subBubDubInput);
									break;
								}
								System.out.println("Card modified");
								System.out.println(
										"Which box would you like to modify a card from? Choose corresponding number"
												+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4"
												+ "\n5.)Box 5" + "\n6.)Stop looking at cards");
							} else {
								System.out.println("No cards to modify!");
							}
						} else if (subUserInput.equals("5")) {
							if (box5.getCards().size() > 0) {
								System.out.println("Input number to modify respective card");
								for (flashCard card : box5.getCards()) {
									System.out.println(box5.getCards().indexOf(card) + 1 + ".)" + card.getFront() + ", "
											+ card.getBack());
								}
								while (cardModFlag == false) {
									String subDubInput = sc.nextLine();
									cardIndex = Integer.parseInt(subDubInput) - 1;
									box5.getCards().get(cardIndex);
									System.out.println("Input a front");
									String subDubBubInput = sc.nextLine();
									box5.getCards().get(cardIndex).setFront(subDubBubInput);
									System.out.println("Input a back");
									String subBubDubInput = sc.nextLine();
									box5.getCards().get(cardIndex).setBack(subBubDubInput);
									break;
								}
								System.out.println("Card modified");
								System.out.println(
										"Which box would you like to modify a card from? Choose corresponding number"
												+ "\n1.)Box 1" + "\n2.)Box 2" + "\n3.)Box 3" + "\n4.)Box 4"
												+ "\n5.)Box 5" + "\n6.)Stop looking at cards");
							} else {
								System.out.println("No cards to modify!");
							}
						} else if (subUserInput.equals("6")) {
							boxChoiceFlag = true;
							System.out.println("Exiting card modifier");

						} else {
							System.out.println("Invalid input");
						}
					}
				}
				if (userInp.equals("6")) {
					System.out.println("Bye bye!");
					firstFlag = true;
					sc.close();
				}
			}
		}
	}
}