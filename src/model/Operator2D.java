package model;

/*Source of algorithms: http://web.cse.ohio-state.edu/~whmin/courses/cse3541-2015-spring/04-Transformations.pdf*/

public class Operator2D {
	
	public static void Translate(Matrix original,double tx, double ty) {
		double[][] translatePoints = {{1,0,tx},
									  {0,1,ty},
									  {0,0,1}};
		Matrix translateMatrix = new Matrix(translatePoints);
		original.setDATA(translateMatrix.multiply(original).getDATA());
	}
	
	public static void Rotate(Matrix original,double degrees) {
		double[][] rotatePoints = {{Math.cos(degrees),-Math.sin(degrees),0},
								   {Math.sin(degrees),Math.cos(degrees),0},
								   {0,0,1}};
		Matrix rotateMatrix = new Matrix(rotatePoints);
		original.setDATA(rotateMatrix.multiply(original).getDATA());
	}
	
	public static void Scale(Matrix original,double sx,double sy) {
		double[][] scalePoints = {{sx,0,0},
				   				   {0,sy,0},
				   				   {0,0,1}};
		Matrix scaleMatrix = new Matrix(scalePoints);
		original.setDATA(scaleMatrix.multiply(original).getDATA());
		
	}
	
	public static void ArbitraryRotation(Matrix original, double px, double py, double degrees) {
		Operator2D.Translate(original, -px, -py);
		Operator2D.Rotate(original, degrees);
		Operator2D.Translate(original, px, py);
	}
	
	public static void ArbitraryScale(Matrix original, double px, double py, double sx, double sy) {
		Operator2D.Translate(original, -px, -py);
		Operator2D.Scale(original, sx, sy);
		Operator2D.Translate(original, px, py);
	}
	
	public static void VerticalShear(Matrix original, double g) {
		double[][] shearPoints = {{1,0,0},
								  {g,1,0},
								  {0,0,1}};
		Matrix shearMatrix = new Matrix(shearPoints);
		original.setDATA(shearMatrix.multiply(original).getDATA());
	}
	
	public static void HorizontalShear(Matrix original, double h) {
		double[][] shearPoints = {{1,h,0},
				  				  {0,1,0},
				  				  {0,0,1}};
		Matrix shearMatrix = new Matrix(shearPoints);
		original.setDATA(shearMatrix.multiply(original).getDATA());
	}
}
	
