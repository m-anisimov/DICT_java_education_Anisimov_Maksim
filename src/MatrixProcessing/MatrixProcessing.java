package MatrixProcessing;

import java.util.Scanner;
public class MatrixProcessing {
    public static void main(String[] args) {
        State state = new State();

        while (!state.getState().equals("exit")) {
            state.setUser_choice( state.getMenuChoice( ) );
            state.getState();
            if (state.getState().equals("trans")){
                state.setUser_choice( state.getMenuChoice( ) );
            }
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
            "3. Multiply matrices", "4. Transpose matrix", "5. Calculate a determinant", "0. Exit"};
    private final String[] menu_trans = {"1. Main diagonal","2. Side diagonal",
            "3. Vertical line","4. Horizontal line "};

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
        String[] menu = state.equals("trans") ? menu_trans : menu_action;

        System.out.println("Please select:");
        for (String s: menu ) {
            System.out.println("    " + s );
        }
        System.out.print("Your choice: >");
        return scn.nextLine();
    }

    private void f_analysis(char choice) {

        if (state.equals("action")) {
            switch (choice) {
                case '1' -> f_add_multi(Matrix.Action.ADD);
                case '2' -> f_multiconst(Matrix.Action.CONST);
                case '3' -> f_add_multi(Matrix.Action.MULTI);
                case '4' -> state = "trans";
                case '5' -> f_det();
                case '0' -> state = "exit";
            }
        } else if (state.equals("trans")){
            switch (choice) {
                case '1' -> f_trans(1);
                case '2' -> f_trans(2);
                case '3' -> f_trans(3);
                case '4' -> f_trans(4);
            }
            state = "action";
        }else {
            state = "action";
        }

    }
    private void f_multiconst(Matrix.Action atype){
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

        //Matrix matrix_rez = Matrix.multyСonst (matrix, Integer.parseInt(user_str.substring( 0, user_str.length())));
        Matrix matrix_rez = Matrix.multyСonst (matrix, Double.parseDouble(user_str.substring( 0, user_str.length())));
        if (matrix_rez!=null) {
            matrix_rez.printMatrix();
        }
    }
    private Matrix preambleMatrixInput (String matrixNumber){
        user_str.delete(0,user_str.length());

        System.out.println("Enter size of "+ matrixNumber + " matrix:");
        user_str.append(scn.nextLine());
        if( !IsCorrectInput(2,user_str)) {
            return null;// continue;
        }
        Matrix mx = new Matrix(count_row, count_col);
        mx.UserMatrixInput(matrixNumber);
        return mx;
    }
    private double f_det(){
        double det;
        Matrix mx = preambleMatrixInput("");
        if (mx == null)
            return 0.0;
        det = mx.det(mx);
        System.out.println("The result is:\n" + det);
        return  det;
    }
    private void f_trans(int trans_type){
        Matrix matrix = preambleMatrixInput("");
        if (matrix == null)
            return;

        Matrix matrix_rez = null;
        switch (trans_type) {
            case 1 -> matrix_rez = Matrix.transMain(matrix);
            case 2 -> matrix_rez = Matrix.transSide(matrix);
            case 3 -> matrix_rez = Matrix.transVert(matrix);
            case 4 -> matrix_rez = Matrix.transGori(matrix);
        }

        if (matrix_rez != null) {
            matrix_rez.printMatrix();
        }
    }
    private void f_add_multi(Matrix.Action atype){

        Matrix matrix1 = preambleMatrixInput("first");
        if (matrix1 == null)
            return;

        Matrix matrix2 = preambleMatrixInput("second");
        if (matrix2 == null)
            return;

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
        if (s.length()==0){
            System.out.println("An empty choice is a not good choice!");
            return false;
        }
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