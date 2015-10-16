package model;

public class Vector {
	private double x;
	private double y;
	
	public Vector () {
		this.setX(0);
		this.setY(0);
	}
	
	public Vector (double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void Add(Vector v) {
		this.x += v.getX();
		this.y += v.getY();
	}
	
	public void Substract(Vector v) {
		this.x -= v.getX();
		this.y -= v.getY();
	}
	
	public void Multiply(double n) {
		this.x *= n;
		this.y *= n;
	}
	
	public void Divide(double n) {
		this.x /= n;
		this.y /= n;
	}
	
	public double getMagnitude() {
		return Math.sqrt((this.x * this.x) + (this.y * this.y));
	}
	
	public void Normalize(double max) {
		if(this.getMagnitude() != max) {
			this.Divide(this.getMagnitude());
		}
	}
	
	public static Vector Add(Vector v1, Vector v2) {
		return new Vector(v1.getX() + v2.getX() , v1.getY() + v2.getY());
	}
	
	public static Vector Subtract(Vector v1, Vector v2) {
		return new Vector(v1.getX() + v2.getX() , v1.getY() + v2.getY());
	}
	
	public static Vector Multiply(Vector v, double n) {
		return new Vector(v.getX() * n, v.getY() * n);
	}
	
	public static Vector Divide(Vector v, double n) {
		return new Vector(v.getX() * n, v.getY() * n);
	}
}
