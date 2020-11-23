
/*
Maximum position takes an array of double as an input and returns the index of the maximum
value in the array.  Expected test results:
 
Position of Maximum Value
[0.5, 4.7, 41.2, -15.0]
2

Position of Maximum Value
[17.5, -6.7, 15.0, 0.0, 7.1]
0
*/

import java.util.*;

public class MaximumPosition implements ProblemIO {
	private double[] inputArray; // array to return index of maximum value

	public MaximumPosition(double[] inputArray) {
		this.inputArray = inputArray;
	}

	/*
	 * This is the method that returns the index of the maximum value of the
	 * input array YOU MUST IMPLEMENT THIS METHOD
	 */
	public int calculateMaximumPosition() {
		double[] maxVal = { inputArray[0], 0 };
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] > maxVal[0]) {
				maxVal[0] = inputArray[i];
				maxVal[1] = i;
			}
		}
		return (int) maxVal[1];
	}

	@Override
	public String problemInput() {
		return Arrays.toString(this.inputArray);
	}

	@Override
	public String problemOutput() {
		return Integer.toString(calculateMaximumPosition());
	}

	@Override
	public String problemHeader() {
		return "Position of Maximum Value";
	}
}
