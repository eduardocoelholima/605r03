import java.lang.StringBuilder;

/**
 * Here are a few questions for us to think about:
 * - What does the theDigits method do?
 *   - What asDigits store?
 *   - What asCharacters store?
 *   - What the loop is doing?
 * - Is this solution a recursive solution?
 * - In method hasProperty, when does it return true?
 *   - What is the purpose of seenThisNumber[]?
 *
 */

public class Number {
	static int START 		= 4;
	static int END	 		= 4;
	static String theDetail;


	public static int[] theDigits(int number)	{
		String theNumberAsString = "" + number;
		int[] asDigits = new int[theNumberAsString.length()];
		char[] asCharacters = theNumberAsString.toCharArray();
		for (int index = 0; index < asCharacters.length; index ++ )	{
			asDigits[index] = Integer.parseInt("" + asCharacters[index]);
		}

		return asDigits;

	}

	public static boolean hasProperty(int number)	{

		int[] theDigits = theDigits(number);
		boolean[] seenThisNumber = new boolean[1000];

		theDetail = "";
		int result = 0;
		do {
			seenThisNumber[result] = true;
			result = 0;
			for (int index = 0; index < theDigits.length; index ++ )	{
				result += (int)Math.pow(theDigits[index], 2 );
				theDetail += theDigits[index] + "^2 ";
			}
			System.out.println(number + "/" + result);
			theDetail += " = " + result  + " | " ;
			theDigits = theDigits(result);
		} while ( ( result != 1 ) && (  !seenThisNumber[result] ) );
		return result == 1;
	}

	public static void main( String args[] ) {
		for ( int numberToTest = START; numberToTest <= END; numberToTest ++ )	{
			if ( hasProperty(numberToTest) )	{
				System.out.println(numberToTest + ": " + theDetail);
			}
		}
	}
}
