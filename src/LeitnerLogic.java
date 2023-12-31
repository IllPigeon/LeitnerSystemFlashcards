import java.util.Scanner;
import java.util.Random;
public class LeitnerLogic {
    private static final Scanner scanner = new Scanner(System.in);

    private static int numOfBoxes;
    private static Boxes[] boxCollection;


    private static void initializeBoxes(int input){
        numOfBoxes = input;
        boxCollection = new Boxes[numOfBoxes];
    }


    //used for creating boxes for leitner system
    private static void createBoxes(){
        System.out.println("""
                WELCOME TO THE LEITNER SYSTEM!
                ==============================
                To begin, input whether you want 3, 4 or 5 boxes to contain flashcards.
                """);
        while(true){
            initializeBoxes(scanner.nextInt());
            if(numOfBoxes >= 3 && numOfBoxes <= 5){
                for(int i = 1; i < numOfBoxes + 1; i++){
                    Boxes box = new Boxes("Box "+ i);
                    boxCollection[i - 1] = box;
                }
                break;
            }
            else{
                System.out.println("Please choose either 3, 4, or 5");
            }
        }
        //Adding 5 starting cards to box 1 by default
        for(int i = 1; i < 6; i++){
            boxCollection[0].getCards().add(new Flashcard("Front "+i, "Back "+i, i));
        }
    }


