package TicTacToe;
import java.util.Scanner;
public class TicTacToe {
 public static void main (String[] args) {
     Scanner scn = new Scanner(System.in);
     String s = "";
     String s_field;
     char [] sc;
     System.out.println("Let's play!\nX O X\nO X O\nX X O");

     while (!(s.length()==9 && (s.contains("X") || s.contains("O") || s.contains("_") ) )){
         System.out.println("\nEnter 9 chars like: O_OXXO_XX:\n");
         s=scn.nextLine();
     }
     System.out.println(s);
     sc = s.toCharArray();
     s_field = "";

     for (int i = 0; i<9; i++) {
         s_field += sc[i]  + " ";
     }
     System.out.println(s_field);
     System.out.println("---------\n| " +
             s_field.substring(0,5) + " |\n| "+
             s_field.substring(6,11) + " |\n| "+
             s_field.substring(12,17) + " |\n"+
              "---------" );
    }
 }
