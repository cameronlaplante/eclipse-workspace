package secondLab;

public class CircleTester {

	public static void main(String[] args) {
		//Create two circles and set their values. 
		Circle circle1 = new Circle();
		Circle circle2 = new Circle();
		//circle one values
		circle1.setX(0.0);
		circle1.setY(0.0);
		circle1.setRadius(2);
		//circle two values
		circle2.setX(2.0);
		circle2.setY(1.0);
		circle2.setRadius(1);
		//print initial values of both circles. 
		System.out.println("circle1- " + circle1 + "\n");
		System.out.println("circle2- " + circle2 + "\n");
		
		// If the method setRadius is implemented correctly,
		// a call to setRadius with a negative number
		// will not change the value of the circle's radius.
		circle1.setRadius(-2.0);
		
		// set the circle2 radius. 5.3
		circle2.setRadius(5.3);
		
		// Reset the center of circle1. (-3.0,4.0)
		circle1.setX(-3.0);
		circle1.setY(-4.0);
		
		//FOR TESTING: Reset the center of circle2. (-3.0,4.0)
		//circle2.setX(-3.0);
		//circle2.setY(-4.0);
		
		// print circle1 characteristics (center and radius)
		System.out.println("circle1 Altered - " + circle1 + "\n");
		
		// print circle2 characteristics (center and radius)
		System.out.println("circle2 Altered - " + circle2 + "\n");
		
		// print circle1 diameter, area and perimeter
		System.out.println("Calculations of circle1 - " + "\ndiameter: " + circle1.diameter() +
		"\narea:" + String.format("%.2f",circle1.area()) + "\nperimeter:" + 
		String.format("%.2f",circle1.perimeter())+"\n");
		
		// print circle2 diameter, area and perimeter
		System.out.println("Calculations of circle2 - " + "\ndiameter: " + circle2.diameter() +
		"\narea:" + String.format("%.2f",circle2.area()) + "\nperimeter:" + 
		String.format("%.2f",circle2.perimeter())+"\n");
		
		// display whether circle1 is a unit circle
		System.out.println("Circle1 is a unit circle - " + circle1.isUnitCircle());
		
		// display whether circle2 is a unit circle
		System.out.println("Circle2 is a unit circle - " + circle2.isUnitCircle());
		
		// ADDITIONAL TESTS:
		//display whether circles are the same
		System.out.println("Circles are Identitcal - " + circle1.equals(circle2));
		
		//display whether circles are concentric
		System.out.println("Circles are concentric - " + circle1.isConcentric(circle2));
		
		//display whether circles intersect. 
		System.out.println("Circles intersect - " + circle1.intersects(circle2));
		
		//display distance between centers
		System.out.println("Distance between the centers: " + 
		String.format("%.2f",circle1.distance(circle2)));
	}
}