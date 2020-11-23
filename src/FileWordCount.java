
/* 
File Word Count takes a file name as input and returns the number of words/tokens in the file.
Note that tokens are divided by one or more "white space" characters and that a file with no
path information is in the root of the project or in the same folder as the jar file.
Test output:

File Word Count
file1.txt
1784

File Word Count
file2.txt
847
*/

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class FileWordCount implements ProblemIO {
	String fileName;
	File thisFile;

	public FileWordCount(String fileName) {
		this.fileName = fileName;
		thisFile = new File(fileName);

	}

	/*
	 * countWords() counts the number of words in the file using an object. YOU
	 * MUST IMPLEMENT THIS METHOD
	 */
	public int countWords() {
		List<String> fileData = new ArrayList<String>();
		try {
			fileData = Files.readAllLines(thisFile.toPath());
		} catch (IOException e) {
			// Exception buried
		}
		int count = 0;
		for (String str : fileData) {
			count += str.split(" ").length;
		}
		return count;
	}

	@Override
	public String problemHeader() {
		return "File Word Count";
	}

	@Override
	public String problemInput() {
		return this.fileName;
	}

	@Override
	public String problemOutput() {
		return Integer.toString(countWords());
	}

}
