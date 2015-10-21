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
}
	
