
/* 
Average Value returns the average value of an array of doubles.  Expected test results
	Average Value
	[0.5, 4.7, 41.2, -15.0]
	7.850000000000001
	
	Average Value
	[17.5, -6.7, 15.0, 0.0, 7.1]
	6.58
 */
import java.util.*;

public class AverageValue implements ProblemIO {

	private double[] inputArray; // array to find average of

	public AverageValue(double[] inputArray) {
		this.inputArray = inputArray;
	}

	/*
	 * This is the method that returns the average of the input array. YOU MUST
	 * IMPLEMENT THIS METHOD
	 */
	public double calculateAverage() {
		double total = 0;
		for (double thisNum : inputArray) {
			total += thisNum;
		}
		return total / inputArray.length;
	}

	@Override
	public String problemInput() {
		return Arrays.toString(this.inputArray);
	}

	@Override
	public String problemOutput() {
		return Double.toString(calculateAverage());
	}

	@Override
	public String problemHeader() {
		return "Average Value";
	}

}
