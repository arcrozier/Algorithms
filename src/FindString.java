/*
Find String determines whether one String exists within another.  If the String to be found is
 within the target String, Find String will return the starting index in the target string where the
 match starts.  Otherwise, it returns -1.  Find String is case sensitive.  
 You may not use the String indexOf() method in your solution.  Test output:
 
Find String
quick
the quick brown fox jumps over the lazy dog
4

Find String
QUICK
the quick brown fox jumps over the lazy dog
-1

Find String
1234
the quick brown fox jumps over the lazy dog
-1

Find String
wn fo
the quick brown fox jumps over the lazy dog
13

 */

public class FindString implements ProblemIO {
	private String targetString; // the string to be searched within
	private String findString; // the string to search for in the target String

	public FindString(String findString, String targetString) {
		this.findString = findString;
		this.targetString = targetString;
	}

	/*
	 * findLocation() searches for findString within targetString and returns
	 * the index where the match starts or -1 otherwise. YOU MUST IMPLEMENT THIS
	 * METHOD
	 */
	public int findLocation() {
		int index = -1;
		char firstChar = findString.charAt(0);
		for (int i = 0; i < targetString.length() - findString.length(); i++) {
			if (targetString.charAt(i) == firstChar) {
				if (targetString.substring(i, i + findString.length()).equals(findString))
					index = i;
			}
		}
		return index;
	}

	@Override
	public String problemHeader() {
		return "Find String";
	}

	@Override
	public String problemInput() {
		return findString + "\n" + targetString;
	}

	@Override
	public String problemOutput() {
		return Integer.toString(findLocation());
	}

}
