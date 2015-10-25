package controller;

public class EquationController {
	
	private String type;
	private double magnitude;
	private double hDistance;
	private double vDistance;
	private double[][] dataPoints;
	private String orientation;
	
	public void getValues(){
		System.out.println(type);
		System.out.println(magnitude);
		System.out.println(hDistance);
		System.out.println(vDistance);
		System.out.println(orientation);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}

	public double gethDistance() {
		return hDistance;
	}

	public void sethDistance(double hDistance) {
		this.hDistance = hDistance;
	}

	public double getvDistance() {
		return vDistance;
	}

	public void setvDistance(double vDistance) {
		this.vDistance = vDistance;
	}

	public double[][] getDataPoints() {
		return dataPoints;
	}

	public void setDataPoints(double[][] dataPoints) {
		this.dataPoints = dataPoints;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
}
