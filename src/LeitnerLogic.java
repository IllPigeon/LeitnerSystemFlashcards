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
            boxCollection[0].getCards().add(new Flashcard("Front "+i, "Back "+i));
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
                    menuFlag = false;
                    System.out.println("Checking Boxes...");
                    boxMenu();
                    scanner.close();
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
                menuFlag = false;
                System.out.println("Going to Main Menu...");
                mainMenu();
            }
            else if (boxCollection[input-1] != null){
                menuFlag = false;
                cardBoxMenu(boxCollection[input-1]);
            }
            else{
                System.out.println("Invalid choice");
            }
//            switch (input) {
//                case 1 -> System.out.println("Card flipped");
//                case 2 -> System.out.println("Card Modified");
//                case 3 -> {
//                    System.out.println("Viewing Boxes...");
//                    menuFlag = false;
//                    scanner.close();
//                }
//            }
        }
    }

    public static void cardBoxMenu(Boxes selectedBox){
        boolean menuFlag = true;
        System.out.println("Pick a Card or Create One!");
        selectedBox.display();
        while(menuFlag){
            int input = scanner.nextInt();
            if(selectedBox.getCards().get(input) != null){
                cardMenu(selectedBox.getCards().get(input));
            }
            else if(input == selectedBox.getCards().size() + 1){
                addCardMenu();
            }
            else if(input == selectedBox.getCards().size() + 2){
                System.out.println("Going Back to Box Menu");
                boxMenu();
            }
        }
    }

    public static void addCardMenu(){

    }


    //Menu used for displaying what user can do with card that they select from a box
    //ideally this will display upon a card being drawn
    public static void cardMenu(Flashcard selectedCard){
        boolean menuFlag = true;
        System.out.println("""
                CARD OPTIONS
                ==========================
                1.) Flip Card
                2.) Edit Card
                3.) Move Card
                5.) View Boxes""");
        while(menuFlag){
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> System.out.println("Card flipped");
                case 2 -> System.out.println("Card Modified");
                case 3 -> {
                    System.out.println("Viewing Boxes...");
                    menuFlag = false;
                    scanner.close();
                    boxMenu();
                }
            }
        }
    }
}
