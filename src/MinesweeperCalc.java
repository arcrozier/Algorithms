
/*
Minesweeper Calc takes a two dimensional array of 1s and 0s where the 1s
are mines and the 0s are safe and returns a two dimensional array of the 
same dimensions where each mine is represented by -1 and all other blocks count
the number of mines (up to 8) around it.  Test output:

Minesweeper Calc
[[0, 1, 1, 0, 0, 0], [0, 0, 1, 0, 0, 0], [1, 0, 0, 1, 0, 0, 1], [0, 0, 0, 1, 1, 0], [0, 1, 0, 0, 1, 0], [0, 1, 0, 0, 1, 0], [0, 0, 1, 0, 0, 0]]
[[1, -1, -1, 2, 0, 0], [2, 4, -1, 3, 1, 0], [-1, 2, 3, -1, 3, 1], [2, 2, 3, -1, -1, 2], [2, -1, 3, 4, -1, 3], [2, -1, 3, 3, -1, 2], [1, 2, -1, 2, 1, 1]]

Minesweeper Calc
[[0, 1, 1, 0, 0, 0, 1], [0, 0, 1, 0, 0, 0, 1], [1, 0, 0, 1, 0, 0, 1], [0, 0, 0, 1, 1, 0, 0], [0, 1, 0, 0, 1, 0, 1], [1, 0, 0, 0, 1, 0, 0]]
[[1, -1, -1, 2, 0, 2, -1], [2, 4, -1, 3, 1, 3, -1], [-1, 2, 3, -1, 3, 3, -1], [2, 2, 3, -1, -1, 4, 2], [2, -1, 2, 4, -1, 4, -1], [-1, 2, 1, 2, -1, 3, 1]]

 */
import java.util.*;

public class MinesweeperCalc implements ProblemIO {
	private int[][] mineLocations; // 2D array with 1 for mines, 0 for safe
									// blocks

	public MinesweeperCalc(int[][] mineLocations) {
		this.mineLocations = mineLocations;
	}

	/*
	 * calculateMineCounts returns a two dimensional array that has -1 for all
	 * blocks that contain a mine (1 in mineLocations) or contains the count of
	 * mines around it. You may want to develop helper methods to write this
	 * solution. YOU MUST IMPLEMENT THIS METHOD
	 */

	public int[][] calculateMineCounts() {
		int[][] mineCount = new int[mineLocations.length][mineLocations[0].length];
		for (int x = 0; x < mineLocations.length; x++) {
			for (int y = 0; y < mineLocations[0].length; y++) {
				if (mineLocations[x][y] == 1) {
					for (int xDif = -1; xDif <= 1; xDif++) {
						if (x + xDif >= mineLocations.length || x + xDif < 0) {
						} else {
							for (int yDif = -1; yDif <= 1; yDif++) {
								if (y + yDif >= mineLocations[0].length || y + yDif < 0
										|| mineLocations[x + xDif][y + yDif] == 1) {
								} else {
									mineCount[x + xDif][y + yDif]++;
								}
							}
						}
					}
					mineCount[x][y] = -1;
				}
			}
		}
		return mineCount;
	}

	@Override
	public String problemHeader() {
		return "Minesweeper Calc";
	}

	@Override
	public String problemInput() {
		return Arrays.deepToString(mineLocations);
	}

	@Override
	public String problemOutput() {
		return Arrays.deepToString(calculateMineCounts());
	}

}
