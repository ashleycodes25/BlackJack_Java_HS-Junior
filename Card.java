public class Card{
   private String suit;
   private int value;
   public Card(int value, String suit){
       this.value = value;
       this.suit = suit;
   }
   public int getValue(){
       return value;
   }
   public String getSuit(){
       return suit;
   }
   public String getTextValue(){
       if(value == 1){
           return "Ace";
       }
       else if(value >= 2 && value <= 10){
           return String.valueOf(value);
       }
       else if(value == 11){
           return "Jack";
       }
       else if(value == 12){
           return "Queen";
       }
       else if(value == 13){
           return "King";
       }
       return "";
   }
   public String toString(){
       return getTextValue() + getSuit();
   }
}