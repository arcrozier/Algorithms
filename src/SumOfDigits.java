
/*
Sum of digits takes an integer and returns the sum of the digits in the integer. 
If integer is negative, then Sum of digits will return the sum of the digits negated.  Test output:

Sum of Digits
1235
11

Sum of Digits
-9874
-28
 */

public class SumOfDigits implements ProblemIO {
	private int input; // number to find sum of digits for

	public SumOfDigits(int input) {
		this.input = input;
	}

	/*
	 * calculateSumOfDigits is the method that returns the sum of the digits in
	 * the integer. YOU MUST IMPLEMENT THIS METHOD
	 */
	public int calculateSumOfDigits() {
		int sum = 0;
		String numStr = input + "";
		boolean negative = false;
		for (int i = 0; i < numStr.length(); i++) {
			if (numStr.charAt(i) == '-') {
				negative = true;
			} else {
				sum += numStr.charAt(i) - 48;
			}
		}
		return negative ? sum * -1 : sum;
	}

	@Override
	public String problemHeader() {
		// TODO Auto-generated method stub
		return "Sum of Digits";
	}

	@Override
	public String problemInput() {
		return Integer.toString(input);
	}

	@Override
	public String problemOutput() {
		// TODO Auto-generated method stub
		return Integer.toString(calculateSumOfDigits());
	}

}
