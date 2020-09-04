/**
 * PatternQuestions.java
 *
 * Version:
 *      $Id$
 *
 * Revision:
 *      $Log$
 *
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Examples using patterns
 *
 * Questions:
 * - Lets find a couple of examples to match the given pattern definitions
 *
 * More:
 * - If you still did not, you should read this:
 *   https://docs.oracle.com/en/java/javase/14/docs/api/java.base/
 *   java/util/regex/Pattern.html
 * - Professor Bischof also mentioned you should read this:
 *   https://docs.oracle.com/javase/tutorial/essential/regex/quant.html
 *
 */
public class PatternQuestions {

    public static void main(String[] args) {
// Find a text to match the pattern
		String patternDefinition;
		String text;


		// Examples using find()

		text = "Evil is Evil. Lesser, greater, middling... Makes no " +
				"difference. The degree is arbitrary. The definition’s " +
				"blurred. If I’m to choose between one evil and another... " +
				"I’d rather not choose at all.";

		patternDefinition = "Evillll".toLowerCase();
		Pattern stringPattern = Pattern.compile( patternDefinition );
		Matcher m = stringPattern.matcher( text );
		System.out.println( "Pattern " + patternDefinition + " matched text: " +
				m.find() );

		patternDefinition = "EVIL".toLowerCase();
		Pattern stringPattern2 = Pattern.compile( patternDefinition );
		Matcher m2 = stringPattern2.matcher( text );
		System.out.println( "Pattern " + patternDefinition + " matched text: " +
				m2.find() );

		// Examples using matches()

//		text = "123.12";
//
//		patternDefinition = "a+b*";
//		System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );
//
//		patternDefinition = "x[a-z]+b";
//		System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );
//
//		patternDefinition = "a[a-z][b-z]i";
//		System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );
//
//		patternDefinition = "\\s\\S\\w";
//		System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );
//
//		patternDefinition = "a*b*c*";
//		System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );
//
//		patternDefinition = "[0-9]{3}t[0-9]{2}";
//		System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );
//
//		patternDefinition = "[0-9]{3}\\.[0-9]{2}";
//		System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );

    }
}
