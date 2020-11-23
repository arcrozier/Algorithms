/*
 Stacking blocks takes an integer parameter and draws a series of blocks stacked upon each other
 based upon the parameter.   You may not use the String .repeat() method in your solution.   
 Test results are at the bottom of class.
 */

public class StackingBlocks implements ProblemIO {
	private int numBlocks;

	public StackingBlocks(int numBlocks) {
		this.numBlocks = numBlocks;
	}

	/*
	 * drawStackingBlocks returns a String containing multiple lines separated
	 * by \n to draw the specified design. You may create helper methods to
	 * assist you in development. YOU MUST IMPLEMENT THIS METHOD
	 */
	public String drawStackingBlocks() {
		String stackedBlocks = "";
		for (int i = 1; i <= numBlocks; i++) {
			stackedBlocks += makeBlock(i);
		}
		return stackedBlocks;
	}

	private String makeBlock(int num) {
		String block = "";
		String bar = "+";
		for (int i = 0; i < num * 2 + ("" + num).length(); i++) {
			bar += "-";
		}
		bar += "+\n";
		block += bar;
		for (int i = 1; i <= num; i++) {
			String line = "|";
			for (int j = 0; j < num; j++) {
				line += " ";
			}
			line += "" + num;
			for (int j = 0; j < num; j++) {
				line += " ";
			}
			line += "|\n";
			block += line;
		}
		block += bar;
		return block;
	}

	@Override
	public String problemInput() {
		// TODO Auto-generated method stub
		return Integer.toString(numBlocks);
	}

	@Override
	public String problemOutput() {
		// TODO Auto-generated method stub
		return drawStackingBlocks();
	}

	@Override
	public String problemHeader() {
		return "Stacking Blocks";
	}

}

/*
 * Stacking Blocks 3 +-+ |1| +-+ +--+ |2 | | 2| +--+ +---+ |3 | | 3 | | 3| +---+
 * 
 * 
 * Stacking Blocks 8 +-+ |1| +-+ +--+ |2 | | 2| +--+ +---+ |3 | | 3 | | 3| +---+
 * +----+ |4 | | 4 | | 4 | | 4| +----+ +-----+ |5 | | 5 | | 5 | | 5 | | 5|
 * +-----+ +------+ |6 | | 6 | | 6 | | 6 | | 6 | | 6| +------+ +-------+ |7 | |
 * 7 | | 7 | | 7 | | 7 | | 7 | | 7| +-------+ +--------+ |8 | | 8 | | 8 | | 8 |
 * | 8 | | 8 | | 8 | | 8| +--------+
 * 
 * 
 * Stacking Blocks 12 +-+ |1| +-+ +--+ |2 | | 2| +--+ +---+ |3 | | 3 | | 3|
 * +---+ +----+ |4 | | 4 | | 4 | | 4| +----+ +-----+ |5 | | 5 | | 5 | | 5 | | 5|
 * +-----+ +------+ |6 | | 6 | | 6 | | 6 | | 6 | | 6| +------+ +-------+ |7 | |
 * 7 | | 7 | | 7 | | 7 | | 7 | | 7| +-------+ +--------+ |8 | | 8 | | 8 | | 8 |
 * | 8 | | 8 | | 8 | | 8| +--------+ +---------+ |9 | | 9 | | 9 | | 9 | | 9 | |
 * 9 | | 9 | | 9 | | 9| +---------+ +----------+ |0 | | 0 | | 0 | | 0 | | 0 | |
 * 0 | | 0 | | 0 | | 0 | | 0| +----------+ +-----------+ |1 | | 1 | | 1 | | 1 |
 * | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | | 1| +-----------+ +------------+ |2 | |
 * 2 | | 2 | | 2 | | 2 | | 2 | | 2 | | 2 | | 2 | | 2 | | 2 | | 2| +------------+
 */
