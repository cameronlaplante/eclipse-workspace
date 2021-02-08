package secondLab;

public class Circle {

	//--------------------------------------
	//Cameron LaPlante 
	//01/22/21
	//Lab 2 - Circle
	//Statement of Academic Honesty
	//--------------------------------------
	
	//declare private double instance radius
	private double Radius;
	//declare private double instance x
	private double X;
	//declare private double instance y 
	private double Y;
	
	//--------------------------------------
	//getX - returns value of x 
	//--------------------------------------
	public double getX(){
		return X;
	}
	
	//--------------------------------------
	//getY - returns the value of y 
	//--------------------------------------
	public double getY(){
		return Y;
	}
	
	//--------------------------------------
	//getRadius - returns the value of radius 
	//--------------------------------------
	public double getRadius(){
		return Radius;
	}
	
	//--------------------------------------
	//setX - assigns a new value to x
	//--------------------------------------
	public void setX(double value){
		X = value;
	}
	
	//--------------------------------------
	//setX - assigns a new value to x
	//--------------------------------------
	public void setY(double value){
		Y = value;
	}
	
	//----------------------------------------------
	// setRadius - assigns a new value to radius
	//----------------------------------------------
	public void setRadius(double value) {
		if(value >= 0) {
			Radius = value;
		}
	}
	
	//--------------------------------------------------------
	// diameter - calculates the diameter of the circle
	//--------------------------------------------------------
	public double diameter() {
		return (Radius * 2);
	}
	
	//--------------------------------------------------------
	// area - returns the area of the circle
	//--------------------------------------------------------
	public double area() {
		return (Math.PI * Radius * Radius);
	}
	
	//--------------------------------------------------------
	// perimeter - returns the perimeter of the circle
	//--------------------------------------------------------
	public double perimeter() {
		return (Math.PI * 2 * Radius);
	}
	
	//--------------------------------------------------------
	// isUnitCircle - return true if the radius of this circle
	//                is 1 and its center is (0,0) and false
	//                otherwise.
	//--------------------------------------------------------
	public boolean isUnitCircle() {
		if (Radius == 1 && X==0 && Y==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//--------------------------------------------------------
	// toString - return a String representation of
	//            this circle in the following format:
	//            center:(x,y)
	//            radius: r
	//--------------------------------------------------------
	public String toString() {
		return "\ncenter: (" + getX() + "," + getY() + ")" + "\nradius: " + getRadius();		
	}
	
	//--------------------------------------------------------
	// equals - return true if the circles are the same. 
	//--------------------------------------------------------
	public boolean equals(Circle anotherCircle) {
		if(this.Radius == anotherCircle.Radius && this.X == anotherCircle.X && this.Y == anotherCircle.Y) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//--------------------------------------------------------
	// isConcentric - returns true when the circles have same 
	// center but aren't the same. 
	//--------------------------------------------------------
	public boolean isConcentric(Circle anotherCircle) {
		if (this.X == anotherCircle.X && this.Y == anotherCircle.Y && this.Radius != anotherCircle.Radius) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//--------------------------------------------------------
	// distance - returns distance between centers of the circles
	//--------------------------------------------------------
	public double distance(Circle anotherCircle) {
		return (Math.sqrt(Math.pow(this.X - anotherCircle.X, 2) + Math.pow(this.Y - anotherCircle.Y, 2)));
	}
	
	//--------------------------------------------------------
	// intersects - returns true when circles have intersecting area.
	//--------------------------------------------------------
	public boolean intersects(Circle anotherCircle) {
		if (this.distance(anotherCircle) < (this.Radius + anotherCircle.Radius)) {
			return true;
		}
		else {
			return false;
		}
	}
}
