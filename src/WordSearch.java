
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Here are a few questions for us to think about:
 * - printPuzzle takes a boolean as argument. What does it do?
 * - What does addVerticalLinesToPuzzle do?
 *   - What does the first loop do?
 *   - What does the second loop do?
 * - What are the puzzleOrig, puzzle and wordToSearchFor storing?
 * - When does checkForWord return true?
 *   - Why it does not return the row or column when it finds it?
 *
 */

public class WordSearch {

	static String[] puzzleOrig = {	"tomato",	// 6 x 6
			"omelet",
			"carrot",
			"onions",
			"garlic",
			"bagels"
	};
	static int puzzleLenght = puzzleOrig.length;
	static String[] puzzle = new String[puzzleLenght * 2 ];
	static String wordsToSearchFor[] = { "to", "me", "ma", "on" };

	public static String reverseStringR(String original) {
		if ( original.length() == 1 ) {
			return original;
		}
		return reverseString(original.substring(1)) + original.substring(0, 1);
	}

	public static String reverseString(String original) {
		String rValue = "";
		StringBuilder aStringBuilder = new StringBuilder(original);
		rValue = aStringBuilder.reverse().toString();
		return rValue;
	}

	public static void printNiceIfFound(String searchWord, int row)	{
		String rowOrColumn = row < puzzleLenght ? "row" : "column";
		System.out.println("Found \"" + searchWord + "\" in " + rowOrColumn +
				": "  + row % puzzleLenght + " " +  puzzle[row]);
	}

	public static void printPuzzleExpected(boolean orig)	{
		if ( orig )	{
			for (int row = 0; row < puzzleOrig.length; ++row) {
				System.out.println(row + ":	" +  puzzleOrig[row]);
			}
		} else {
			for (int row = 0; row < puzzle.length; ++row) {
				System.out.println(row + ":	" +  puzzleOrig[row]);
			}
		}
	}

	public static void printPuzzle(boolean orig)	{
		for (int row = 0; row < ( orig ? puzzleOrig.length : puzzle.length ) ; ++row) {
			System.out.println(row + ":	" +
					( orig ? puzzleOrig[row] : puzzle[row]) );
		}
	}

	public static boolean checkForWord(String searchWord) {
		boolean retVal = false;
		for (int row = 0; row < puzzle.length; ++row) {
			if ( puzzle[row].indexOf(searchWord) >= 0 )	{
				printNiceIfFound(searchWord, row);
				retVal = true;
			}
		}
		return retVal;
	}

	public static void addVerticalLinesToPuzzle() {
		boolean retVal = false;
		int	addAtThisLinePostion = puzzleLenght;

		for (int line = 0; line < puzzleLenght; ++line) {
			puzzle[line] = puzzleOrig[line];
		}
		for (int col = 0; col < puzzleLenght; ++col) {
			String colString = "";
			for( int row = 0; row < puzzleLenght; ++row) {
				colString += puzzle[row].substring(col, col + 1);
			}
			puzzle[addAtThisLinePostion++] = colString;
		}
	}

	public static void searchForStringInPuzzle() {
		for ( int index = 0; index < wordsToSearchFor.length; index ++ )	{
			System.out.println("Searching for: " + wordsToSearchFor[index] );
			if (! checkForWord(wordsToSearchFor[index]) ) {
				System.out.println("Unable to find " + wordsToSearchFor[index]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		printPuzzle(true);
		addVerticalLinesToPuzzle();
		searchForStringInPuzzle();
	}
}
