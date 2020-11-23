
/* 
String Shuffler takes an ArrayList of Strings and shuffles them randomly like a deck of cards should 
be.  Test data (of course your results will differ)
 
 String Shuffler
[apple, apple pie, beans, brownie, Carrots, coconut]
[beans, apple pie, brownie, apple, coconut, Carrots]

String Shuffler
[ice cream, DORITIOS, doughnut, oreo, Fudge, popcorn]
[Fudge, ice cream, DORITIOS, doughnut, popcorn, oreo]

 */
import java.util.*;

public class StringShuffler implements ProblemIO {
	ArrayList<String> originalList; // original list of Strings passed as
									// constructor parameter
	ArrayList<String> inputList; // copy of the original list to be used to
									// create shuffled version
	ArrayList<String> shuffledList; // shuffled version of original list

	public StringShuffler(ArrayList<String> inputList) {
		this.originalList = inputList;
		this.inputList = new ArrayList<String>();
		this.inputList.addAll(inputList);
		shuffleList();
	}

	/*
	 * shuffleList pulls a String at random from inputList and puts it into
	 * shuffledList YOU MUST IMPLEMENT THIS METHOD
	 */
	public void shuffleList() {
		shuffledList = new ArrayList<String>();
		Random rand = new Random();

		while (inputList.size() > 0) {
			int r = rand.nextInt(inputList.size());
			String s = inputList.remove(r);
			shuffledList.add(s);
		}
	}

	public ArrayList<String> getShuffledList() {
		return shuffledList;
	}

	@Override
	public String problemHeader() {
		return "String Shuffler";
	}

	@Override
	public String problemInput() {
		return this.originalList.toString();
	}

	@Override
	public String problemOutput() {
		return shuffledList.toString();
	}

}
