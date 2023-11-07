package MatrixProcessing;

import java.util.Scanner;

public class Matrix {
    private int n, m;
    //private int[][] mainMatrix;
    private double[][] mainMatrix;
    enum Action {ADD, MULTI, CONST, TRANS}
    public Scanner scn = new Scanner(System.in);
    public Matrix(int n, int m)
    {
        this.n = n;
        this.m = m;
        //this.mainMatrix = new int[this.n][this.m];
        this.mainMatrix = new double[this.n][this.m];
    }
    public Matrix(double [][] paramMatrix)
    //public Matrix(int [][] paramMatrix)
    {
        this.n = paramMatrix.length;
        this.m = paramMatrix[0].length;
        this.mainMatrix = paramMatrix;
    }
    public double getElement(int n, int m)
    //public int getElement(int n, int m)
    {
        return this.mainMatrix[n][m];
    }
    public void setElement(int n, int m, double value)
    //public void setElement(int n, int m, int value)
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
            if (column < this.mainMatrix[0].length) {
                if (pos_space > 0) {
                    //this.mainMatrix[row][column] = Integer.parseInt(s.substring(0,pos_space));
                    this.mainMatrix[row][column] = Double.parseDouble(s.substring(0, pos_space));
                    s.delete(0, pos_space + 1);
                } else {
                    //this.mainMatrix[row][column] = Integer.parseInt(s.substring(0,s.length()));
                    this.mainMatrix[row][column] = Double.parseDouble(s.substring(0, s.length()));
                    s.delete(0, s.length());
                }
                column++;
            }else
                s.delete(0, s.length());
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
        //printMatrix();
    }
    public void printMatrix()
    {
        double dd;
        System.out.println("The result is:");
        for(int i = 0; i < this.n; i++) {
            for(int j = 0; j < this.m; j++) {
                dd = this.mainMatrix[i][j];
                if (Math.floor(dd) - dd == 0.0 ){
                    System.out.print((int)dd + "\t");
                } else {
                    System.out.print(dd + "\t");
                }
            }
            System.out.println();
        }
    }
    public static Matrix multyСonst(Matrix mx, double num){
        int hor, ver;
        hor = mx.getCountRows();
        ver = mx.getCountColumns();

        for(int i = 0; i < hor; i++) {
            for(int j = 0; j < ver; j++) {
                mx.setElement(i, j, mx.getElement(i, j) * num);
            }
        }

        return mx;
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
            //int[][] tmpArr = new int[n][m];
            double[][] tmpArr = new double[n][m];

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
    public static Matrix transMain(Matrix mx)
    {
        int row = mx.getCountRows();
        int col = mx.getCountColumns();
        Matrix tmpMatrix = new Matrix (row, col);

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                tmpMatrix.setElement(i,j, mx.getElement(j,i));
            }
        }
        return tmpMatrix;
    }
    public static Matrix transSide(Matrix mx)
    {
        int row = mx.getCountRows();
        int col = mx.getCountColumns();
        Matrix tmpMatrix = new Matrix (row, col);

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                tmpMatrix.setElement(col - 1 - j, row - 1 - i,  mx.getElement(i, j));
            }
        }
        return tmpMatrix;
    }
    public static Matrix transVert(Matrix mx)
    {
        int row = mx.getCountRows();
        int col = mx.getCountColumns();
        Matrix tmpMatrix = new Matrix (row, col);

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                tmpMatrix.setElement(i, col - 1 - j, mx.getElement(i, j));
            }
        }
        return tmpMatrix;
    }
    public static Matrix transGori(Matrix mx)
    {
        int row = mx.getCountRows();
        int col = mx.getCountColumns();
        Matrix tmpMatrix = new Matrix (row, col);

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                tmpMatrix.setElement(row - 1 - i, j, mx.getElement(i,j));
            }
        }
        return tmpMatrix;
    }
    public static double det(Matrix A){
        int n = A.getCountRows();
        if(n == 1) return A.getElement(0, 0);
        double ans = 0;
        Matrix B = new Matrix (n-1, n-1);
        int l = 1;

        for(int i = 0; i < n; ++i){

            int x = 0, y = 0;
            for(int j = 1; j < n; ++j){
                for(int k = 0; k < n; ++k){
                    if(i == k) continue;
                    B.setElement(x, y, A.getElement(j, k));
                    ++y;
                    if(y == n - 1){
                        y = 0;
                        ++x;
                    }
                }
            }
            ans += l * A.getElement(0, i) * det(B);
            l *= (-1);
        }
        return ans;
    }
    public static boolean IsSizeMatrixOk ( Action act, Matrix first, Matrix second){
        boolean rez = true;
        switch (act) {
            case ADD ->{
                if (first.getCountRows() != second.getCountRows() ||
                    first.getCountColumns() != second.getCountColumns()) {
                    System.out.println("ERROR: Not Equal Lengths Of Matrix");
                    rez = false;
                }
            }
            case MULTI-> {
                if (first.getCountRows() != second.getCountColumns()) {
                    System.out.println("ERROR: Rows count of 1st Matrix Not Equal Columns count Of 2nd Matrix");
                    rez = false;
                }
            }
            case TRANS-> {
                if (first.getCountRows() != first.getCountColumns()) {
                    System.out.println("ERROR: Matrix is Not Square");
                    rez = false;
                }
            }
        }
        return rez;
    }

}
