/*
Last First Reversal takes a name in the format "Last, First M" and returns a name String in the format
"First M Last".   If the comma either does not exist or is the first or last character in the original 
name string, you should return the original name string.  Test results:

Reverse Last and First Names
Jayapal, Pramila
Pramila Jayapal

Reverse Last and First Names
McMorris Rodgers, Cathy
Cathy McMorris Rodgers

Reverse Last and First Names
Larsen, Rick R
Rick R Larsen
 */

public class LastFirstReversal implements ProblemIO {
	private String inputString;

	public LastFirstReversal(String inputString) {
		this.inputString = inputString.trim();
	}

	/*
	 * reverseFirstLast takes the name in "Last, First M" format and return is
	 * as "First M Last" YOU MUST IMPLEMENT THIS METHOD
	 */
	public String reverseFirstLast() {
		int commaIndex = inputString.indexOf(',');
		String newStr = inputString.substring(commaIndex + 1).trim() + " " + inputString.substring(0, commaIndex);
		return newStr;
	}

	@Override
	public String problemHeader() {
		// TODO Auto-generated method stub
		return "Reverse Last and First Names";
	}

	@Override
	public String problemInput() {
		return inputString;
	}

	@Override
	public String problemOutput() {
		// TODO Auto-generated method stub
		return reverseFirstLast();
	}

}
