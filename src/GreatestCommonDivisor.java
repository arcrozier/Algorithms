/*
Greatest Common Divisor takes two numbers and finds the greatest common divisor of the
two numbers.  While other algorithms may be used, suggest using Euclid's algorithm at
https://en.wikipedia.org/wiki/Euclidean_algorithm.  Test results:

Greatest Common Divisor
75 112
1

Greatest Common Divisor
24 600
24

Greatest Common Divisor
144 600
24
*/

public class GreatestCommonDivisor implements ProblemIO {
	private int A_integer; // first integer
	private int B_integer; // second integer

	public GreatestCommonDivisor(int A_integer, int B_integer) {
		this.A_integer = A_integer;
		this.B_integer = B_integer;
	}

	/*
	 * calculateGCD() returns the greatest common divisor of the two numbers YOU
	 * MUST IMPLEMENT THIS METHOD
	 */
	public int calculateGCD() {
		return recurse(A_integer, B_integer);
	}

	private int recurse(int a, int b) {
		if (b == 0) {
			return a;
		}
		return recurse(b, a % b);
	}

	@Override
	public String problemHeader() {
		return "Greatest Common Divisor";
	}

	@Override
	public String problemInput() {
		return A_integer + " " + B_integer;
	}

	@Override
	public String problemOutput() {
		return Integer.toString(calculateGCD());
	}

}
