package main.java.com.eugene;

import java.util.Random;
import java.util.Scanner;

public class App {
    private static String randomiseComputerMove(){
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        String computerMove = Move.values()[randomNumber].getValue();
        System.out.println(String.format("Computer Move: %s", computerMove));
        return computerMove;
    }

    private static boolean isPlayerWin(String playerMove, String computerMove){
        return ( (playerMove.equals(Move.PAPER.value) && computerMove.equals(Move.ROCK.value))
        || (playerMove.equals(Move.ROCK.value) && computerMove.equals(Move.SCISSORS.value))
        || (playerMove.equals(Move.SCISSORS.value) && computerMove.equals(Move.PAPER.value))
        ) ;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int wins = 0;
        int losses = 0;

        System.out.println("Welcome to Rock paper Scissors! Please enter \"rock\", \"paper\",\"scissors\" to play or \"quit\" to exit");

        while(true){
            System.out.println("______________________________");
            System.out.println("Please enter your move");
            String playerMove = scanner.nextLine();

            if(playerMove.equals("quit")){
                System.out.println("Thanks for playing!");
                System.out.println(String.format("You won %d and loss %d. We hope you had fun, see you again next time!", wins, losses));
                System.exit(0);
            }

            Move[] validMoves = Move.values();
            boolean valid = false;
            for(int i =0; i< validMoves.length; i++ ){
                if(playerMove.equals(validMoves[i].value)){
                    valid = true;
                }
            }

            if(!valid){
                System.out.println("Your input is not valid, please enter again.");
                continue;
            }

            String computerMove = randomiseComputerMove();

            if(isPlayerWin(playerMove, computerMove)){
                wins++;
                System.out.println(String.format("Congratulations you won! Current stats: %d wins and %d lossers ", wins, losses));
            } else {
                if(playerMove.equals(computerMove)){
                    System.out.println(String.format("It's a tie! Current stats: %d wins and %d lossers ", wins, losses));
                } else {
                    losses++;
                    System.out.println(String.format("You lost... better luck next time! Current stats: %d wins and %d lossers ", wins, losses));
                }
            }

        }
    }

}
