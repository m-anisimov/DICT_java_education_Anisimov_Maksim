package MatrixProcessing;

import java.util.Scanner;

public class Matrix {
    private int n, m;
    private int[][] mainMatrix;
    enum Action {ADD, MULTI}
    public Scanner scn = new Scanner(System.in);
    public Matrix(int n, int m)
    {
        this.n = n;
        this.m = m;
        this.mainMatrix = new int[this.n][this.m];
    }
    public Matrix(int [][] paramMatrix)
    {
        this.n = paramMatrix.length;
        this.m = paramMatrix[0].length;
        this.mainMatrix = paramMatrix;
    }
    public int getElement(int n, int m)
    {
        return this.mainMatrix[n][m];
    }
    public void setElement(int n, int m, int value)
    {
        this.mainMatrix[n][m] = value;
    }
    public int getCountRows()
    {
        return this.mainMatrix.length;
    }
    public int getCountColumns()
    {
        return this.mainMatrix[0].length;
    }
    public void rowAdd(int row, StringBuilder s){
        int pos_space = 0;
        int column = 0;

        while (s.length() > 0){
            pos_space = s.indexOf(" ");
            if (pos_space > 0){
                this.mainMatrix[row][column] = Integer.parseInt(s.substring(0,pos_space));
                s.delete(0,pos_space+1);
            }
            else{
                this.mainMatrix[row][column] = Integer.parseInt(s.substring(0,s.length()));
                s.delete(0,s.length());
            }
            column++;
        }
    }
    public void UserMatrixInput (String matrixNumber){
        StringBuilder s = new StringBuilder();

        System.out.println("Enter " + matrixNumber + " matrix:");

        for (int i = 0; i < this.n; i++) {
            s.delete(0, s.length());
            s.append(scn.nextLine());
            rowAdd(i, s);
        }
        printMatrix();
    }
    public void printMatrix()
    {
        for(int i = 0; i < this.n; i++)
        {
            for(int j = 0; j < this.m; j++)
            {
                System.out.print(this.mainMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static Matrix add(Matrix first, Matrix second){
        Action action = Action.ADD;
        int hor, ver;

        if(!IsSizeMatrixOk(action, first, second))
        {
            return null;
        }
        else {
            hor = first.getCountRows();
            ver = first.getCountColumns();
            Matrix tmpMatrix = new Matrix(hor, ver);

            for (int i = 0; i < hor; i++) {
                for(int j = 0; j < ver; j++){
                    tmpMatrix.setElement(i, j, first.getElement(i, j) + second.getElement(i, j));
                }
            }
            return tmpMatrix;
        }
    }
    public static boolean IsSizeMatrixOk ( Action act, Matrix first, Matrix second){
        boolean rez = true;
        switch (act) {
            case ADD ->{
                if (first.getCountRows() != second.getCountRows() ||
                    first.getCountColumns() != second.getCountColumns()) {
                    System.out.println("ERROR: NotEqualLengthsOfMatrix");
                    rez = false;
                }; break;
            }
            case MULTI->{

                break;
            }
        }
        return rez;
    }

}
