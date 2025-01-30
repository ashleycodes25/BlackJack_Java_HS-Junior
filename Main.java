import java.util.*;
public class Main{
    public static void main(String[] args){
        boolean playingGame = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to BlackJack!");
        System.out.println("Please enter your name:");
        String name = scan.nextLine();
        System.out.println();
        Player p = new Player(name);
        Player c = new Player("Computer");
        System.out.println("Hello " + name + "!");
        int roundNumber = 1;
        int playerScore = 0;
        int computerScore = 0;
        boolean playerBusted = false;
        boolean playerWonPerfect = false;
        int deckSize = 0;
        Deck deck = new Deck();
        for(int i = 0; i < 3; i++){
            deck.riffleShuffle();
        }
        deck.fisherYatesShuffle();
        do{
            System.out.println("Welcome to round " + roundNumber + "!");
            System.out.println();
            System.out.println("Creating and shuffling the deck...");
            System.out.println("Dealing out two cards...");
            System.out.println("Drumroll please...");
            System.out.println();
            p.getHand().add(deck.getDeck().pop());
            c.getHand().add(deck.getDeck().pop());
            p.getHand().add(deck.getDeck().pop());
            c.getHand().add(deck.getDeck().pop());
            System.out.println("Your hand is: " + p.getHand());
            System.out.println("Your hand is worth: " + p.blackJackHandValue());
            System.out.println();
            boolean playerTurn = true;
            while(playerTurn){
                if(p.blackJackHandValue() == 21){
                    System.out.println("Wow! You WON because you got a blackjack with a value of 21!");
                    playerWonPerfect = true;
                    playerScore++;
                    break;
                }
                System.out.println("Would you like to hit or stay? (Type 'h' or 's')");
                String hitOrStay = scan.nextLine();
                if(hitOrStay.equals("h")){
                    p.getHand().add(deck.getDeck().pop());
                    System.out.println("Your hand is: " + p.getHand());
                    System.out.println("Your hand is worth: " + p.blackJackHandValue());
                    System.out.println();
                    if(p.blackJackHandValue() > 21){
                        System.out.println("Uh oh... You LOSE because you busted!!!");
                        playerBusted = true;
                        computerScore++;
                        playerTurn = false;
                    }
                }
                else{
                    playerTurn = false;
                }
            }
            if(!playerBusted && !playerWonPerfect){
                while(c.blackJackHandValue() < 17){
                    System.out.println("The computer hit.");
                    c.getHand().add(deck.getDeck().pop());
                }
                System.out.println("Computer has: " + c.getHand());
                System.out.println("Blackjack Val: " + c.blackJackHandValue());
                System.out.println();
                if(c.blackJackHandValue() > 21){
                    System.out.println("You WIN because the computer busted!");
                    playerScore++;
                }
                else if(p.blackJackHandValue() > c.blackJackHandValue()){
                    System.out.println("Congrats!!!");
                    System.out.println("You WIN because your hand value is higher than the computer's!");
                    playerScore++;
                }
                else if(p.blackJackHandValue() == c.blackJackHandValue()){
                    System.out.println("Life isn't fair is it...");
                    System.out.println("You LOSE because your hand value is equal to the computer's.");
                    computerScore++;
                }
                else if(p.blackJackHandValue() < c.blackJackHandValue()){
                    System.out.println("Better luck next time...");
                    System.out.println("You LOSE because your hand value is lower.");
                    computerScore++;
                }
            }
            else{
                playerBusted = false;
                playerWonPerfect = false;
            }
            System.out.println();
            System.out.println("Round " + roundNumber + " is finished!");
            System.out.println("Here is the current tally: ");
            System.out.println("The computer's score is: " + computerScore);
            System.out.println("Your score is: " + playerScore);
            System.out.println();
            System.out.println("Do you want to play again? Type: 'y' or 'n'");
            String playAgain = scan.nextLine();
            if(playAgain.equals("y")){
                System.out.println("Awesome! Good luck!");
                System.out.println();
                p.getHand().clear();
                c.getHand().clear();
                if(deck.getDeck().size() <= 16){
                    deck = new Deck();
                    for(int i = 0; i < 3; i++){
                        deck.riffleShuffle();
                    }
                    deck.fisherYatesShuffle();
                }
                roundNumber++;
            }
            else{
                System.out.println("Thanks for playing!");
                System.out.println();
                System.out.println("The final tally is...");
                System.out.println("Computer: " + computerScore);
                System.out.println("You: " + playerScore);
                System.out.println();
                if(playerScore > computerScore){
                    System.out.println("You won!");
                }
                if(playerScore < computerScore){
                    System.out.println("You lost.");
                }
                if(playerScore == computerScore){
                    System.out.println("You tied.");
                }
                playingGame = false;
            }
        }
        while(playingGame);
    }
}