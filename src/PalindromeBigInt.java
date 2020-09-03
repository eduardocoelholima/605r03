/*
 * From: https://en.wikipedia.org/wiki/Lychrel_number
 * In the 1980s, the 196 palindrome problem attracted the attention of microcomputer hobbyists,
 * with search programs by Jim Butterfield and others appearing in several mass-market computing magazines.[7][8][9]
 * In 1985 a program by James Killman ran unsuccessfully for over 28 days, cycling through 12,954 passes and reaching a 5366-digit number.[9]
 * time java %
 * real	0m7.714s
 * user	0m15.951s
 * sys	0m0.516s
 */
import java.lang.StringBuilder;
import java.math.BigInteger;

public class PalindromeBigInt {
/*
	static int START 		= 196;
	static int END	 		= 196;
	static int MAXIMUM_DELAYED 	= 12955;
*/
/*
	static BigInteger START 		= new BigInteger("1186060307891929990");
	static BigInteger END	 		= new BigInteger("1186060307891929990");
	static int MAXIMUM_DELAYED 	= 12955;
*/
	static BigInteger START 	= new BigInteger("72");
	static BigInteger END	 	= new BigInteger("170");
	static int MAXIMUM_DELAYED 	= 60;
/*
	From Palindrom.java
        static int START                = 72;
        static int END                  = 170;
        static int MAXIMUM_DELAYED      = 60; // 20
	// Exception in thread "main" java.lang.NumberFormatException: For input string: "2284457131"
*/

	public static BigInteger  delayedPalindrome(BigInteger firstNumberofSequence, BigInteger theNumber, int delayed)	{
		BigInteger rValue = new BigInteger("0");

		String 	    original    = theNumber.toString();
		BigInteger  rebmuNeht   = new BigInteger(new StringBuilder(original).reverse().toString());

		String resultString  = theNumber.add(rebmuNeht).toString();
		String resultStringReverse  = new StringBuilder(resultString).reverse().toString();
		rValue =  theNumber.add(rebmuNeht);		// might be overwritten with -1; end of search
		// String leftPadding =  ( ( (theNumber / 10 ) * 10 ) == theNumber ) ? "0" : "";
		String leftPadding =  "";
			
		boolean notAlychrelNumber = ( ( delayed <= MAXIMUM_DELAYED ) &&   resultString.equals(resultStringReverse ) );
		boolean lastTry           = ( ( delayed == MAXIMUM_DELAYED ) && ! resultString.equals(resultStringReverse ) );
		if  ( notAlychrelNumber || lastTry ) {
			System.out.print(firstNumberofSequence + ":	" );
			System.out.print("\tdelayed " + delayed);
			if  ( notAlychrelNumber )	{
				System.out.println(":	" + theNumber + "\t+\t" +  leftPadding + rebmuNeht + "\t=\t" + ( theNumber.add(rebmuNeht) ) );
				rValue = new BigInteger("0");	// -1 --> 1-
			} else {
				System.out.println(":	does not become palindromic within " + MAXIMUM_DELAYED + " iterations (" + theNumber + " + " 
					 + rebmuNeht + " = "  + resultString + ": " 
					 + resultString + " != " + resultStringReverse + ")" );
			}
		}
		return rValue;
	}
	public static void main( String args[] ) {
		BigInteger end = new BigInteger("0");
		BigInteger numberToTestBigInteger = START;
		while (  ! numberToTestBigInteger.equals(END) )	{
			BigInteger theNextnumber = new BigInteger("1");
			int  delayed = 1;
			do {
				theNextnumber = delayedPalindrome(numberToTestBigInteger, delayed == 1 ? numberToTestBigInteger : theNextnumber, delayed);
			} while  ( (! theNextnumber.equals(end) ) && ( delayed++ <= MAXIMUM_DELAYED )  );
			numberToTestBigInteger = numberToTestBigInteger.add(BigInteger.ONE );
		}
	}
}
