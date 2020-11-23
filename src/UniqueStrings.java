
/* 
Unique Strings takes an array of Strings as input and returns an ArrayList containing
the unique strings (case-sensitive) in the array.   The resulting ArrayList should be in
alphabetical (case-sensitive) order.   You may not use the ArrayList contains() method in 
your solution.   Test results:

List Unique Strings
[ant, dog, CAT, bear, dog, cat, eagle]
[CAT, bear, cat, dog, eagle]

List Unique Strings
[Elvis, Elvis, Prince, Adele, Eminem, Beyonce, Bono, Adele, Prince, Beyonce, Elvis, Rihanna]
[Adele, Beyonce, Bono, Elvis, Eminem, Prince, Rihanna]

 */
import java.util.*;

public class UniqueStrings implements ProblemIO {
	private String[] inputArray;

	public UniqueStrings(String[] inputArray) {
		this.inputArray = inputArray;
	}

	/*
	 * listUniqueStrings() takes the input array of Strings and returns an
	 * ArrayList of all the unique strings. YOU MUST IMPLEMENT THIS METHOD
	 */
	public ArrayList<String> listUniqueStrings() {
		ArrayList<String> uniqueStrings = new ArrayList<String>();
		for (int i = 0; i < inputArray.length; i++) {
			boolean isUnique = true;
			for (int j = 0; j < uniqueStrings.size(); j++) {
				if (inputArray[i].equals(uniqueStrings.get(j))) {
					isUnique = false;
					j = uniqueStrings.size();
				}
			}
			if (isUnique)
				uniqueStrings.add(inputArray[i]);
		}
		uniqueStrings.sort(new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				for (int i = 0; i < (str1.length() < str2.length() ? str1.length() : str2.length()); i++) {
					if (toLowerCase(str1.charAt(i)) < toLowerCase(str2.charAt(i)))
						return -1;
					if (toLowerCase(str2.charAt(i)) < toLowerCase(str1.charAt(i)))
						return 1;
				}
				return (str1.length() == str2.length() ? 0 : (str1.length() < str2.length() ? 1 : -1));
			}
		});
		return uniqueStrings;
	}

	private char toLowerCase(char inChar) {
		return inChar >= 65 && inChar <= 90 ? (char) (inChar + 32) : inChar;
	}

	@Override
	public String problemHeader() {
		return "List Unique Strings";
	}

	@Override
	public String problemInput() {
		return Arrays.toString(inputArray);
	}

	@Override
	public String problemOutput() {
		return listUniqueStrings().toString();
	}

}
