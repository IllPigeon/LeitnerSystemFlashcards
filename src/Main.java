public class Main {
    //TODO: Make logic for moving cards to different boxes in leitner system
    //TODO: Create GUI for cards
    static Boxes box1 = new Boxes("Box 1");
    static Boxes box2 = new Boxes("Box 2");
    static Boxes box3 = new Boxes("Box 3");
    static Boxes box4 = new Boxes("Box 4");
    static Boxes box5 = new Boxes("Box 5");

    public static void main(String[] args) {

//        Flashcard card1 = new Flashcard("front1", "back1");
//        Flashcard card2 = new Flashcard("front2", "back2");
//
//        box1.addCard(card1);
//        box1.addCard(card2);
//        box1.display();
//        box1.moveCard(card1, box2);
//        box1.delCard(card2);
//
//        System.out.println("AFTER DELETION OF CARD2");
//        box1.display();
//        box2.display();

        LeitnerLogic.mainMenu();
    }
}