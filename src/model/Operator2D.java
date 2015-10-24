package model;

/*Source of algorithms: http://web.cse.ohio-state.edu/~whmin/courses/cse3541-2015-spring/04-Transformations.pdf*/

public class Operator2D {

	public static void Translate(Vector original,Vector offset) {
		original.Add(offset);
	}
	
	public static void Translate(Line original,Vector offset) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].Add(offset);
		}
		original.setPoints(temp);
	}
	
	public static void Translate(Shape original,Vector offset) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].Add(offset);
		}
		original.setPoints(temp);
	}
	
	public static void Rotate(Vector original,double degrees) {
		original.setX((original.getX() * Math.cos(degrees) - (original.getY() * Math.sin(degrees))));
		original.setY((original.getY() * Math.sin(degrees)) + (original.getX() * Math.cos(degrees)));
	}
	
	public static void Rotate(Line original,double degrees) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].setX((temp[i].getX() * Math.cos(degrees) - (temp[i].getY() * Math.sin(degrees))));
			temp[i].setY((temp[i].getY() * Math.sin(degrees)) + (temp[i].getX() * Math.cos(degrees)));
		}
		original.setPoints(temp);
	}
	
	public static void Rotate(Shape original,double degrees) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].setX((temp[i].getX() * Math.cos(degrees) - (temp[i].getY() * Math.sin(degrees))));
			temp[i].setY((temp[i].getY() * Math.sin(degrees)) + (temp[i].getX() * Math.cos(degrees)));
		}
		original.setPoints(temp);
	}
	
	public static void Scale(Vector original,Vector scaling) {
		original.setX(original.getX() * scaling.getX());
		original.setY(original.getY() * scaling.getY());
	}
	
	public static void Scale(Line original,Vector scaling) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].setX(temp[i].getX() * scaling.getX());
			temp[i].setY(temp[i].getY() * scaling.getY());
		}
		original.setPoints(temp);
	
	}
	
	public static void Scale(Shape original,Vector scaling) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].setX(temp[i].getX() * scaling.getX());
			temp[i].setY(temp[i].getY() * scaling.getY());
		}
		original.setPoints(temp);
		
	}
	
	public static void ArbitraryRotation(Vector original, Vector point, double degrees) {
		Vector temp = Vector.Multiply(point, -1);
		Operator2D.Translate(original, temp);
		Operator2D.Rotate(original, degrees);
		temp.Multiply(1);
		Operator2D.Translate(original, temp);
	}
	
	public static void ArbitraryRotation(Line original, Vector point, double degrees) {
		Vector temp = Vector.Multiply(point, -1);
		Operator2D.Translate(original, temp);
		Operator2D.Rotate(original, degrees);
		temp.Multiply(1);
		Operator2D.Translate(original, temp);
	}
	
	public static void ArbitraryRotation(Shape original, Vector point, double degrees) {
		Vector temp = Vector.Multiply(point, -1);
		Operator2D.Translate(original, temp);
		Operator2D.Rotate(original, degrees);
		temp.Multiply(1);
		Operator2D.Translate(original, temp);
	}
	
	public static void ArbitraryScale(Vector original, Vector point, Vector scaling) {
		Vector temp = Vector.Multiply(point, -1);
		Operator2D.Translate(original, temp);
		Operator2D.Scale(original, scaling);
		temp.Multiply(1);
		Operator2D.Translate(original, temp);
	}
	
	public static void ArbitraryScale(Line original, Vector point, Vector scaling) {
		Vector temp = Vector.Multiply(point, -1);
		Operator2D.Translate(original, temp);
		Operator2D.Scale(original, scaling);
		temp.Multiply(1);
		Operator2D.Translate(original, temp);
	}
	
	public static void ArbitraryScale(Shape original, Vector point, Vector scaling) {
		Vector temp = Vector.Multiply(point, -1);
		Operator2D.Translate(original, temp);
		Operator2D.Scale(original, scaling);
		temp.Multiply(1);
		Operator2D.Translate(original, temp);
	}
	
	public static void VerticalShear(Vector original, double offset) {
		original.Add(new Vector(original.getY() * offset,0));
	}
	
	public static void VerticalShear(Line original, double offset) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].Add(new Vector(temp[i].getY() * offset,0));
		}
		original.setPoints(temp);
	}
	
	public static void VerticalShear(Shape original, double offset) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].Add(new Vector(temp[i].getY() * offset,0));
		}
		original.setPoints(temp);
	}
	
	public static void HorizontalShear(Vector original, double offset) {
		original.Add(new Vector(0,original.getX() * offset));
	}
	
	public static void HorizontalShear(Line original, double offset) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].Add(new Vector(0,temp[i].getX() * offset));
		}
		original.setPoints(temp);
	
	}
	
	public static void HorizontalShear(Shape original, double offset) {
		Vector[] temp = original.getPoints();
		for(int i = 0; i < temp.length; i++) {
			temp[i].Add(new Vector(0,temp[i].getX() * offset));
		}
		original.setPoints(temp);
	}
}
	
