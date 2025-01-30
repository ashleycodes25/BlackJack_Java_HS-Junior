import java.util.*;
public class Player{
    private ArrayList<Card> hand;
    private String name;
    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
    }
    public String getName(){
        return name;
    }
    public List<Card> getHand(){
        return hand;
    }
    public int blackJackHandValue(){
        int count = 0;
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i).getValue() >= 2 && hand.get(i).getValue() <= 10){
                count += hand.get(i).getValue();
            }
            else if(hand.get(i).getValue() == 11 || hand.get(i).getValue() == 12 || hand.get(i).getValue() == 13){
                count += 10;
            }
            else if(hand.get(i).getValue() == 1){
                count += 11;
            }
        }
        for(int i = 0; i < hand.size(); i++){
            if(count > 21 && hand.get(i).getValue() == 1){
                count -= 10;
            }
        }
        return count;
    }
}