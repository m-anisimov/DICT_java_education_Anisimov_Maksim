package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        int age, remainder3, remainder5, remainder7, userInp;
        Scanner scn = new Scanner(System.in);

        System.out.println("Hello! My name is MyBot.");
        System.out.println("I was created in 2023.");
        System.out.println("Please, remind me your name.");
        String UserName = scn.nextLine();
        System.out.println("What a great name you have, " + UserName + "!");
        System.out.println("Let me guess your age.\n" +
                "Enter remainders of dividing your age by 3, 5 and 7.");

        remainder3 = scn.nextInt();
        remainder5 = scn.nextInt();
        remainder7 = scn.nextInt();
        age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
        System.out.println("Now I will prove to you that I can count to any number you want!");
        userInp = scn.nextInt();
        for (int i=0;i<=userInp;i++){
            System.out.println(i+" !");
        }
    }
}
