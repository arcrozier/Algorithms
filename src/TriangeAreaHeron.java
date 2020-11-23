/*
Triangle Area Heron takes the length of three sides of a triangle and uses Heron's formula to calculate 
the area.  If any of the lengths are 0 of negative or if the three sides would not make a valid triangle
0.0 should be returned.   Herons formula is the area of triangle is:
 
    square root of (s * (s - side1) * (s - side2) * (s - side3)) where s = (side1 + side2 + side3)/2
    
Test results:

Triangle Area Using Heron's Formula
4.5 7.3 9.1
16.260683219040946

Triangle Area Using Heron's Formula
5.8 12.7 6.1
0.0

Triangle Area Using Heron's Formula
5.8 12.7 6.1
0.0
       
*/

public class TriangeAreaHeron implements ProblemIO {
	private double side1; // triangle side parameter 1
	private double side2; // triangle side parameter 2
	private double side3; // triangle side parameter 3

	public TriangeAreaHeron(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	/*
	 * calculateHeronArea() returns the area of triangle based on the 3 sides
	 * YOU MUST IMPLEMENT THIS METHOD
	 */
	public double calculateHeronArea() {
		if (side1 <= 0 || side2 <= 0 || side3 <= 0)
			return 0.0;
		if (side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side1 + side2)
			return 0.0;
		double s = (side1 + side2 + side3) / 2;
		return Math.sqrt((s * (s - side1) * (s - side2) * (s - side3)));
	}

	@Override
	public String problemHeader() {
		return "Triangle Area Using Heron's Formula";
	}

	@Override
	public String problemInput() {
		return side1 + " " + side2 + " " + side3;
	}

	@Override
	public String problemOutput() {
		return Double.toString(calculateHeronArea());
	}

}
