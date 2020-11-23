/* 
Boolean Adder takes in two strings consisting of ones and zeros (binary numbers) and 
returns a string that returns a string consisting of ones and zeros that represent the
addition of the two binary numbers.  Internally, these Strings of 0 and 1s are converted to and array of
booleans for input/output.  You may not use the Integer.parseInt() to solve this problem.
Test results:

Add Binary Strings
010101010101010
000001111111111
010111010101001

Add Binary Strings
01010110101000001111
00000000001111110000
01010110110111111111
 */

public class BooleanAdder implements ProblemIO {
	private boolean[] n1;
	private boolean[] n2;

	public BooleanAdder(String number1, String number2) {
		int arrayLength = Math.max(number1.length(), number2.length()) + 1;
		n1 = convertBooleanArray(number1, arrayLength);
		n2 = convertBooleanArray(number2, arrayLength);
	}

	public String addBooleanStrings() {
		return convertBinaryString(addBooleanArrays());
	}

	/*
	 * addBooleanArrays() takes the two boolean arrays and returns a 3rd boolean
	 * array which is the addition of the two YOU MUST IMPLEMENT THIS METHOD
	 */
	private boolean[] addBooleanArrays() {
		boolean[] shorterArray = n1.length <= n2.length ? n1 : n2;
		boolean[] sumArray = new boolean[1 + (n1.length >= n2.length ? n1.length : n2.length)];
		boolean carry = false;

		for (int i = 1; i <= shorterArray.length; i++) {
			if (n1[n1.length - i] && n2[n2.length - i]) {
				sumArray[sumArray.length - i] = carry ? true : false;
				carry = true;
			} else if (n1[n1.length - i] || n2[n2.length - i] && !(n1[n1.length - i] && n2[n2.length - i])) {
				sumArray[sumArray.length - i] = carry ? false : true;
				carry = carry ? true : false;
			} else if (!n1[n1.length - i] && !n2[n2.length - i]) {
				sumArray[sumArray.length - i] = carry ? true : false;
				carry = false;
			}
		}
		if (carry) {
			sumArray[sumArray.length - shorterArray.length - 1] = true;
		}

		return sumArray;
	}

	/*
	 * converts a String consisting of 0's and 1's into a array of booleans. the
	 * lest significant binary digit is in index 0
	 */
	private boolean[] convertBooleanArray(String inString, int alength) {
		boolean[] cvtArray = new boolean[alength]; // initial value is false
		int arrayPos = 0;
		int stringPos = inString.length() - 1;
		while (stringPos >= 0) {
			if (inString.charAt(stringPos) == '1')
				cvtArray[arrayPos] = true;
			arrayPos++;
			stringPos--;
		}
		return cvtArray;
	}

	// converts a boolean array to a String of 0 and 1s
	private String convertBinaryString(boolean[] inArray) {
		StringBuilder bStr = new StringBuilder("");
		for (int i = 0; i < inArray.length; i++) {
			if (inArray[i]) {
				bStr.insert(0, '1');
			} else {
				bStr.insert(0, '0');
			}
		}
		return bStr.toString();
	}

	@Override
	public String problemHeader() {
		return "Add Binary Strings";
	}

	@Override
	public String problemInput() {
		return convertBinaryString(n1) + "\n" + convertBinaryString(n2);
	}

	@Override
	public String problemOutput() {
		return addBooleanStrings();
	}

}
