
/* 
 * Merge sorted arrays take two arrays each which is sorted ascending and returns an array that is also
 * sorted ascending and contains the elements of both arrays.  Sorting is case insensitive.  Test results:

Merge Sorted Arrays
[apple, eggplant, ICE CREAM, oAtMeal, udon]
[beans, Carrots, Doritos, eggs, fRuit, GINGER]
[apple, beans, Carrots, Doritos, eggplant, eggs, fRuit, GINGER, ICE CREAM, oAtMeal, udon]

Merge Sorted Arrays
[beans, Carrots, Doritos, eggs, fRuit, GINGER]
[TACOS, vanilla, Watermelon, yam, Yogurt]
[beans, Carrots, Doritos, eggs, fRuit, GINGER, TACOS, vanilla, Watermelon, yam, Yogurt]

Merge Sorted Arrays
[coconut, humus, kale, peas, pizza, wasabi]
[apple, eggplant, ICE CREAM, oAtMeal, udon]
[apple, coconut, eggplant, humus, ICE CREAM, kale, oAtMeal, peas, pizza, udon, wasabi]

Merge Sorted Arrays
[TACOS, vanilla, Watermelon, yam, Yogurt]
[coconut, humus, kale, peas, pizza, wasabi]
[coconut, humus, kale, peas, pizza, TACOS, vanilla, wasabi, Watermelon, yam, Yogurt] 

*/
import java.util.*;

public class MergeSortedArrays implements ProblemIO {
	private String[] array1; // first sorted array
	private String[] array2; // second sorted array

	public MergeSortedArrays(String[] array1, String[] array2) {
		this.array1 = array1;
		this.array2 = array2;
	}

	/*
	 * createMerge() takes the two sorted arrays and returns a third sorted
	 * array with all the elements of the first two. YOU MUST IMPLEMENT THIS
	 * METHOD
	 */
	public String[] createMerge() {
		String[] merged = new String[array1.length + array2.length];
		String[] smallList = array1.length < array2.length ? array1 : array2;
		String[] bigList = array1.length < array2.length ? array2 : array1;
		int startIndex = 0;
		int index = 0;
		for (int i = 0; i < smallList.length; i++) {
			for (int j = startIndex; j < bigList.length; j++) {
				if (!isInFrontOf(smallList[i], bigList[j])) {
					merged[index] = bigList[j];
					index++;
					startIndex++;
					if (j == bigList.length - 1) {
						for (int k = i; k < smallList.length; k++) {
							merged[index] = smallList[k];
							index++;
						}
						i = smallList.length;
					}
				} else if (isInFrontOf(smallList[i], bigList[j])) {
					merged[index] = smallList[i];
					index++;
					j = bigList.length;
				}
			}
		}
		if (startIndex < bigList.length) {
			for (int ii = startIndex; ii < bigList.length; ii++) {
				merged[index] = bigList[ii];
				index++;
			}
		}
		return merged;
	}

	private boolean isInFrontOf(String str1, String str2) {
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

	@Override
	public String problemHeader() {
		return "Merge Sorted Arrays";
	}

	@Override
	public String problemInput() {
		return Arrays.toString(array1) + "\n" + Arrays.toString(array2);
	}

	@Override
	public String problemOutput() {
		return Arrays.toString(createMerge());
	}

}
