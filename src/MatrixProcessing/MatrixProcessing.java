package MatrixProcessing;

import java.util.Scanner;
public class MatrixProcessing {
    public static void main(String[] args) {
        State state = new State();

        while (!state.getState().equals("exit")) {
            state.setUser_choice( state.getMenuChoice( ) );
            state.getState();
        }
        System.out.println("Bye!..");
    }
}
class State {
    public static int count_row, count_col;
    public static Scanner scn = new Scanner(System.in);
    public static StringBuilder user_str = new StringBuilder();
    private String user_choice;
    private String state;
    private final String[] menu_action = {"1. Add matrices", "2. Multiply matrix by a constant",
            "3. Multiply matrices", "0. Exit"};

    //private Resources remaining = new Resources(400, 540, 120, 9, 550);

    public State() {
        this.state = "action";
    }

    public String getState() {
        return state;
    }

    public void setUser_choice(String user_choice) {
        this.user_choice = user_choice;
        f_analysis(user_choice.charAt(0));
    }
    public String getMenuChoice (){
        System.out.println("Please select:");
        for (String s: menu_action ) {
            System.out.println("    " + s );
        }
        return scn.nextLine();
    }

    private void f_analysis(char choice) {

        if (state.equals("action")) {
            switch (choice) {
                case '1' -> { f_add_multi(Matrix.Action.ADD);}
                case '2' -> f_multiconst();
                case '3' -> { f_add_multi(Matrix.Action.MULTI);}
               // case "4" -> state = "exit" //remaining.remaining_print();
                case '0' -> state = "exit";
                default -> state = "exit";
            }
        } else  {
            state = "action";
        }

    }
    private void f_multiconst(){
        user_str.delete(0,user_str.length());

        System.out.println("Enter size of the matrix:");
        user_str.append(scn.nextLine());
        if( !IsCorrectInput(2,user_str)) {
            return;// continue;
        }
        Matrix matrix = new Matrix(count_row, count_col);
        matrix.UserMatrixInput("");

        user_str.delete(0,user_str.length());
        System.out.println("Enter multiplier:");
        user_str.append(scn.nextLine());

        Matrix matrix_rez = Matrix.multyСonst (matrix, Integer.parseInt(user_str.substring( 0, user_str.length())));
        if (matrix_rez!=null) {
            matrix_rez.printMatrix();
        }
    }
    private void f_add_multi (Matrix.Action atype){

        user_str.delete(0,user_str.length());

        System.out.println("Enter size of first matrix:");
        user_str.append(scn.nextLine());
        if( !IsCorrectInput(2,user_str)) {
            return;// continue;
        }
        Matrix matrix1 = new Matrix(count_row, count_col);
        matrix1.UserMatrixInput("first");

        user_str.delete(0,user_str.length());
        System.out.println("Enter size of second matrix:");
        user_str.append(scn.nextLine());
        if( !IsCorrectInput(2,user_str)) {
            return;// continue;
        }
        Matrix matrix2 = new Matrix(count_row, count_col);
        matrix2.UserMatrixInput("second");

        Matrix matrix_rez = null;
        switch (atype) {
            case ADD   -> matrix_rez = Matrix.add(matrix1, matrix2);
            case MULTI -> matrix_rez = Matrix.multiply(matrix1, matrix2);
        }

        if (matrix_rez != null) {
            matrix_rez.printMatrix();
        }
    }

    public boolean IsCorrectInput (int count, StringBuilder s){
        int pos_space = 0;
        try {
            pos_space = s.indexOf(" ");
            count_row = Integer.parseInt(s.substring(0,pos_space));
            count_col = Integer.parseInt(s.substring(pos_space + 1, s.length()));
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}