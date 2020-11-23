
/*
 Is Increasing Integer Array takes an array of integers and returns true if each element is greater
 than or equal to the previous element, false otherwise.   Test results:
 
 Is Increasing Integer Array
[-5, -2, 3, 7, 11]
true

Is Increasing Integer Array
[-5, -2, -2, 5, 7]
true

Is Increasing Integer Array
[-5, -2, 7, 3, 11]
false

 */
import java.util.*;

public class IsIncreasingIntegerArray implements ProblemIO {
	private int[] inputArray; // array to test

	public IsIncreasingIntegerArray(int[] inputArray) {
		this.inputArray = inputArray;
	}

	/*
	 * IsIncreasing() returns true if numbers in array are all greater than the
	 * previous one; false otherwise. YOU MUST IMPLEMENT THIS METHODS
	 */
	public boolean isIncreasing() {
		int lastInt = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] < lastInt)
				return false;
			lastInt = inputArray[i];
		}
		return true;
	}

	@Override
	public String problemHeader() {
		return "Is Increasing Integer Array";
	}

	@Override
	public String problemInput() {
		return Arrays.toString(inputArray);
	}

	@Override
	public String problemOutput() {
		return Boolean.toString(isIncreasing());
	}

}
