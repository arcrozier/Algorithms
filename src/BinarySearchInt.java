import java.util.*;

/* 
 Binary Search Int takes a target number and an increasing array of int
 It returns the index of an occurrence of target if the target is in the increasing array.
 Otherwise, it returns the negative of one more than the last index tested.  
 You may not use the Arrays.binarySearch() method to solve this problem.  Test Results:
 
 Integer Binary Search
7
[-5, -3, -1, 1, 3, 3, 5, 7, 9, 11, 13]
7

Integer Binary Search
-8
[-5, -3, -1, 1, 3, 3, 5, 7, 9, 11, 13]
-1

Integer Binary Search
2
[-5, -3, -1, 1, 3, 3, 5, 7, 9, 11, 13]
-5

Integer Binary Search
17
[-5, -3, -1, 1, 3, 3, 5, 7, 9, 11, 13]
-11
 */
public class BinarySearchInt implements ProblemIO {

	private int[] inputArray; // array to search for target number in;
	private int targetNumber; // number to search for

	public BinarySearchInt(int targetNumber, int[] inputArray) {
		this.targetNumber = targetNumber;
		this.inputArray = inputArray;
	}

	/*
	 * binarySearch returns the index of the target number in the array if it
	 * exists. If it doesn't it returns the negative of the last index tested
	 * plus 1. YOU MUST IMPLEMENT THIS METHOD
	 */
	public int binarySearch() {
		int index = inputArray.length - 1;
		int[] indices = { 0, index };
		while (inputArray[index] != targetNumber && indices[1] - indices[0] > 1) {
			if (inputArray[index] > targetNumber) {
				int tempIndex = (index + indices[0]) / 2;
				indices[1] = index;
				index = tempIndex;

			}
			if (inputArray[index] < targetNumber) {
				int tempIndex = index >= inputArray.length ? inputArray.length - 1
						: (int) (index = (index + indices[1]) / 2);
				indices[0] = index;
				index = tempIndex;
			}
		}
		if (indices[1] - indices[0] <= 1) {
			return (index + 1) * -1;
		} else {
			return index;
		}
	}

	@Override
	public String problemHeader() {
		return "Integer Binary Search";
	}

	@Override
	public String problemInput() {
		return targetNumber + "\n" + Arrays.toString(inputArray);
	}

	@Override
	public String problemOutput() {
		return Integer.toString(binarySearch());
	}

}
