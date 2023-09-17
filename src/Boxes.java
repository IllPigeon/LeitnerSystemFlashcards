import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Boxes implements displayInterface{

    private final String boxName;
    private final ArrayList<Flashcard> cards = new ArrayList<>();

    public Boxes(String name){
        this.boxName = name;
    }

    public String getBoxName(){
        return boxName;
    }

    public ArrayList<Flashcard> getCards(){
        return cards;
    }

    public Flashcard getCard(int index){
        if(getCards().get(index) == null){
            System.out.println("ERROR: Card does not exist");
            return null;
        }
        if(getCards().size() == 0){
            System.out.println("No cards to draw in box");
        }

        getCards().get(index).display();
        return getCards().get(index);
    }

    public void addCard(Flashcard newCard){
        getCards().add(newCard);
        System.out.println(newCard.getFront() + " added to "+ boxName);
    }

    //delete Card from array list
    public void delCard(Flashcard cardToDelete){
        if(getCards().size() == 0){
            System.out.println("No card to remove");
        }
        cards.remove(cardToDelete);
        System.out.println(cardToDelete.getFront() + " successfully removed");
    }

    public void moveCard(Flashcard cardToMove, Boxes boxDestination){
        cards.remove(cardToMove);
        boxDestination.getCards().add(cardToMove);
        System.out.println(cardToMove.getFront() +" moved successfully");
    }

    @Override
    public void display() {
        System.out.println("=== "+getBoxName()+" ===");
        if (cards.size() == 0) {
            System.out.println(boxName + " is empty");
        } else {
            for (Flashcard c : cards) {
                c.display();
            }
        }
        System.out.println("=== End of "+ getBoxName() + " ===");
    }
}
