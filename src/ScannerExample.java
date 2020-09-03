/**
 * ScannerExample.java
 *
 * Version:
 *      $Id
 *
 * Revision:
 *      $Log
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Simple example usages of Scanner
 *
 * - Here we can observe the use of the classes Vector, Scanner and File
 * - You can practice your understanding by commenting the code
 * - words.txt should be passed as run argument
 *
 */
public class ScannerExample {

    Vector<String> words = new Vector<>();

    private void fillVector(Scanner words)	{
        while ( words.hasNext() )
            this.words.add( words.next() );
    }

    private void parseArg( String arg ) throws FileNotFoundException {
        Scanner words = new Scanner( new File( arg ) );
        fillVector( words );
        words.close();
    }

    public String toString() {
        String string = new String();
        for (String word: words) {
            string += word + " ";
        }
        return string;
    }

    public static void main (String [] args ) throws FileNotFoundException {
        ScannerExample run = new ScannerExample();
        System.out.println( "Reading from " + args[0] );
        run.parseArg( args[0] );
        System.out.println( run );
    }

}
