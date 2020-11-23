
/*  
 Range Value takes an array of double and returns the range (max - min) of the values
 in the array.  Test results:
 
	Range of Values
	[0.5, 4.7, 41.2, -15.0]
	56.2
	
	Range of Values
	[17.5, -6.7, 15.0, 0.0, 7.1]
	24.2
 */

import java.util.*;

public class RangeValue implements ProblemIO {
	private double[] inputArray; // array of double to find range of

	public RangeValue(double[] inputArray) {
		this.inputArray = inputArray;
	}

	/*
	 * calculateRange() is the method that returns the range (max - min) of the
	 * input array YOU MUST IMPLEMNET THIS METHOD
	 */
	public double calculateRange() {
		double min = inputArray[0];
		double max = inputArray[0];
		for (int i = 0; i < inputArray.length; i++) {
			min = inputArray[i] < min ? inputArray[i] : min;
			max = inputArray[i] > max ? inputArray[i] : max;
		}
		return max - min;
	}

	@Override
	public String problemInput() {
		return Arrays.toString(this.inputArray);
	}

	@Override
	public String problemOutput() {
		return Double.toString(calculateRange());
	}

	@Override
	public String problemHeader() {
		return "Range of Values";
	}

}
