
/* 
 To 2D Array takes a one dimensional array of integers and a row and column parameters and returns a two
 dimensional row by col array with values filled in by the one-dimensional array.   If there are not
 enough values in the one dimensional array, then remaining entries in two dimensional array = 0.  If 
 too many entries in the one dimensional array, then only the entries that can fit in the two dimensional 
 array will be placed.   Test results:
 
1D Array to 2D Array
[1, 2, 3, 4, 5, 6]
[[1, 2], [3, 4], [5, 6]]

1D Array to 2D Array
[1, 2, 3, 4, 5, 6, 7]
[[1, 2, 3], [4, 5, 6], [7, 0, 0], [0, 0, 0]]

1D Array to 2D Array
[1, 2, 3, 4, 5, 6, 7]
[[1, 2, 3], [4, 5, 6]]
 
 */
import java.util.*;

public class To2DArray implements ProblemIO {
	private int[] inputArray; // the one dimensional array to fill the 2D array
	private int rows; // number of rows in 2D array
	private int cols; // number of cols in 2D array

	public To2DArray(int[] inputArray, int rows, int cols) {
		this.inputArray = inputArray;
		this.rows = rows;
		this.cols = cols;
	}

	/*
	 * calc2DArray() returns a row, col 2D array with elements from the one
	 * dimensional array YOU MUST IMPLEMENT THIS METHOD
	 */
	public int[][] calc2DArray() {
		int index = 0;
		int[][] array2D = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				array2D[i][j] = index >= inputArray.length ? 0 : inputArray[index];
				index++;
			}
		}
		return array2D;
	}

	@Override
	public String problemHeader() {
		return "1D Array to 2D Array";
	}

	@Override
	public String problemInput() {
		return Arrays.toString(inputArray);
	}

	@Override
	public String problemOutput() {
		// TODO Auto-generated method stub
		return Arrays.deepToString(calc2DArray());
	}

}
