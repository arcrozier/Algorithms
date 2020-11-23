import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.util.*;

public class UIProblem {
	private JFrame frame; // overall application frame
	private JTextArea textArea; // text area to write to
	private JComboBox<String> comboBox; // execution combo box
	private JFileChooser fc = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIProblem window = new UIProblem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UIProblem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// Overall application frame
		frame = new JFrame();
		frame.setTitle("Ingraham High IB CS");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		// Scrolling text area

		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);

		JScrollPane scrollPane = new JScrollPane(textArea);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 14;
		gbc_textArea.gridheight = 7;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 0;
		frame.getContentPane().add(scrollPane, gbc_textArea);
		textArea.setText("");

		// Combo-box for problems
		String[] problemList = { "0:All", "1:AverageValue", "2:RangeValue", "3:MaximumPosition", "4:PartyGreeting",
				"5:SeasonCalendar", "6:SumOfDigits", "7:NthFibonacci", "8:LastFirstReversal", "9:CalculateHeronArea",
				"10:IsIncreasingIntegerArray", "11:FindString", "12:StackingBlocks", "13:To2DArray",
				"14:MergeSortedArray", "15:StringSelectionSortIgnoreCase", "16:StringShuffle", "17:TallyLetters",
				"18:UniqueStrings", "19:Generate12DaySong", "20:BooleanAdder", "21:CountWords",
				"22:BinaryIntegerSearch", "23:GreatestCommonDivisor", "24:HalfCollision", "25:MinesweeperCalc",
				"99:SampleProblem - Reverse String" };

		comboBox = new JComboBox<String>(problemList);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 13;
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 7;
		frame.getContentPane().add(comboBox, gbc_comboBox);

		// OK Button to execute problem
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				performSelection();
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.gridx = 13;
		gbc_btnOk.gridy = 7;
		frame.getContentPane().add(btnOk, gbc_btnOk);

		// Add menu items
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		// Clear results menu item
		JMenuItem clearMenuItem = new JMenuItem("Clear Results");
		clearMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
			}
		});

		// Save results menu item
		JMenuItem saveMenuItem = new JMenuItem("Save Results");
		saveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveResultsToFile();
			}
		});

		// Application exit
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		// Add menu items and display
		menuFile.add(clearMenuItem);
		menuFile.add(saveMenuItem);
		menuFile.add(exitMenuItem);
		frame.setJMenuBar(menuBar);

	}

	/*
	 * This code is run when the 'ok' button is clicked to run the given
	 * exercise or all of the exercises
	 */
	private void performSelection() {
		String comboValue = (String) comboBox.getSelectedItem();
		int comboNo = Integer.parseInt(comboValue.substring(0, comboValue.indexOf(':')));
		textArea.append("\n*************Results for " + comboValue + "*************\n");

		if (comboNo == 0) { // Results of all exercises completed

			testAverageValue();
			testRangeValue();
			testMaximumPosition();
			testPartyGreeting();
			testSeasonCalendar();
			testSumOfDigits();
			testNthFibbonacci();
			testLastFirstReversal();
			testCalculateHeronArea();
			testIsIncreasingIntegerArray();
			testFindString();
			testStackingBlocks();
			testTo2DArray();
			testMergeSortedArray();
			testStringSelectionSortIgnoreCase();
			testStringShuffler();
			testTallyLetters();
			testUniqueStrings();
			testGenerate12DaySong();
			testBooleanAdder();
			testCountWords();
			testBinarySearchInt();
			testGreatestCommonDivisor();
			testHalfCollision();
			testMinesweeperCalc();

		} else if (comboNo == 1) { // Average Value
			testAverageValue();
		} else if (comboNo == 2) { // Range Value
			testRangeValue();
		} else if (comboNo == 3) { // Position of Maximum Value
			testMaximumPosition();
		} else if (comboNo == 4) { // Party Greeting
			testPartyGreeting();
		} else if (comboNo == 5) { // Season Calendar
			testSeasonCalendar();
		} else if (comboNo == 6) { // Sum of Digits
			testSumOfDigits();
		} else if (comboNo == 7) { // Nth Fibonacci
			testNthFibbonacci();
		} else if (comboNo == 8) { // Reverse First Last Name
			testLastFirstReversal();
		} else if (comboNo == 9) { // Calculate Triangle Area using Heron's
									// formula
			testCalculateHeronArea();
		} else if (comboNo == 10) { // Is Increasing Integer Array
			testIsIncreasingIntegerArray();
		} else if (comboNo == 11) { // Find String
			testFindString();
		} else if (comboNo == 12) { // Stacking Blocks
			testStackingBlocks();
		} else if (comboNo == 13) { // To 2-D Array
			testTo2DArray();
		} else if (comboNo == 14) { // Merge Sorted Arrays
			testMergeSortedArray();
		} else if (comboNo == 15) { // String Selection Sort Ignore Case
			testStringSelectionSortIgnoreCase();
		} else if (comboNo == 16) { // String Shuffle
			testStringShuffler();
		} else if (comboNo == 17) { // Tally Letters
			testTallyLetters();
		} else if (comboNo == 18) { // Unique Strings
			testUniqueStrings();
		} else if (comboNo == 19) { // Generate 12 Day Song
			testGenerate12DaySong();
		} else if (comboNo == 20) { // Boolean Adder
			testBooleanAdder();
		} else if (comboNo == 21) { // Count Words
			testCountWords();
		} else if (comboNo == 22) { // Binary Search
			testBinarySearchInt();
		} else if (comboNo == 23) { // Greatest Common Divisor
			testGreatestCommonDivisor();
		} else if (comboNo == 24) { // Half Collision
			testHalfCollision();
		} else if (comboNo == 25) { // Minesweeper Calc
			testMinesweeperCalc();
		} else if (comboNo == 99) { // Sample Problem - Reverse String
			testSampleProblem();
		} else {
			textArea.append("Item " + comboValue + " not yet implemented\n");
		}

	}

	private void testAverageValue() {

		AverageValue av1 = new AverageValue(new double[] { 0.5, 4.7, 41.2, -15 });
		printResults(av1);

		AverageValue av2 = new AverageValue(new double[] { 17.5, -6.7, 15, 0.0, 7.1 });
		printResults(av2);

	}

	private void testBinarySearchInt() {
		int[] t_array = { -5, -3, -1, 1, 3, 3, 5, 7, 9, 11, 13 };
		BinarySearchInt bs1 = new BinarySearchInt(7, t_array);
		printResults(bs1);

		BinarySearchInt bs2 = new BinarySearchInt(-8, t_array);
		printResults(bs2);

		BinarySearchInt bs3 = new BinarySearchInt(2, t_array);
		printResults(bs3);

		BinarySearchInt bs4 = new BinarySearchInt(17, t_array);
		printResults(bs4);

	}

	private void testBooleanAdder() {
		BooleanAdder ba1 = new BooleanAdder("10101010101010", "1111111111");
		printResults(ba1);

		BooleanAdder ba2 = new BooleanAdder("1010110101000001111", "1111110000");
		printResults(ba2);
	}

	private void testCountWords() {

		try {
			FileWordCount wc1 = new FileWordCount("file1.txt");
			printResults(wc1);

			FileWordCount wc2 = new FileWordCount("file2.txt");
			printResults(wc2);
		} catch (Exception e) {
			textArea.append("Error: " + e.getMessage() + "\n");
		}
	}

	private void testFindString() {
		FindString fs1 = new FindString("quick", "the quick brown fox jumps over the lazy dog");
		printResults(fs1);

		FindString fs2 = new FindString("QUICK", "the quick brown fox jumps over the lazy dog");
		printResults(fs2);

		FindString fs3 = new FindString("1234", "the quick brown fox jumps over the lazy dog");
		printResults(fs3);

		FindString fs4 = new FindString("wn fo", "the quick brown fox jumps over the lazy dog");
		printResults(fs4);

	}

	private void testGenerate12DaySong() {
		Generate12DaysSong ds1 = new Generate12DaysSong("High School", "teacher",
				new String[] { "a partridge in a pear tree", "gold stars", "javelins", "avocados", "reflections",
						"minutes for recess", "book reports", "t-tests", "songs by Drake", "hours of detention",
						"homework problems", "vocabuluary quizzes" });

		printResults(ds1);

	}

	private void testGreatestCommonDivisor() {
		GreatestCommonDivisor gcd1 = new GreatestCommonDivisor(75, 112);
		printResults(gcd1);

		GreatestCommonDivisor gcd2 = new GreatestCommonDivisor(24, 600);
		printResults(gcd2);

		GreatestCommonDivisor gcd3 = new GreatestCommonDivisor(144, 600);
		printResults(gcd3);

	}

	private void testHalfCollision() {
		HalfCollision hc1 = new HalfCollision(365);
		printResults(hc1);

		HalfCollision hc2 = new HalfCollision(1000);
		printResults(hc2);

		HalfCollision hc3 = new HalfCollision(10000);
		printResults(hc3);
	}

	private void testIsIncreasingIntegerArray() {
		IsIncreasingIntegerArray ii1 = new IsIncreasingIntegerArray(new int[] { -5, -2, 3, 7, 11 });
		printResults(ii1);

		IsIncreasingIntegerArray ii2 = new IsIncreasingIntegerArray(new int[] { -5, -2, -2, 5, 7 });
		printResults(ii2);

		IsIncreasingIntegerArray ii3 = new IsIncreasingIntegerArray(new int[] { -5, -2, 7, 3, 11 });
		printResults(ii3);
	}

	private void testLastFirstReversal() {
		LastFirstReversal lf1 = new LastFirstReversal("Jayapal, Pramila");
		printResults(lf1);

		LastFirstReversal lf2 = new LastFirstReversal("McMorris Rodgers, Cathy");
		printResults(lf2);

		LastFirstReversal lf3 = new LastFirstReversal("Larsen, Rick R");
		printResults(lf3);
	}

	private void testMaximumPosition() {

		MaximumPosition mp1 = new MaximumPosition(new double[] { 0.5, 4.7, 41.2, -15 });
		printResults(mp1);

		MaximumPosition mp2 = new MaximumPosition(new double[] { 17.5, -6.7, 15, 0.0, 7.1 });
		printResults(mp2);

	}

	private void testMergeSortedArray() {

		String[] arr1 = { "apple", "eggplant", "ICE CREAM", "oAtMeal", "udon" };
		String[] arr2 = { "beans", "Carrots", "Doritos", "eggs", "fRuit", "GINGER" };
		String[] arr3 = { "TACOS", "vanilla", "Watermelon", "yam", "Yogurt" };
		String[] arr4 = { "coconut", "humus", "kale", "peas", "pizza", "wasabi" };

		MergeSortedArrays ms1 = new MergeSortedArrays(arr1, arr2);
		printResults(ms1);

		MergeSortedArrays ms2 = new MergeSortedArrays(arr2, arr3);
		printResults(ms2);

		MergeSortedArrays ms3 = new MergeSortedArrays(arr4, arr1);
		printResults(ms3);

		MergeSortedArrays ms4 = new MergeSortedArrays(arr3, arr4);
		printResults(ms4);

	}

	private void testMinesweeperCalc() {
		int[][] bombs1 = { { 0, 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 0 }, { 0, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 0, 0 } };
		MinesweeperCalc mc1 = new MinesweeperCalc(bombs1);
		printResults(mc1);

		int[][] bombs2 = { { 0, 1, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 1, 1, 0, 0 }, { 0, 1, 0, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0 } };
		MinesweeperCalc mc2 = new MinesweeperCalc(bombs2);
		printResults(mc2);
	}

	private void testNthFibbonacci() {
		NthFibbonacci nf1 = new NthFibbonacci(1);
		printResults(nf1);

		NthFibbonacci nf2 = new NthFibbonacci(10);
		printResults(nf2);

		NthFibbonacci nf3 = new NthFibbonacci(30);
		printResults(nf3);
	}

	private void testPartyGreeting() {

		PartyGreeting pg1 = new PartyGreeting(new String[] {});
		printResults(pg1);

		PartyGreeting pg2 = new PartyGreeting(new String[] { "Zelda" });
		printResults(pg2);

		PartyGreeting pg3 = new PartyGreeting(new String[] { "Yancy", "Zelda" });
		printResults(pg3);

		PartyGreeting pg4 = new PartyGreeting(new String[] { "Xander", "Yancy", "Zelda" });
		printResults(pg4);

		PartyGreeting pg5 = new PartyGreeting(new String[] { "Urkel", "Willow", "Xander", "Yancy", "Zelda" });
		printResults(pg5);

	}

	private void testRangeValue() {

		RangeValue rv1 = new RangeValue(new double[] { 0.5, 4.7, 41.2, -15 });
		printResults(rv1);

		RangeValue rv2 = new RangeValue(new double[] { 17.5, -6.7, 15, 0.0, 7.1 });
		printResults(rv2);

	}

	private void testSampleProblem() {
		SampleProblem sp1 = new SampleProblem("The quick brown fox jumps over the lazy dog.");
		printResults(sp1);

		SampleProblem sp2 = new SampleProblem("Injustice anywhere is a threat to justice everywhere.");
		printResults(sp2);

	}

	private void testSeasonCalendar() {
		SeasonCalendar sc1 = new SeasonCalendar(3, 20);
		printResults(sc1);

		SeasonCalendar sc2 = new SeasonCalendar(4, 27);
		printResults(sc2);

	}

	private void testStackingBlocks() {
		StackingBlocks sb1 = new StackingBlocks(3);
		printResults(sb1);

		StackingBlocks sb2 = new StackingBlocks(8);
		printResults(sb2);

		StackingBlocks sb3 = new StackingBlocks(12);
		printResults(sb3);
	}

	private void testStringSelectionSortIgnoreCase() {
		StringSelectionSortIgnoreCase ss1 = new StringSelectionSortIgnoreCase(new String[] { "beans", "Watermelon",
				"yam", "TACOS", "kale", "fRuit", "wasabi", "peas", "coconut", "pizza", "Doritos", "udon", "vanilla",
				"fudge", "oreos", "humus", "oAtMeal", "eggs", "ICE CREAM", "brownie", "cookies", "Carrots", "GINGER",
				"eggplant", "apple pie", "apple", "Yogurt", "doughnut", "orange", "LEMON" });

		printResults(ss1);

		StringSelectionSortIgnoreCase ss2 = new StringSelectionSortIgnoreCase(
				new String[] { "Zelda", "Yancy", "Xander", "Willow", "Urkel" });
		printResults(ss2);

	}

	private void testStringShuffler() {

		ArrayList<String> list1 = new ArrayList<String>(
				Arrays.asList(new String[] { "apple", "apple pie", "beans", "brownie", "Carrots", "coconut" }));
		StringShuffler ss1 = new StringShuffler(list1);
		printResults(ss1);

		ArrayList<String> list2 = new ArrayList<String>(
				Arrays.asList(new String[] { "ice cream", "DORITIOS", "doughnut", "oreo", "Fudge", "popcorn" }));
		StringShuffler ss2 = new StringShuffler(list2);
		printResults(ss2);

	}

	private void testSumOfDigits() {
		SumOfDigits sd1 = new SumOfDigits(1235);
		printResults(sd1);

		SumOfDigits sd2 = new SumOfDigits(-9874);
		printResults(sd2);
	}

	private void testTallyLetters() {
		TallyLetters tl1 = new TallyLetters("The quick brown fox jumped over the lazy dog");
		printResults(tl1);

		TallyLetters tl2 = new TallyLetters("apple, apple pie, beans, brownie, Carrots, "
				+ "coconut, cookies, Doritos, doughnut, eggplant, " + "eggs, fRuit, fudge, GINGER, humus, ICE CREAM, "
				+ "kale, LEMON, oAtMeal, orange, oreos, peas, pizza, "
				+ "TACOS, udon, vanilla, wasabi, Watermelon, yam, Yogurt");
		printResults(tl2);

	}

	private void testTo2DArray() {
		To2DArray td1 = new To2DArray(new int[] { 1, 2, 3, 4, 5, 6 }, 3, 2);
		printResults(td1);

		To2DArray td2 = new To2DArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 4, 3);
		printResults(td2);

		To2DArray td3 = new To2DArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 2, 3);
		printResults(td3);

	}

	private void testCalculateHeronArea() {
		TriangeAreaHeron ta1 = new TriangeAreaHeron(4.5, 7.3, 9.1);
		printResults(ta1);

		TriangeAreaHeron ta2 = new TriangeAreaHeron(5.8, 12.7, 6.1);
		printResults(ta2);

		TriangeAreaHeron ta3 = new TriangeAreaHeron(7.4, -2.0, 6.3);
		printResults(ta3);
	}

	private void testUniqueStrings() {
		UniqueStrings us1 = new UniqueStrings(new String[] { "ant", "dog", "CAT", "bear", "dog", "cat", "eagle" });
		printResults(us1);

		String[] singers2 = { "Elvis", "Elvis", "Prince", "Adele", "Eminem", "Beyonce", "Bono", "Adele", "Prince",
				"Beyonce", "Elvis", "Rihanna" };
		UniqueStrings us2 = new UniqueStrings(singers2);
		printResults(us2);

	}

	private void printResults(ProblemIO pio) {
		textArea.append(pio.problemHeader() + "\n");
		textArea.append(pio.problemInput() + "\n");
		textArea.append(pio.problemOutput() + "\n\n");
	}

	/*
	 * This method gets the contents of the scroll box and saves it to a file
	 * selected
	 */
	private void saveResultsToFile() {

		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = fc.showOpenDialog(frame);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fc.getSelectedFile();
				PrintStream ps = new PrintStream(file);
				Scanner sc = new Scanner(textArea.getText());
				while (sc.hasNextLine()) {
					String outStr = sc.nextLine();
					ps.println(outStr);
				}
				sc.close();
				ps.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
