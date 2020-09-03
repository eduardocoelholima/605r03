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

	text		  = "type_here";
	patternDefinition = "a+b*";
	System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );

	patternDefinition = "x[a-z]+b";
	System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );

	patternDefinition = "^a[a-z][b-z]i";
	System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );

	patternDefinition = "\\s\\S\\w";
	System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );

	patternDefinition = "a*b*c*.";
	System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );

	patternDefinition = "[0-9]{3}t[0-9]{2}";
	System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );

	patternDefinition = "[0-9]{3}\\.[0-9]{2}";
	System.out.println(text + " is matched by " + patternDefinition +  ": " + Pattern.matches(patternDefinition, text) );

    }
}
