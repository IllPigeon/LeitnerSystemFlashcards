import java.util.Scanner;
import java.util.Random;
public class LeitnerLogic {

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
        Scanner scanner = new Scanner (System.in);
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

    }

    //acts as a method for users to either draw a random card from a box
    // or select a box to interact with or quit the program
    public static void mainMenu(){
        createBoxes();
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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
        while(menuFlag){
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> System.out.println("Card flipped");
                case 2 -> System.out.println("Card Modified");
                case 3 -> {
                    System.out.println("Viewing Boxes...");
                    menuFlag = false;
                    scanner.close();
                }
            }
        }
    }

    //Menu used for displaying what user can do with card that they select from a box
    //ideally this will display upon a card being drawn
    public static void cardMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean menuFlag = true;
        System.out.println("""
                CARD OPTIONS
                ==========================
                1.) Flip Card
                2.) Edit Card
                3.) Move Card
                4.)Create Card
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
