package model;

public class Object2D {

	private Vector[] points;
	
	public Object2D(Vector[] points) {
		this.points = points;
	}
	
	public Vector[] getPoints() {
		return this.points;
	}
	
	public void setPoints(Vector[] newPoints) {
		this.points = newPoints;
	}
}
