package controller;
import model.*;

public class MatrixGraphicsController {
	
	/*private main View variable here */
	
	private Object2D userObject;
	private Object2D tentativeChange; 
	//since the specification requires to show a before and after changes
	
	/*private void UpdateView*/
	
	/* 
	  	private void Translate(Vector offset) {
	 		this.tentativeChange.setPoints(userObject.getPoints());
	 		Operator2D.Translate(this.tentativeChange,offset);
	 		this.UpdateView();
	 	} 
	 */
	
	/* 
		private void Rotate(double degrees) {
			this.tentativeChange.setPoints(userObject.getPoints());
			Operator2D.Rotate(this.tentativeChange,degrees);
			this.UpdateView();
		}
	*/
	
	/*
	  	private void Scale(Vector scaling) {
	  		this.tentativeChange.setPoints(userObject.getPoints());
	  		Operator2D.Scale(this.tentativeChange,scaling);
	  		this.UpdateView();
	  	}
	  	
	  	Note: this can be used for reflection across quadrants.
	  	1st Quadrant: (1,1)
	  	2nd Quadrant: (-1,1);
	  	3rd Quadrant: (-1,-1);
	  	4th Quadrant: (1,-1);
	*/
	
	/*
		private void ArbitraryRotation(Vector point, double degrees) {
			this.tentativeChange.setPoints(userObject.getPoints());
			Operator2D.ArbitraryRotation(this.tentativeChange,point,degrees);
			this.UpdateView();
		}
	*/
	
	/*
		private void ArbitraryScale(Vector point,Vector scaling) {
			this.tentativeChange.setPoints(userObject.getPoints());
			Operator2D.ArbitraryScale(this.tentativeChange,point,scaling);
			this.UpdateView();
		}
	*/
	
	/*
	  	private void VerticalShear(double offset) {
	  		this.tentativeChange.setPoints(userObject.getPoints());
	  		Operator2D.VerticalShear(this.tentativeChange,offset);
	  		this.UpdateView();
	  	}
	 */
	
	/*
	  	private void HorizontalShear(double offset) {
	  		this.tentativeChange.setPoints(userObject.getPoints());
	  		Operator2D.HorizontalShear(this.tentativeChange,offset);
	  		this.UpdateView();
	  	}
	*/
}
