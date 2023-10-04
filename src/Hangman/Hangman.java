package Hangman;
import java.util.Scanner;
import java. util. Random;

import static java.lang.Integer.parseInt;

public class Hangman
{
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("HANGMAN\n" + "The game will be available soon.\n");

        System.out.println("---- Play #1 -----");
        System.out.print("HANGMAN\n" + "Guess the word: >");
        f_etap1 (scn.nextLine());
        System.out.println("\n---- Play #2 -----");
        f_etap2 ();
    }
    public static void f_etap1(String s)
    {
        System.out.println(s.equals("java") ? "You survived!" : "You lost!");

        if (s.equals("java"))
            Hangman.f_draw(0) ;
        else
            Hangman.f_draw(8);
    }
    public static void f_etap2()
    {
        String answer;
        int right_answer  = Hangman.f_random(8);

        String[] s = {"python", "java", "javascript", "kotlin", "hindi", "sherlock", "morze", "binary"};

        System.out.print("HANGMAN\n" + "Guess the word from the list: ");

        for (int i = 0; i < s.length; i++)
        {
            System.out.print(s[i] + ( i < s.length-1 ? ", ":""));
        }

        System.out.print("\n(enter the word number from 1 to 8): >");
        answer = scn.nextLine();

        while (!("1,2,3,4,5,6,7,8".contains(answer) && answer.length()==1))
        {
            System.out.print("You entered: " + answer + ".\n Enter the word number from 1 to 8: >");
            answer = scn.nextLine();
        }

        if (String.format("%d",right_answer) == answer)
        {
            System.out.println("\nYou are right: \"" + s[right_answer]+"\"");
            Hangman.f_draw(0) ;
        }
        else
        {
            System.out.println("Your choice: \"" + s[parseInt (answer)-1] + "\", but right answer: \"" + s[right_answer] +"\"");
            Hangman.f_draw(8);
        }

    }
    public static void f_draw(int lost)
    {
        String[] d = new String[9];
        d[0] = "   ______    \n  |/  \n  | \n  | \n  | \n  |  \n _|_  ";
        d[8] = "   ______    \n  |/     |   \n  |      O   \n  |     /|\\ \n  |      |   \n  |     / \\ \n _|_  ";

        System.out.println(d[lost]);
       /* System.out.println(
                "   ______    \n" +
                "  |/     |   \n" +
                "  |      O   \n" +
                "  |     /|\\ \n" +
                "  |      |   \n" +
                "  |     / \\ \n" +
                " _|_  ");
        */
    }
    public static int f_random(int rmax)
    {
        Random random = new Random();
        int rand = 0;
        while (true)
        {
            rand = random.nextInt(rmax + 1);
            if(rand != 0) break;
        }
        return rand;
    }
}
