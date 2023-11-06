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
        System.out.println("The result is:");
    for(int i = 0; i < this.n; i++)
        {
            for(int j = 0; j < this.m; j++)
            {
                System.out.print(this.mainMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static Matrix multyСonst(Matrix m, int num){
        int hor, ver;
        hor = m.getCountRows();
        ver = m.getCountColumns();

        for(int i = 0; i < hor; i++){
            for(int j = 0; j < ver; j++)           {
                m.setElement(i, j, m.getElement(i, j) * num);
            }
        }

        return m;
    }

    public static Matrix add(Matrix first, Matrix second){
        //Action action = Action.ADD;
        int hor, ver;

        if(!IsSizeMatrixOk(Action.ADD, first, second))
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
    public static Matrix multiply (Matrix first, Matrix second) {
        //Action action = Action.MULTI;
        //if(first.getCountRows() != second.getCountColumns())
        if(!IsSizeMatrixOk(Action.MULTI, first, second))
            return null;
        else {
            Matrix tmpMatrix;
            int n = first.getCountColumns();
            int m = second.getCountRows();
            int o = second.getCountColumns();
            int[][] tmpArr = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    for (int k = 0; k < o; k++) {
                        tmpArr[i][j] += first.getElement(i, k) * second.getElement(k, j);
                    }
                }
            }
            tmpMatrix = new Matrix(tmpArr);
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
            case MULTI-> {
                if (first.getCountRows() != second.getCountColumns()) {
                    System.out.println("ERROR: NotEqualLengthsOfMatrix");
                    rez = false;
                    break;
                }
            }
        }
        return rez;
    }

}
