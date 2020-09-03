/**
 * Coins.java
 *
 * Version:
 *      $Id$
 *
 * Revision:
 *      $Log$
 *
*/

import java.util.Arrays;

/**
 * Solution for homework 2.1
 *
 * @author Hans-Peter Bischof
 * @custom.comment Eduardo Lima
 *
 * Here are a few questions for us to think about:
 * - What classical algorithm is implemented in sortCoins()?
 * - What does myCoins store?
 * - What does initMyCoins do?
 * - In soManyBitsAre1(), why are you evaluating ( myCoins[index] > 0 )?
 * - In calculateSumForThisSet(), you only pass (int value) as argument. Was
 * there any change compared to hw1.2? Will this method be able to calculate
 * combinations for the wallets' coins AND the cashiers' coins?
 *
 */
public class Coins {

	static int[] coinsInMyWallet =  { 1, 1, 1, 1, 5, 5, 10, 10, 10 };
	static int[] cashiersCoins = { 1, 1, 5 };
	static int[] toPay = { 23 };
	// static int[] coinsInMyWallet = {1, 5, 1, 1, 1 };
	// static int[] cashiersCoins = { 1, 2, 3 };
	// static int[] toPay = { 9, 6, 7, 8 };

	// cashier and my coins, but the chasier coins will be added as negative
	static int[] myCoins =
			new int[ coinsInMyWallet.length + cashiersCoins.length ];
	static int soManyCoins = myCoins.length;

	static String myCoinsInAstring;

	private static void printMyCoins() {
		for ( int index = 0; index < myCoins.length; index ++ )
			System.out.println(index + " " + myCoins[index]);
	}

	private static void initMyCoins() {
		for ( int index = 0; index < coinsInMyWallet.length; index ++ )
			myCoins[index] = coinsInMyWallet[index];
		for ( int index = 0; index < cashiersCoins.length; index ++ )
			myCoins[index + coinsInMyWallet.length] = -cashiersCoins[index];

		myCoinsInAstring = Arrays.toString(myCoins);
		myCoinsInAstring = myCoinsInAstring.replace("[", " ");
		myCoinsInAstring = myCoinsInAstring.replace("]", " ");
	}

	private static void sortCoins() {
		for (int index = 0; index < myCoins.length - 1; index++)     {
			for (int walker = 0; walker < myCoins.length - 1; walker++)  {
				if ( myCoins[walker] > myCoins[walker+1] )        {
					int tmp = myCoins[walker];
					myCoins[walker] = myCoins[walker + 1];
					myCoins[walker+1] = tmp;
				}
			}
		}
	}

	private static String printUsedCoins(int value) {
		String cashiersCoinsReturnValue = "";
		String myCoinsReturnValue = "";

		for ( int index = soManyCoins; index >= 0 ; index --)	{
			if ( ( ( 1 << index ) & value ) == ( 1 << index ) )
				if ( myCoins[index] > 0 )
					myCoinsReturnValue += myCoins[index] + " cents ";
				else
					cashiersCoinsReturnValue += ( -1 * myCoins[index] ) + " cents ";
		}

		if ( myCoinsReturnValue == "" )
			myCoinsReturnValue = "empty set";
		if ( cashiersCoinsReturnValue == "" )
			cashiersCoinsReturnValue = "nothing";

		return myCoinsReturnValue + "\n\t\tand the cashier gave me "
				+ cashiersCoinsReturnValue;
	}

	private static int soManyBitsAre1(int value) {
		int returnValue = 0;
		for ( int index = soManyCoins; index >= 0 ; index --)	{
			if ( ( ( ( 1 << index ) & value ) == ( 1 << index ) )
					&& ( myCoins[index] > 0 ) )	{
				returnValue ++;
			}
		}
		return returnValue;
	}

	private static int calculteSumForThisSet(int value) {
		int sum = 0;
		for ( int index = soManyCoins - 1; index >= 0 ; index --)    {
			if ( ( ( 1 << index ) & value ) == ( 1 << index ) )	{
				sum += myCoins[index];
			}
		}
		return sum;
	}

	private static void testIfaCombinationForThisSumExist(int thisSum)	{
		int setSize = (int)Math.pow( 2, myCoins.length );
		boolean foundAset = false;
		int largestSetSoFar	= 0;

		int index = 0; // see comment in loop

		if ( thisSum == 0 )	{
			System.out.println("0 cents:\t\tcan not be paid");
		}
		else {
			// main loop to test all possible combinations
			while  ( index < setSize ) {
				int sum = calculteSumForThisSet( index );
				if ( ( thisSum == sum ) )	{
					if ( soManyBitsAre1( largestSetSoFar ) < soManyBitsAre1( index ) )
						largestSetSoFar = index;
				}
				index ++;
			}

			if ( soManyBitsAre1( largestSetSoFar ) > 0 )
				System.out.println(thisSum + " cents:	"       +
						"I gave the cashier the following coins " +
						printUsedCoins( largestSetSoFar ) );
			else
				System.out.println(thisSum + " cents:	"       +
						"no; can not be paid with the following sequence of " +
						"coins: " + Arrays.toString( myCoins ));
		}
	}

	public static void main( String[] args ) {
		initMyCoins();
		sortCoins();	// not needed but produces sorted output
		for ( int index = 0; index < toPay.length; index ++ )
			testIfaCombinationForThisSumExist( toPay[index] );
	}
}
