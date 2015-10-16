package model;

//2D Matrix
public class Matrix {
	private int rows;
	private int cols;
	private double [][] data;
	
	public Matrix(double[][] dat){
		this.data = dat;
		this.rows = dat.length;
		this.cols = dat[0].length;
	}
	
	public Matrix(int row, int col){
		this.rows = row;
		this.cols = col;
		data = new double[row][col];
	}

//	public static Matrix transpose(Matrix matrix){
//		Matrix transposedMatrix = new Matrix(matrix.getRows(), matrix.getCols());
//		for(int i=0; i<matrix.getRows(); i++){
//			for(int j=0; j<matrix.getCols(); j++){
//				//swap rows and columns
//			}
//		}
//		return transposedMatrix;
//	}
	
//	public static Matrix cofactor(Matrix matrix){
//		Matrix mat = new Matrix(matrix.getRows(), matrix.getCols());
//		for(int i=0; i<matrix.getRows(); i++){
//			for(int j=0; j<matrix.getCols(); j++){
//				//	
//			}
//		}
//	}
//
//	// throws NoSquareException
//	public static Matrix inverse(Matrix matrix){
//		return (transpose(cofactor(matrix)).multiplyByConstant(1.0/determinant(matrix)));
//	}
//	public int getRows() {
//		return rows;
//	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public double[][] getData() {
		return data;
	}

	public void setData(double[][] data) {
		this.data = data;
	}
	

}
