package model;

final public class Matrix {
    private int ROWS;             
    private int COLS;            
    private double[][] DATA;   

    // create by ROWS COLS (Empty Matrix)
    public Matrix(int ROWS, int COLS) {
        this.ROWS = ROWS;
        this.COLS = COLS;
        DATA = new double[ROWS][COLS];
    }

    // create matrix by 2D ARRAY (Data Matrix)
    public Matrix(double[][] DATA) {
        ROWS = DATA.length;
        COLS = DATA[0].length;
        this.DATA = new double[ROWS][COLS];
        
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                    this.DATA[i][j] = DATA[i][j];
    }
    
    // create and return the COLS-by-COLS identity matrix
    public static Matrix identity(int COLS) {
        Matrix I = new Matrix(COLS, COLS);
        for (int i = 0; i < COLS; i++)
            I.DATA[i][i] = 1;
        return I;
    }

    // swap rows i and j
    private void swap(int ROWS, int COLS) {
        double[] temp = DATA[ROWS];
        DATA[ROWS] = DATA[COLS];
        DATA[COLS] = temp;
    }

    // create and return the transpose of the invoking matrix
    public Matrix transpose() {
        Matrix A = new Matrix(COLS, ROWS);
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                A.DATA[j][i] = this.DATA[i][j];
        return A;
    }

    // return C = A + B
    public Matrix addition(Matrix B) {
        Matrix A = this;
        if (B.ROWS != A.ROWS || B.COLS != A.COLS) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(ROWS, COLS);
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                C.DATA[i][j] = A.DATA[i][j] + B.DATA[i][j];
        return C;
    }


    // Subtract Matrices
    public Matrix subtract(Matrix B) {
        Matrix A = this;
        if (B.ROWS != A.ROWS || B.COLS != A.COLS) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(ROWS, COLS);
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                C.DATA[i][j] = A.DATA[i][j] - B.DATA[i][j];
        return C;
    }

    // Check if Matrix is Equal
    public boolean eq(Matrix B) {
        Matrix A = this;
        if (B.ROWS != A.ROWS || B.COLS != A.COLS) throw new RuntimeException("Illegal matrix dimensions.");
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                if (A.DATA[i][j] != B.DATA[i][j]) return false;
        return true;
    }

    //Multiply Matrices
    public Matrix multiply(Matrix B) {
        Matrix A = this;
        if (A.COLS != B.ROWS) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.ROWS, B.COLS);
        for (int i = 0; i < C.ROWS; i++)
            for (int j = 0; j < C.COLS; j++)
                for (int k = 0; k < A.COLS; k++)
                    C.DATA[i][j] += (A.DATA[i][k] * B.DATA[k][j]);
        return C;
    }
    
    // print matrix
    public void printMatrix() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) 
                System.out.printf("%9.2f ", DATA[i][j]);
            System.out.println();
        }
    }
    
    // test 
    public static void main(String[] args) {
        double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
        double[][] e = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1} };
        
        System.out.println("Matrix D");
        Matrix D = new Matrix(d);
        D.printMatrix();        

        System.out.println("Matrix A");
        Matrix A = new Matrix(e);
        A.printMatrix(); 

        System.out.println("Matrix A : SWAP");
        A.swap(1, 2);
        A.printMatrix();

        System.out.println("TRANSPOSE A STORE NEW MATRIX B");
        Matrix B = A.transpose();
        B.printMatrix(); 

        System.out.println("NEW IDENTITY MATRIX");
        Matrix C = Matrix.identity(3);
        C.printMatrix(); 

        System.out.println("SUM");
        A.addition(B).printMatrix();

        System.out.println("MULTIPLY");
        B.multiply(A).printMatrix();
        
        
    }
}