import java.util.*;

/*
Party Greeting takes an array of String containing names and constructs an appropriate greeting
starting with Hello, ending a !, and with commas between the names. Test cases are below:

Party Greeting
[]
Hello!

Party Greeting
[Zelda]
Hello Zelda!

Party Greeting
[Yancy, Zelda]
Hello Yancy and Zelda!

Party Greeting
[Xander, Yancy, Zelda]
Hello Xander, Yancy, and Zelda!

Party Greeting
[Urkel, Willow, Xander, Yancy, Zelda]
Hello Urkel, Willow, Xander, Yancy, and Zelda!

*/

public class PartyGreeting implements ProblemIO {
	private String[] inputArray; // array containing a list of names

	public PartyGreeting(String[] inputArray) {
		this.inputArray = inputArray;
	}

	/*
	 * calculateGreeting() creates the greeting from the list of names. YOU MUST
	 * IMPLEMENT THIS METHOD
	 */
	public String calculateGreeting() {
		String greeting = "Hello";
		for (int i = 0; i < inputArray.length; i++) {
			if (i < inputArray.length - 1) {
				greeting += " " + inputArray[i] + ",";
			} else if (inputArray.length == 1) {
				greeting += " " + inputArray[i];
			} else {
				greeting += " and " + inputArray[i];
			}
		}
		greeting += "!";
		return greeting;
	}

	@Override
	public String problemHeader() {
		return "Party Greeting";
	}

	@Override
	public String problemInput() {
		return Arrays.toString(inputArray);
	}

	@Override
	public String problemOutput() {
		return calculateGreeting();
	}

}
