package Hangman;
import java.util.Scanner;
import java. util. Random;

import static java.lang.Integer.parseInt;

public class Hangman
{
    public static Scanner scn = new Scanner(System.in);
    static String answer;
    static String[] s = {"python", "java", "javascript", "kotlin", "hindi", "sherlock", "morze", "binary"};
    static String[] s4 = {"python", "java", "javascript", "kotlin"};
    static  int right_answer;

    public static void main(String[] args)
    {
        System.out.println("HANGMAN\n" + "The game will be available soon.\n");

/*        System.out.println("---- Play #1 -----(stage 2)");
        f_stage2 (scn.nextLine());

        System.out.println("\n---- Play #2 -----(stage 3)");
       f_stage3 ();

        System.out.println("\n---- Play #3 -----(stage 4)");
        f_stage4 ();

        System.out.println("\n---- Play #4 -----(stage 5)");
        f_stage5 ();*/

        System.out.println("\n---- Play #5 -----(stage 6)");
        f_stage6 ();
    }
    public static void f_stage2(String s)
    {
        System.out.print("HANGMAN\n" + "Guess the word: >");
        System.out.println(s.equals("java") ? "You survived!" : "You lost!");

        if (s.equals("java"))
            Hangman.f_draw(0) ;
        else
            Hangman.f_draw(8);
    }
    public static void f_stage3()
    {
        right_answer  = Hangman.f_random(8);
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
    public static void f_stage4()
    {
        right_answer  = Hangman.f_random(8);
        System.out.print("HANGMAN\n" + "Guess the word (from the list: ");

        for (int i = 0; i < s.length; i++)
        {
            System.out.print(s[i] + ( i < s.length-1 ? ", ":""));
        }

        System.out.print(")\n(" + s[right_answer] + ") "
                + s[right_answer].substring(0,2)
                + "-".repeat(s[right_answer].length()-2)
                + " :> ");

        answer = scn.nextLine();
        System.out.println(answer.equals(s[right_answer]) ? "You survived!" : "You lost!");

        if (answer.equals(s[right_answer]))
        {
            System.out.println("You are right: \"" + s[right_answer]+"\"");
            Hangman.f_draw(0) ;
        }
        else
        {
            System.out.println("Your choice: \"" + answer + "\", but right answer: \"" + s[right_answer] +"\"");
            Hangman.f_draw(8);
        }
    }
    public static void f_stage5()
    {
        right_answer = Hangman.f_random(4);
        int letter_num, len;
        String letter, answer_line, tmp_line;
        char current_simbol;
        len = s4[right_answer].length();
        answer_line = "-".repeat(len);
        tmp_line = answer_line;

        System.out.println("HANGMAN\n");

        for(int j=0; j <8; j++)
        {
            System.out.println(answer_line);
            System.out.print("Input a letter:> ");
            letter = scn.nextLine();
            letter_num = s4[right_answer].indexOf(letter);

            if (letter_num == -1)
            {
                System.out.println("That letter doesn't appear in the word\n");
            }
            else
            {
                tmp_line = "";

                for (int i = 0; i < len; i++)
                {
                    if (s4[right_answer].charAt(i) == letter.charAt(0))
                    {
                        tmp_line = tmp_line + letter.charAt(0);
                    }
                    else
                    {
                        if (answer_line.charAt(i) == '-')
                            tmp_line = tmp_line + "-";
                        else
                            tmp_line = tmp_line + answer_line.charAt(i);
                    }
                }
                answer_line = tmp_line;
            }
        }
        System.out.println(answer_line);
        System.out.println("Thanks for playing!\n" +
            "We'll see how well you did in the next stage");
    }
    public static void f_stage6()
    {
        right_answer = Hangman.f_random(4);
        int letter_num, len;
        String letter, answer_line, tmp_line;
        char current_simbol;
        len = s4[right_answer].length();
        answer_line = "-".repeat(len);
        tmp_line = answer_line;

        System.out.println("HANGMAN\n");

        for(int j=0; j <8; j++)
        {
            System.out.println(answer_line);
            System.out.print("Input a letter:> ");
            letter = scn.nextLine();
            letter_num = s4[right_answer].indexOf(letter);

            if (letter_num == -1)
            {
                System.out.println("That letter doesn't appear in the word\n");
            }
            else
            {
                if (answer_line.indexOf(letter)!=-1)
                {
                    System.out.println("No improvements\n");
                }
                else
                {
                    j--; //не учитываем попытку, т.к. игрок угадал букву, в т.ч. не угаданную в предыдущих попытках
                    tmp_line = "";
                    System.out.print("\n");

                    for (int i = 0; i < len; i++)
                    {
                        if (s4[right_answer].charAt(i) == letter.charAt(0))
                        {
                            tmp_line = tmp_line + letter.charAt(0);
                        }
                        else
                        {
                            if (answer_line.charAt(i) == '-')
                                tmp_line = tmp_line + "-";
                            else
                                tmp_line = tmp_line + answer_line.charAt(i);
                        }
                    }
                    answer_line = tmp_line;
                    if (answer_line.equals(s[right_answer]))
                        j=10;
                }
            }
        }
        System.out.println(answer_line);
        System.out.println(answer_line.equals(s[right_answer]) ? "You guessed the word!\nYou survived!" : "You lost!");
        if (answer_line.equals(s[right_answer]))
            Hangman.f_draw(0);
        else
            Hangman.f_draw(8);
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
            rand = random.nextInt(rmax);
            if(rand != 0) break;
        }
        return rand;
    }
}
