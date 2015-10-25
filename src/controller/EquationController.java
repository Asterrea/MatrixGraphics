package controller;

import java.util.ArrayList;
import java.util.List;

import model.Matrix;

public class EquationController {
	
	private String type;
	private double magnitude;
	private double hDistance;
	private double vDistance;
	private List<double[][]> dataPoints;
	private String orientation;
	private List<double[][]> transformedPoints;
	
	public EquationController(){
		dataPoints = new ArrayList<double[][]>();
		transformedPoints = new ArrayList<double[][]>();
	}

	public void getValues(){
		System.out.println(type);
		System.out.println(magnitude);
		System.out.println(hDistance);
		System.out.println(vDistance);
		System.out.println(orientation);

		for(int i = 0 ; i < dataPoints.size() ; i++){
			Matrix matrix = new Matrix(dataPoints.get(i));
			matrix.printMatrix();
			System.out.println();
		}
		
		translate(4, -3);
	}
	
	public void translate(double x, double y){

		double[][] trans_point = {{1,0,x},{0,1,y},{0,0,1}};
		Matrix trans = new Matrix(trans_point);
		Matrix result;
		
		for(int i = 0 ; i < dataPoints.size() ; i++){
			Matrix matrix = new Matrix(dataPoints.get(i));
			
			System.out.println("Original Matrix: "); 
				matrix.printMatrix();
				System.out.println();
				
			System.out.println("Translated Matrix: ");
			result = trans.multiply(matrix); 
			
			result.printMatrix();
			System.out.println();
		}
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
	
	public List<double[][]> getDataPoints() {
		return dataPoints;
	}

	public void setDataPoints(List<double[][]> dataPoints) {
		this.dataPoints = dataPoints;
	}
	
	public void addDataPoints(double[][] dataPoints){
		this.dataPoints.add(dataPoints);
	}
	
	public List<double[][]> getTransformedPoints() {
		return transformedPoints;
	}

	public void setTransformedPoints(List<double[][]> transformedPoints) {
		this.transformedPoints = transformedPoints;
	}
	
	public void addTransformedPoints(double[][] transformedPoints){
		this.transformedPoints.add(transformedPoints);
	}
	
	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
}
