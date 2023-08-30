public class Flashcard implements displayInterface {
    private String front;
    private String back;

    private boolean face = false;

    Flashcard(String fCard, String bCard){
        this.setFront(fCard);
        this.setBack(bCard);
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }


    public void setBack(String back) {
        this.back = back;
    }

    //false is front, true is back
    //function acts as a setter for the face of the card object, which effects what is displayed upon the card

    public void flipCard(boolean cardFace){
        this.face = cardFace;
    }

    @Override
    public void display() {
        if(!face){
            System.out.println(this.getFront());
        }
        else{
            System.out.println(this.getBack());
        }
    }
}