    //acts as a method for users to either draw a random card from a box
    // or select a box to interact with or quit the program
    public static void mainMenu(){
        if(boxCollection == null){
            createBoxes();
        }
        boolean menuFlag = true;
        System.out.println("""
                LEITNER SYSTEM FLASH CARDS
                ==========================
                1.) Draw a random card
                2.) Select a box
                3.) Quit""");
        while(menuFlag){
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> System.out.println("Drew a card");
                case 2 -> {
                    System.out.println("Checking Boxes...");
                    boxMenu();
                }
                case 3 -> {
                    System.out.println("Buh-Bye!");
                    menuFlag = false;
                    scanner.close();
                }
            }
        }
    }

    public static void boxMenu(){
        boolean menuFlag = true;
        System.out.println("""
                SELECT A BOX
                ==========================
                """);
        for(int i = 0; i < numOfBoxes; i++){
            if(i == 0){
                System.out.println(1+".) "+boxCollection[i].getBoxName()
                        + " | # Of Cards: " + boxCollection[i].getCards().size());
            }
            else{
                System.out.println((i+1)+".) "+boxCollection[i].getBoxName()
                        + " | # Of Cards: " + boxCollection[i].getCards().size());
            }
        }
        System.out.println(numOfBoxes + 1 +".) Back to Main Menu");
        while(menuFlag){
            int input = scanner.nextInt();
            if(input == numOfBoxes + 1){
                System.out.println("Going to Main Menu...");
                mainMenu();
            }
            else if (boxCollection[input-1] != null){
                cardBoxMenu(boxCollection[input-1]);
            }
            else{
                System.out.println("Invalid choice");
            }
        }
    }

    public static void cardBoxMenu(Boxes selectedBox){
        boolean menuFlag = true;
        int cardNum = 1;
        System.out.println("""
                PICK CARD OR CREATE ONE
                ==========================""");
        selectedBox.display();
        System.out.println((selectedBox.getCards().size() + 1) +".) "+"Create a new card\n" +
                (selectedBox.getCards().size()+2)+ ".) "+"View Boxes\n");
        while(menuFlag){
            int input = scanner.nextInt();
            if(input == selectedBox.getCards().size() + 2){
                System.out.println("Viewing boxes...");
                boxMenu();
            }
            else if(input == selectedBox.getCards().size() + 1){
                addCardMenu(selectedBox);
            }
            else if(selectedBox.getCards().get(input - 1) != null){
                System.out.println("Showing cards...");
                cardMenu(selectedBox.getCards().get(input - 1), selectedBox);
            }
            else{
                System.out.println("Invalid card or command!");
            }
        }
    }


    //Menu used for displaying what user can do with card that they select from a box
    //ideally this will display upon a card being drawn
    public static void cardMenu(Flashcard selectedCard, Boxes selectedBox){
        boolean menuFlag = true;
        selectedCard.display();
        System.out.println("""
                ==========================
                1.) Flip Card
                2.) Edit Card
                3.) Move Card
                4.) View Boxes""");
        while(menuFlag){
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.println("Card Flipped");
                    selectedCard.flipCard();
                    selectedCard.display();
                }
                case 2 -> {
                    System.out.println("Modifying card...");
                    editCardMenu(selectedCard, selectedBox);
                }
                case 3 ->{
                    moveCardBoxMenu(selectedCard, selectedBox);
                }
                case 4 -> {
                    System.out.println("Viewing Cards...");
                    cardBoxMenu(selectedBox);
                }
            }
        }
    }


    //Used for moving selected card from current box to selected destination box in function.
    public static void moveCardBoxMenu(Flashcard selectedCard, Boxes currentBox){
        boolean menuFlag = true;
        System.out.println("""
                SELECT DESTINATION BOX
                ==========================
                """);
        for(int i = 0; i < numOfBoxes; i++){
            if(i == 0){
                System.out.println(1+".) "+boxCollection[i].getBoxName()
                        + " | # Of Cards: " + boxCollection[i].getCards().size());
            }
            else{
                System.out.println((i+1)+".) "+boxCollection[i].getBoxName()
                        + " | # Of Cards: " + boxCollection[i].getCards().size());
            }
        }

        System.out.println(numOfBoxes + 1 +".) Back to Main Menu");
        while(menuFlag){
            int input = scanner.nextInt();
            if(input == numOfBoxes + 1){
                System.out.println("Cancel Move");
                cardMenu(selectedCard, currentBox);
            }
            else if (boxCollection[input-1] != null){
                System.out.println("Moving card...");
                currentBox.moveCard(selectedCard, boxCollection[input - 1]);
                cardBoxMenu(boxCollection[input - 1]);
            }
            else{
                System.out.println("Invalid choice");
            }
        }
    }


    public static void addCardMenu(Boxes selectedBox){
        //consuming leftover newline character from scanner for int input
        scanner.nextLine();
        System.out.println("FRONT OF CARD\n " + "==========================");
        String front = scanner.nextLine();
        System.out.println("BACK OF CARD\n " + "==========================");
        String back = scanner.nextLine();
        if(selectedBox.getCards().size() == 0){
            selectedBox.getCards().add(new Flashcard(front, back, 1));
            cardBoxMenu(selectedBox);
        }
        else{
            selectedBox.getCards().add(new Flashcard(front, back, selectedBox.getCards().size() + 1));
            cardBoxMenu(selectedBox);
        }
    }

    public static void editCardMenu(Flashcard selectedCard, Boxes selectedBox){
        boolean menuFlag = true;
        System.out.println("Front: " + selectedCard.getFront());
        System.out.println("Back: " + selectedCard.getBack());
        System.out.println("=====================");
        System.out.println("""
                1.) Edit front
                2.) Edit back
                3.) Back to cards
                """);
        while(menuFlag){
            int input = scanner.nextInt();
            if(input == 1){
                System.out.println("Modifying Front");
                scanner.nextLine();
                String front = scanner.nextLine();
                selectedCard.setFront(front);
            }
            else if(input == 2){
                System.out.println("Modifying Back...");
                scanner.nextLine();
                String back = scanner.nextLine();
                selectedCard.setBack(back);
            }
            else if(input == 3){
                System.out.println("Viewing Cards...");
                cardBoxMenu(selectedBox);
            }
            else{
                System.out.println("INVALID INPUT");
            }
        }
    }

    public void drawCard(){

    }
}


