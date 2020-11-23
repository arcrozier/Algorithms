
/*
Tally letters takes a String as input and returns an array that tallies
the number of times each letter appears in the String. Each appearance of 'a' or 'A'
is tallied at index 0, 'b' or 'B" is tallied in index 1, ... and 'z' or 'Z' in index 25.
Non-letters are not counted. 
Test examples:

Tally Letters in String
The quick brown fox jumped over the lazy dog
[1, 1, 1, 2, 4, 1, 1, 2, 1, 1, 1, 1, 1, 1, 4, 1, 1, 2, 0, 2, 2, 1, 1, 1, 1, 1]

Tally Letters in String
apple, apple pie, beans, brownie, Carrots, coconut, cookies, Doritos, doughnut, eggplant, eggs, fRuit, fudge, GINGER, humus, ICE CREAM, kale, LEMON, oAtMeal, orange, oreos, peas, pizza, TACOS, udon, vanilla, wasabi, Watermelon, yam, Yogurt
[19, 3, 7, 4, 20, 2, 10, 2, 10, 0, 2, 9, 6, 11, 18, 8, 0, 11, 10, 10, 9, 1, 3, 0, 2, 2]
  
*/
import java.util.*;

public class TallyLetters implements ProblemIO {
	private String inputString;

	public TallyLetters(String inputString) {
		this.inputString = inputString;
	}

	/*
	 * tallyLetterArray tallies the number of times each letter appears in a
	 * String and returns the result in an int[26] array. YOU MUST IMPLEMENT
	 * THIS METHOD
	 */
	public int[] tallyLetterArray() {
		int[] tally = new int[26];
		for (int i = 0; i < inputString.length(); i++) {
			if ((inputString.charAt(i) >= 65 && inputString.charAt(i) <= 90)
					|| (inputString.charAt(i) >= 97 && inputString.charAt(i) <= 122))
				tally[inputString.charAt(i) - (inputString.charAt(i) >= 97 ? 97 : 65)]++;
		}
		return tally;
	}

	@Override
	public String problemHeader() {
		return "Tally Letters in String";
	}

	@Override
	public String problemInput() {
		return inputString;
	}

	@Override
	public String problemOutput() {
		return Arrays.toString(tallyLetterArray());
	}

}
