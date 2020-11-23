
/* 
Generate 12 days song creates a parody song similar to the "12 days of Christmas".
Inputs are a festival (e.g. "Christmas"), benefactor (e.g. "true love"), and
an array of gifts.   Test output is at the bottom of this class.
 */
import java.util.Arrays;

public class Generate12DaysSong implements ProblemIO {
	String festival;
	String benefactor;
	String[] giftArray;

	public Generate12DaysSong(String festival, String benefactor, String[] giftArray) {
		this.festival = festival;
		this.benefactor = benefactor;
		this.giftArray = giftArray;
	}

	/*
	 * generateSong() creates the song in a single String objects. Lines in the
	 * song are each on a line ended by \n and each stanza has a blank line
	 * before the next stanza. You may implement helper methods in addition to
	 * this one. YOU MUST IMPLEMENT THIS METHOD
	 */
	public String generateSong() {
		String song = "";
		for (int i = 1; i <= 12; i++) {
			String day = "";
			switch (i) {
				case (1):
					day = "1st";
					break;
				case (2):
					day = "2nd";
					break;
				case (3):
					day = "3rd";
					break;
				default:
					day = i + "th";
					break;
			}
			String gifts = "";
			for (int j = i; j > 1; j--) {
				gifts += j + " " + giftArray[j - 1] + "\n";
			}
			gifts += i == 1 ? giftArray[0] : "and " + giftArray[0];
			song += "On the " + day + " day of " + festival + "\nMy " + benefactor + " gave to me\n" + gifts + "\n\n";
		}
		return song;
	}

	@Override
	public String problemHeader() {
		return "Generate 12 Days Song";
	}

	@Override
	public String problemInput() {
		return festival + "\t" + benefactor + "\t" + Arrays.toString(giftArray);
	}

	@Override
	public String problemOutput() {
		// TODO Auto-generated method stub
		return generateSong();
	}
}

/*
 * Test output Generate 12 Days Song High School teacher [a partridge in a pear
 * tree, gold stars, javelins, avocados, reflections, minutes for recess, book
 * reports, t-tests, songs by Drake, hours of detention, homework problems,
 * vocabulary quizzes] On the 1st of High School My teacher gave to me a
 * partridge in a pear tree
 * 
 * On the 2nd of High School My teacher gave to me 2 gold stars and a partridge
 * in a pear tree
 * 
 * On the 3rd of High School My teacher gave to me 3 javelins 2 gold stars and a
 * partridge in a pear tree
 * 
 * On the 4th of High School My teacher gave to me 4 avocados 3 javelins 2 gold
 * stars and a partridge in a pear tree
 * 
 * On the 5th of High School My teacher gave to me 5 reflections 4 avocados 3
 * javelins 2 gold stars and a partridge in a pear tree
 * 
 * On the 6th of High School My teacher gave to me 6 minutes for recess 5
 * reflections 4 avocados 3 javelins 2 gold stars and a partridge in a pear tree
 * 
 * On the 7th of High School My teacher gave to me 7 book reports 6 minutes for
 * recess 5 reflections 4 avocados 3 javelins 2 gold stars and a partridge in a
 * pear tree
 * 
 * On the 8th of High School My teacher gave to me 8 t-tests 7 book reports 6
 * minutes for recess 5 reflections 4 avocados 3 javelins 2 gold stars and a
 * partridge in a pear tree
 * 
 * On the 9th of High School My teacher gave to me 9 songs by Drake 8 t-tests 7
 * book reports 6 minutes for recess 5 reflections 4 avocados 3 javelins 2 gold
 * stars and a partridge in a pear tree
 * 
 * On the 10th of High School My teacher gave to me 10 hours of detention 9
 * songs by Drake 8 t-tests 7 book reports 6 minutes for recess 5 reflections 4
 * avocados 3 javelins 2 gold stars and a partridge in a pear tree
 * 
 * On the 11th of High School My teacher gave to me 11 homework problems 10
 * hours of detention 9 songs by Drake 8 t-tests 7 book reports 6 minutes for
 * recess 5 reflections 4 avocados 3 javelins 2 gold stars and a partridge in a
 * pear tree
 * 
 * On the 12th of High School My teacher gave to me 12 vocabulary quizzes 11
 * homework problems 10 hours of detention 9 songs by Drake 8 t-tests 7 book
 * reports 6 minutes for recess 5 reflections 4 avocados 3 javelins 2 gold stars
 * and a partridge in a pear tree
 */
