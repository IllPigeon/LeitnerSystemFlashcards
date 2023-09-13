public class Flashcard implements displayInterface {
    private String front;
    private String back;
    private int cardId;
    private boolean face = false;

    Flashcard(String fCard, String bCard, int cardId){
        this.setFront(fCard);
        this.setBack(bCard);
        this.setCardId(cardId);
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

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    //false is front, true is back
    //function acts as a setter for the face of the card object, which effects what is displayed upon the card
    public void flipCard(boolean cardFace){
        this.face = cardFace;
    }

    @Override
    public void display() {
        if(!face){
            System.out.println(this.cardId +".) "+ this.getFront());
        }
        else{
            System.out.println(this.cardId +".) "+this.getBack());
        }
    }
}
