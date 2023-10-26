package TicTacToe;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = "";
        Tic tic = new Tic();

        while (!(s.length() == 9 && (s.contains("X") || s.contains("O") || s.contains("_")))) {
            System.out.print("Enter cells (like: O_OXXO_XX): ");
            s = scn.nextLine();
        }
        tic.setField(new StringBuilder(s));

        if (tic.getState().equals("Game not finished")) {
            do {
                System.out.print("Enter the coordinates (like: 1 2): ");
                s = scn.nextLine();
                tic.field_change(new StringBuilder(s));
            } while(!tic.is_coord_ok());
        }
        System.out.println( tic.getState() );
    }
}

class Tic{
    final String[] field_coord = {"1 1", "1 2", "1 3", "2 1", "2 2", "2 3", "3 1", "3 2", "3 3"};
    private String state;
    private StringBuilder field = new StringBuilder();
    private char gamer;
    private boolean coord_ok;

    public Tic(){
        this.gamer = 'X';
        this.coord_ok = false;
    }
    public String getState() {
        return state;
    }
    public void setField(StringBuilder field) {
        this.field = field;
        field_print(field);
    }

    public void field_change(StringBuilder xy){
        int x, y, index;

        coord_ok = false;
        if (Arrays.toString(field_coord).contains(xy)){
            x = Integer.parseInt(xy.substring(0, 1));
            y = Integer.parseInt(xy.substring(2, 3));
            index = 3 * (x - 1) + y - 1;

            if (field.charAt(index) == '_') {
                field.setCharAt(index, gamer);
                coord_ok = true;
                gamer = gamer == 'X' ? 'O' : 'X';
                field_print(field);
            }
            else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
        else {
            System.out.println("You  should  enter  numbers from 1 to 3! ");
        }
    }
    private void field_print(StringBuilder s) {
        StringBuilder s_print = new StringBuilder();

        for (int i = 0; i<9; i++) {
            s_print.append(s.charAt(i)).append(" ");
        }

        System.out.println("---------\n| " +
                s_print.substring(0,5) + " |\n| "+
                s_print.substring(6,11) + " |\n| "+
                s_print.substring(12,17) + " |\n"+
                "---------" );
        f_state(s.toString());
    }
    private String f_state(String s){
        if ( Math.abs((f_count_xo(s,'X') - f_count_xo(s,'O') )) > 1 ) state="Impossible";
        else if (is_xo_win(s,'X') && is_xo_win(s,'O')) state = "Impossible";
        else if (is_xo_win(s,'X'))   state = "X wins";
        else if (is_xo_win(s,'O'))   state = "O wins";
        else if (s.contains("_"))  state = "Game not finished";
        else state = "Draw";
        return state;
    }
    private int f_count_xo(String s, char c){
        char [] sc;
        sc = s.toCharArray();
        int count=0;

        for (char ch : sc ){
            if (ch==c) count++;
        }
        return count;
    }
    public boolean is_coord_ok(){
        return coord_ok;
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
           (sc[0]==xo && sc [4]==xo && sc[8]==xo) ) {
            return true;
        }
        return false;
    }
}
