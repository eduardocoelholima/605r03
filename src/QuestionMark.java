/**
 * QuestionMark.java
 *
 * Version:
 *      $Id$
 *
 * Revision:
 *      $Log$
 *
 */

/**
 * This is provided for homework 3.3
 *
 * Questions:
 * - What does (return (a > b)) do?
 * - What does (return a > b ? a : b) do?
 * - What is executed first in the last 2 lines of main()?
 * - What if with use a breakpoint in leftToRight()?
 */

public class QuestionMark {
	public static boolean aGreaterB(int a, int b)	{
		boolean rValue = false;
		if ( a > b )
			rValue = true;
		else
			rValue = false;
		return rValue;
	}

	public static int findMaximum(int a, int b)	{
		int rValue;
		if ( a > b )
			rValue = a;
		else
			rValue = b;
		return rValue;
	}

	public static int findMaximum(int a, int b, int c, int d)	{
		int rValue;
		int maxAndB = 0;
		int maxCndD = 0;
		if ( a > b )
			maxAndB = a;
		else
			maxAndB = b;

		if ( c > d )
			maxCndD = a;
		else
			maxCndD = b;
		if ( maxAndB > maxCndD )
			rValue = maxAndB;
		else
			rValue = maxCndD;
		return rValue;
	}

	public static int leftToRight(int a, int b)	{
		int rValue;
		if ( a != 0 ) {
			if ( b != 0 )
				rValue = a/b;
			else
				rValue = -1;
		} else {
			rValue = 0;
		}
		return rValue;
	}

	public static void main( String[] args ) {
		int a = 5;
		int b = 1;
		int c = 2;
		int d = 1;
		System.out.println("aGreaterB(" + a + "," + b + ") = " + aGreaterB(a, b ) );
		System.out.println("findMaximum(" + a + "," + b + ") = " + findMaximum(a, b ) );
		System.out.println("findMaximum(" + a + ", " + b + ", " + c + ", " + d + " ) = " +
				findMaximum(a, b, c, d ) );
		a = 0;
		b = 0;
		System.out.println("leftToRight(" + a++ + "," + b++ + ") = " + leftToRight(a, b ) );
		System.out.println("leftToRight(" + --a + "," + b + ") = " + leftToRight(a, b ) );
	}
}
