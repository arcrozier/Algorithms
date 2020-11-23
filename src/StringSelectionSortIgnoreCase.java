
/*
String Selection Sort Ignore Case takes an array of Strings and uses selection sort to
create a sorted array.  The sort should be case insensitive.  You may not use Arrays.sort().
Test output:

String Selection Sort Ignore Case
[beans, Watermelon, yam, TACOS, kale, fRuit, wasabi, peas, coconut, pizza, Doritos, udon, vanilla, fudge, oreos, humus, oAtMeal, eggs, ICE CREAM, brownie, cookies, Carrots, GINGER, eggplant, apple pie, apple, Yogurt, doughnut, orange, LEMON]
[apple, apple pie, beans, brownie, Carrots, coconut, cookies, Doritos, doughnut, eggplant, eggs, fRuit, fudge, GINGER, humus, ICE CREAM, kale, LEMON, oAtMeal, orange, oreos, peas, pizza, TACOS, udon, vanilla, wasabi, Watermelon, yam, Yogurt]

String Selection Sort Ignore Case
[Zelda, Yancy, Xander, Willow, Urkel]
[Urkel, Willow, Xander, Yancy, Zelda]
 
 */
import java.util.*;

public class StringSelectionSortIgnoreCase implements ProblemIO {
	String[] inputArray; // original array
	String[] sortedArray; // sorted version of original array

	public StringSelectionSortIgnoreCase(String[] inputArray) {
		this.inputArray = inputArray;
		this.sortedArray = Arrays.copyOf(this.inputArray, this.inputArray.length);
		this.stringSelectionSortIgnoreCase();
	}

	/*
	 * stringSelectionSortIgnoreCase() takes a copy of the original unsorted
	 * array and sorts it using selection sort. YOU MUST IMPLEMENT THIS METHOD
	 */
	public void stringSelectionSortIgnoreCase() {
		for (int i = 0; i < inputArray.length; i++) {
			String priorityStr = inputArray[i];
			int index = 0;
			for (int j = i; j < inputArray.length; j++) {
				if (!hasPriorityOver(priorityStr, inputArray[j])) {
					priorityStr = inputArray[j];
					index = j;
				}
			}
			sortedArray[i] = priorityStr;
			String temp = inputArray[i];
			inputArray[i] = inputArray[index];
			inputArray[index] = temp;
		}
	}

	private boolean hasPriorityOver(String str1, String str2) {
		for (int i = 0; i < (str1.length() < str2.length() ? str1.length() : str2.length()); i++) {
			if (toLowerCase(str1.charAt(i)) < toLowerCase(str2.charAt(i)))
				return true;
			if (toLowerCase(str2.charAt(i)) < toLowerCase(str1.charAt(i)))
				return false;
		}
		return (str1.length() == str2.length() ? true : (str1.length() < str2.length() ? true : false));
	}

	private char toLowerCase(char inChar) {
		return inChar >= 65 && inChar <= 90 ? (char) (inChar + 32) : inChar;
	}

	public String[] getSortedArray() {
		return this.sortedArray;
	}

	@Override
	public String problemHeader() {
		return "String Selection Sort Ignore Case";
	}

	@Override
	public String problemInput() {
		return Arrays.toString(this.inputArray);
	}

	@Override
	public String problemOutput() {
		return Arrays.toString(this.sortedArray);
	}

}
