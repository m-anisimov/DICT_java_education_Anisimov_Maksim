package TicTacToe;
import java.util.Scanner;
import java.math.*;

public class TicTacToe {
    public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = "";
        Tic tic = new Tic();
        System.out.println("Let's play!\nX O X\nO X O\nX X O");

        while (!(s.length()==9 && (s.contains("X") || s.contains("O") || s.contains("_") ) )){
            System.out.println("\nEnter 9 chars like: O_OXXO_XX:\n");
            s=scn.nextLine();
        }
        tic.field_print(s);

    }
 }

class Tic{
    private String hod;
    private String state;
    public Tic(){
        this.hod = hod;
    }
    public String getState() {
        return state;
    }
    public void field_print(String s) {
        String s_field;
        char [] sc;
        sc = s.toCharArray();
        s_field = "";

        System.out.println(s);
        for (int i = 0; i<9; i++) {
            s_field += sc[i]  + " ";
        }
        System.out.println(s_field);
        System.out.println("---------\n| " +
                s_field.substring(0,5) + " |\n| "+
                s_field.substring(6,11) + " |\n| "+
                s_field.substring(12,17) + " |\n"+
                "---------" );

        System.out.println(f_state(s));
    }
    private String f_state(String s){
        String rez="";
        if ( Math.abs((f_count_xo(s,'X') - f_count_xo(s,'O') )) > 1 ) rez="Impossible";
        else if (is_xo_win(s,'X') && is_xo_win(s,'O')) rez = "Impossible";
        else if (is_xo_win(s,'X'))   rez = "X wins";
        else if (is_xo_win(s,'O'))   rez = "O wins";
        else if (s.contains("_"))  rez = "Game not finished";
        else rez = "Draw";

        return rez;
    }
    private int f_count_xo(String s, char c){
        char [] sc;
        sc = s.toCharArray();
        int count=0;

        for (char ch :sc ) {
            if (ch==c) count++;
        }

        return count;
    }
    private boolean is_xo_win(String s, char xo){
        char [] sc;
        sc = s.toCharArray();

        if((sc[0]==xo && sc [1]==xo && sc[2]==xo) ||
           (sc[3]==xo && sc [4]==xo && sc[5]==xo) ||
           (sc[6]==xo && sc [7]==xo && sc[8]==xo) ||
           (sc[0]==xo && sc [3]==xo && sc[6]==xo) ||
           (sc[1]==xo && sc [4]==xo && sc[7]==xo) ||
           (sc[2]==xo && sc [5]==xo && sc[8]==xo) ||
           (sc[2]==xo && sc [4]==xo && sc[6]==xo) ||
           (sc[0]==xo && sc [4]==xo && sc[8]==xo) )
                return true;

        return false;
    }
}
