/**
 * Palindrome.java
 *
 * Version:
 *      $Id$
 *
 * Revision:
 *      $Log$
 *
 */

import java.lang.StringBuilder;

/**
 * Solution for homework 2.2
 *
 * @author Hans-Peter Bischof
 * @custom.comment Eduardo Lima
 *
 * Here are a few questions for us to think about:
 * - You have two loops in the main method. What are the outer loop iterating?
 * - What is rebmuNeht? And lanigiro?
 * - Why is padding being added if ( ( ( theNumber / 10 ) * 10 ) == theNumber )?
 * - What is resultString.equals( resultStringReverse ) testing?
 * - Why is firstNumberofSequence is passed as an argument for
 *   delayedPalindrome()?
 * - What does it means to have a return of 0 after calling delayedPalindrome()?
 * - When can I tell for sure a number is not a Lychrel number?
 * - Is a delayed palindrome a Lychrel number?
 *
 */
public class Palindrome {
	static int START = 72;
	static int END = 170;
	static int MAXIMUM_DELAYED 	= 40; // 20

	public static int delayedPalindrome(int firstNumberofSequence, int theNumber, int delayed)	{
		boolean isDelayed	= false;
		int rValue = 0;

		String 	original = Integer.toString(theNumber);
		StringBuilder aStringBuilder = new StringBuilder(original);
		String  lanigiro = aStringBuilder.reverse().substring(0);
		int	rebmuNeht   = Integer.valueOf(lanigiro);
		int result = theNumber + rebmuNeht;
		String resultString  = Integer.toString(result);
		String resultStringReverse  = new StringBuilder(resultString).reverse().substring(0);
		rValue =  theNumber + rebmuNeht;// might be overwritten with -1; end of search
		String leftPadding = "";
		if  ( ( (theNumber / 10 ) * 10 ) == theNumber )
			leftPadding = "0";
		boolean notAlychrelNumber = ( ( delayed <= MAXIMUM_DELAYED ) && resultString.equals(resultStringReverse ) );
		boolean lastTry           = ( ( delayed == MAXIMUM_DELAYED ) && ! resultString.equals(resultStringReverse ) );
		if  ( notAlychrelNumber || lastTry ) {
			System.out.print(firstNumberofSequence + ":     " );
			System.out.print("\tdelayed " + delayed);
			if ( notAlychrelNumber ) {
				// add
				System.out.println(":   " + theNumber + "\t+\t" +  leftPadding + rebmuNeht + "\t=\t" + ( theNumber + rebmuNeht) );
				rValue = 0;   //  stopping condition for the outer loop
			} else {
				System.out.println(":   does not become palindromic within " + MAXIMUM_DELAYED + " iterations (" + theNumber + " + "
						+ rebmuNeht + " = "  + resultString + ": "
						+ resultString + " != " + resultStringReverse + ")" );
			}
		}
		return rValue;
	}

	public static void main( String args[] ) {
		for ( int numberToTest = START; numberToTest <= END; numberToTest ++ )	{
			int theNextnumber = 1;
			for ( int delayed = 1; ( theNextnumber > 0 ) && ( delayed <= MAXIMUM_DELAYED ) ; delayed ++ )	{
				// numberToTest only needed for the print
				theNextnumber = delayedPalindrome(numberToTest, delayed == 1 ? numberToTest : theNextnumber, delayed);
			}
		}
	}
}
