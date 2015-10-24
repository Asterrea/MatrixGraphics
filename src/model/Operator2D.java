package model;

/*Source of algorithms: http://web.cse.ohio-state.edu/~whmin/courses/cse3541-2015-spring/04-Transformations.pdf*/

public class Operator2D {
	
	public static void Translate(Object2D original,Vector offset) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].Add(offset);
		}
		original.setPoints(temp);
	}
	
	public static void Rotate(Object2D original,double degrees) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].setX((temp[i].getX() * Math.cos(degrees) - (temp[i].getY() * Math.sin(degrees))));
			temp[i].setY((temp[i].getY() * Math.sin(degrees)) + (temp[i].getX() * Math.cos(degrees)));
		}
		original.setPoints(temp);
	}
	
	public static void Scale(Object2D original,Vector scaling) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].setX(temp[i].getX() * scaling.getX());
			temp[i].setY(temp[i].getY() * scaling.getY());
		}
		original.setPoints(temp);
		
	}
	
	public static void ArbitraryRotation(Object2D original, Vector point, double degrees) {
		Vector temp = Vector.Multiply(point, -1);
		Operator2D.Translate(original, temp);
		Operator2D.Rotate(original, degrees);
		temp.Multiply(1);
		Operator2D.Translate(original, temp);
	}
	
	public static void ArbitraryScale(Object2D original, Vector point, Vector scaling) {
		Vector temp = Vector.Multiply(point, -1);
		Operator2D.Translate(original, temp);
		Operator2D.Scale(original, scaling);
		temp.Multiply(1);
		Operator2D.Translate(original, temp);
	}
	
	public static void VerticalShear(Object2D original, double offset) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].Add(new Vector(temp[i].getY() * offset,0));
		}
		original.setPoints(temp);
	}
	
	public static void HorizontalShear(Object2D original, double offset) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].Add(new Vector(0,temp[i].getX() * offset));
		}
		original.setPoints(temp);
	}
}
	
