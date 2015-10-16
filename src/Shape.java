
public class Shape {
	private Vector[] points;
	
	public Shape() {
		setPoints(new Vector[3]);
	}
	
	public Shape(Vector[] points) {
		if(points.length >= 3) {
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
