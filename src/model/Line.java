package model;

public class Line {
	private Vector[] points;
	
	public Line() {
		points = new Vector[2];
	}
	
	public Line(Vector[] points) {
		if(points.length == 2) {
			this.points = points;
		}
	}
	
	public Vector[] getPoints() {
		return points;
	}

	public void setPoints(Vector[] points) {
		this.points = points;
	}
	
	
}
