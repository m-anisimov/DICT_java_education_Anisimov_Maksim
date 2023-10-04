package Hangman;
import java.util.Scanner;
public class Hangman {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String word, answer;

        System.out.println("HANGMAN\n" +
                "The game will be available soon.\n");

        System.out.print("HANGMAN\n" +
                "Guess the word: >");
        word = scn.nextLine();
        answer = word.equals("java") ? "You survived!" : "You lost!";
        System.out.println(answer);
    }
}
