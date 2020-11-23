/* 
This is the sample problem.  This particular class/method takes a String as input
and returns the String with all the characters reversed.  Test results:

 Sample Problem - String Reversal
The quick brown fox jumps over the lazy dog.
.god yzal eht revo spmuj xof nworb kciuq ehT

Sample Problem - String Reversal
Injustice anywhere is a threat to justice everywhere.
.erehwyreve ecitsuj ot taerht a si erehwyna ecitsujnI
 
 */

public class SampleProblem implements ProblemIO {

	private String inputString; // String input

	public SampleProblem(String inputString) {
		this.inputString = inputString;
	}

	/*
	 * This is the method that reverses the string that is a field in the object
	 * For every problem, one just needs to write one method provided. The
	 * constructor, and the methods that implement the interface have already
	 * been written.
	 */
	public String reverseString() {
		String reverseString = "";
		for (int i = inputString.length() - 1; i >= 0; i--) {
			reverseString = reverseString + inputString.charAt(i);
		}
		return reverseString;
	}

	@Override
	public String problemInput() {
		return inputString;
	}

	@Override
	public String problemOutput() {
		return reverseString();
	}

	@Override
	public String problemHeader() {
		return "Sample Problem - String Reversal";
	}
}
