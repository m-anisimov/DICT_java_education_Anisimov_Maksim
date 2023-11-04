package MatrixProcessing;

import java.util.Scanner;
public class MatrixProcessing {
    public static int count_row, count_col;
    public static Scanner scn = new Scanner(System.in);
    public static StringBuilder user_str = new StringBuilder();

    public static void main(String[] args) {

      /*  while (true)*/ {
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

            Matrix matrix_sum = Matrix.add(matrix1, matrix2);
            if (matrix_sum!=null)
                matrix_sum.printMatrix();

        }
    }
    public static boolean IsCorrectInput (int count, StringBuilder s){
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
