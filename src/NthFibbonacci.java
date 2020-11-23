/*
Nth Fibonacci calculates the nth Fibonacci number.  Test results:

Nth Fibonacci number
1
1

Nth Fibonacci number
10
55

Nth Fibonacci number
30
832040
*/

public class NthFibbonacci implements ProblemIO {
	private int nthNum; // the position of number

	public NthFibbonacci(int nthNum) {
		this.nthNum = nthNum;
	}

	/*
	 * calcNthFibbonacci calculates the nth Fibonacci number YOU MUST IMPLEMENT
	 * THIS METHOD
	 */
	public int calcNthFibbonacci() {
		// FIBONACCI CONTAINS A SINGULAR 'B'
		int fn2 = 1;
		int fn1 = 1;
		int fn = 1;
		for (int i = 3; i <= nthNum; i++) {
			fn = fn1 + fn2;
			fn2 = fn1;
			fn1 = fn;
		}
		return fn;
	}

	@Override
	public String problemHeader() {
		return "Nth Fibonacci number";
	}

	@Override
	public String problemInput() {
		return Integer.toString(nthNum);
	}

	@Override
	public String problemOutput() {
		return Integer.toString(calcNthFibbonacci());
	}

}
